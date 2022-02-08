package com.estock.api.config.mybatis.interceptor;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.util.List;

import com.estock.api.common.type.Type;
import com.estock.api.config.mybatis.annotation.DefaultValue;
import com.estock.api.config.mybatis.handler.AbstractTypeHandler;
import com.estock.api.config.mybatis.util.SqlFormatter;
import com.estock.api.util.BeanUtils;
import com.estock.api.util.TypeUtils;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang3.ClassUtils;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.ParameterMapping;
import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.property.PropertyTokenizer;
import org.apache.ibatis.scripting.xmltags.ForEachSqlNode;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.defaults.DefaultSqlSession;
import org.apache.ibatis.session.defaults.DefaultSqlSession.StrictMap;
import org.apache.ibatis.type.TypeHandler;
import org.apache.ibatis.type.TypeHandlerRegistry;


import lombok.extern.slf4j.Slf4j;

@Slf4j
@SuppressWarnings("deprecation")
@Intercepts({ @Signature(type = Executor.class, method = "update", args = { MappedStatement.class, Object.class }),
		@Signature(type = Executor.class, method = "query", args = { MappedStatement.class, Object.class,
				RowBounds.class, ResultHandler.class }) })
public class CustomeInterceptor implements Interceptor {

	private boolean prettyPrint = true;
	
	@SuppressWarnings({ "unchecked" })
	@Override
	public Object intercept(Invocation invocation) throws Throwable {
		try {
			// NOTED: prettyPrint sql
			if (prettyPrint) {
				String sql = generateSQL(invocation);
				
				sql = SqlFormatter.format(sql);
				
				log.debug("==> SQL: {}", sql);
			}

			// NOTED: initField
			MappedStatement stmt = (MappedStatement) invocation.getArgs()[0];
			Object object = invocation.getArgs()[1];

			SqlCommandType sqlCommandType = stmt.getSqlCommandType();

			if (object instanceof StrictMap<?>) {
				StrictMap<?> map = (StrictMap<?>) object;
				List<Object> list = (List<Object>) map.get("list");

				initFieldWithList(sqlCommandType, list);

			} else {
				initField(sqlCommandType, object);
			}

			// NOTED: DefaulValue setting
			/*
			 * MappedStatement stmtDefault = (MappedStatement) invocation.getArgs()[0];
			 * 
			 * SqlCommandType sqlCommandTypeDefaul = stmtDefault.getSqlCommandType(); Object
			 * objectDefault = null; if (sqlCommandTypeDefaul == SqlCommandType.INSERT) {
			 * objectDefault = invocation.getArgs()[1];
			 * 
			 * Class<? extends Object> objectClass = objectDefault.getClass(); if
			 * (List.class.isAssignableFrom(objectClass)) {
			 * 
			 * } else { // Pojo initDefaultValue(objectDefault); } }
			 */

		} catch (Exception e) {
			log.debug("Error intercept : ", e);
			throw e;
		}

		return invocation.proceed();
	}

