package com.estock.api.config.mybatis.handler;

import java.lang.reflect.ParameterizedType;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.estock.api.common.type.Type;
import com.estock.api.util.TypeUtils;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;

@MappedTypes(Type.class)
public class NullAwareTypeHandler<E extends Enum<E> & Type<?>> extends AbstractTypeHandler<E> {

	private Class<E> enumClass;
	private Class<?> valueClass;
	
	public NullAwareTypeHandler(Class<E> enumClass) {
		if (enumClass == null) {
			throw new IllegalArgumentException("enumClass must not be null");
		}
		this.enumClass = enumClass;
		
		if (!enumClass.isAssignableFrom(Type.class)) {
			valueClass = (Class<?>) ((ParameterizedType) enumClass.getGenericInterfaces()[0])
					.getActualTypeArguments()[0];
		}
	}
	
	@Override
	public void setParameter(PreparedStatement ps, int i, E parameter, JdbcType jdbcType) throws SQLException {
		if (parameter == null && valueClass != null) {
			Object defaultValue = TypeUtils.getDefaultValue(valueClass);
			ps.setObject(i, defaultValue);
		} else {
			super.setParameter(ps, i, parameter, jdbcType);
		}
	}

	@Override
	public E getType(Object dbValue) {
		return getEnumType(dbValue);
	}

	@Override
	public Object getDBValue(E type) {
		if (type == null) {
			return TypeUtils.getDefaultValue(valueClass);
		}
		return type.getValue();
	}
	
	protected E getEnumType(Object dbValue) {
		if (dbValue != null) {
			E[] enumConstants = enumClass.getEnumConstants();
			for (E enumContaint : enumConstants) {
				Object enumValue = enumContaint.getValue();
				if (enumValue.equals( dbValue ) ) {
					return enumContaint;
				}
			}
		}
		return null;
	}

	public Class<E> getEnumClass() {
		return enumClass;
	}
}