	@Override
	public Object plugin(Object target) {
		return Plugin.wrap(target, this);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	protected String generateSQL(Invocation invocation) throws Exception {
		String sql = null;

		try {
			Object object = invocation.getArgs()[1];

			MappedStatement mappedStatement = (MappedStatement) invocation.getArgs()[0];
			BoundSql boundSql = mappedStatement.getBoundSql(object);

			Configuration configuration = mappedStatement.getConfiguration();
			TypeHandlerRegistry typeHandlerRegistry = configuration.getTypeHandlerRegistry();

			sql = boundSql.getSql().replaceAll("\\n", "").replaceAll("\\s{2,}", " ");

			List<ParameterMapping> parameterMapping = boundSql.getParameterMappings();
			for (ParameterMapping pm : parameterMapping) {
				Class<?> paramType = pm.getJavaType();
				String paramName = pm.getProperty();
				PropertyTokenizer propTokenizer = new PropertyTokenizer(paramName);

				Object paramValue = object;
				if (paramName.startsWith(ForEachSqlNode.ITEM_PREFIX)
						&& boundSql.hasAdditionalParameter(propTokenizer.getName())) {
					// for each
					paramValue = boundSql.getAdditionalParameter(propTokenizer.getName());
					if (paramValue != null) {
						if (paramValue.getClass().isEnum()) {
							paramValue = configuration.newMetaObject(paramValue).getValue(paramValue.toString());
						} else {
							if (propTokenizer.getChildren() != null) {
								paramValue = configuration.newMetaObject(paramValue)
										.getValue(propTokenizer.getChildren());
							}
						}
					}
				} else if (boundSql.getAdditionalParameter(paramName) != null) {
					// additional parameter
					paramValue = boundSql.getAdditionalParameter(paramName);
				} else {
					if (object != null && !CharSequence.class.isAssignableFrom(object.getClass())
							&& !ClassUtils.isPrimitiveOrWrapper(object.getClass())) {
						MetaObject metaObject = configuration.newMetaObject(object);

						paramType = metaObject.getGetterType(paramName);
						paramValue = metaObject.getValue(paramName);
					}
				}

				// global type handler
				TypeHandler<? extends Object> typeHandler = typeHandlerRegistry.getTypeHandler(paramType);
				if (typeHandler == null) {
					typeHandler = pm.getTypeHandler();
				}

				if (typeHandler != null && AbstractTypeHandler.class.isAssignableFrom(typeHandler.getClass())) {
					paramValue = ((AbstractTypeHandler) typeHandler).getDBValue(paramValue);
				}

				String formatParameterValue = formatParameterValue(paramValue);
				if (formatParameterValue != null && !formatParameterValue.isEmpty()) {
					formatParameterValue = formatParameterValue.replace("$", "\\$");
				}
				
				sql = sql.replaceFirst("\\?", formatParameterValue);
			}
		} catch (Exception e) {
			log.debug("Error generating SQL: ", sql, e);
			throw e;
		}

		return sql;
	}

	protected String formatParameterValue(Object obj) {
		String formatStr = null;
		if (obj != null) {
			Class<?> objClass = obj.getClass();
			if (CharSequence.class.isAssignableFrom(objClass) || Enum.class.isAssignableFrom(objClass)) {
				formatStr = String.format("'%s'", obj);
			} else {
				formatStr = obj.toString();
			}
		} else {
			formatStr = "null";
		}
		return formatStr;
	}

	public void initFieldWithList(SqlCommandType action, List<Object> list) {
		for (Object object : list) {
			initField(action, object);
		}
	}

	public void initField(SqlCommandType action, Object object) {
		switch (action) {
		case INSERT:
			beforeCreate(object);
			break;
		case UPDATE:
			beforeUpdate(object);
			break;
		default:
			break;
		}
	}

	protected void beforeCreate(Object object) {
		
	}

	protected void beforeUpdate(Object object) {

	}

	@SuppressWarnings("rawtypes")
	protected void initDefaultValue(Object object)
			throws IllegalAccessException, InvocationTargetException, NoSuchMethodException, InstantiationException {
		Field[] fields = object.getClass().getDeclaredFields();
		for (Field field : fields) {
			String fName = field.getName();
			Class<?> fType = field.getType();
			Integer modifiers = field.getModifiers();

			// not static field
			if (!Modifier.isStatic(modifiers)) {
				Object fValue = PropertyUtils.getProperty(object, fName);

				if (fValue == null) {
					DefaultValue defaultValueAnno = field.getAnnotation(DefaultValue.class);

					// primitive type
					if (ClassUtils.isPrimitiveOrWrapper(fType) || String.class.isAssignableFrom(fType)) {
						fValue = defaultValueAnno == null ? TypeUtils.getDefaultValue(fType) : defaultValueAnno.value();

						// type
					} else if (Type.class.isAssignableFrom(fType)) {
						if (defaultValueAnno != null) {
							Object defaultValue = defaultValueAnno.value();

							Object[] constants = fType.getEnumConstants();
							for (Object constant : constants) {
								if (constant.toString().equals(defaultValue)) {
									defaultValue = ((Type) constant).getValue();
									break;
								}
							}
							fValue = defaultValue;
						}
					}

					if (fValue != null) {
						fValue = BeanUtils.convert(fValue, fType);
						PropertyUtils.setProperty(object, fName, fValue);
					}
				}
			}
		}
	}
}
