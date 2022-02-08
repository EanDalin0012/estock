package com.estock.api.config.mybatis.handler;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.estock.api.common.type.StringValuesType;
import com.estock.api.util.TypeUtils;
import org.apache.ibatis.type.JdbcType;


public class StringValuesTypeHandler<E extends Enum<E>> extends AbstractTypeHandler<StringValuesType<E>> {

	private Class<E> enumClass;
	
	public StringValuesTypeHandler(Class<E> enumClass) {
		if (enumClass == null) {
			throw new IllegalArgumentException("enumClass must not be null");
		}
		this.enumClass = enumClass;
	}
	
	@Override
	public void setParameter(PreparedStatement ps, int i, StringValuesType<E> parameter, JdbcType jdbcType) throws SQLException {
		if (parameter != null) {
			String binaryMaskString = TypeUtils.getEnumString(enumClass, parameter);
			ps.setString(i, binaryMaskString);
		} 
		else {
			ps.setString(i, "");
		}
	}
	
	@Override
	public StringValuesType<E> getType(Object dbValue) {
		StringValuesType<E> StringValuesType = new StringValuesType<>();
		
		if (dbValue != null) {
			StringValuesType = TypeUtils.getStringValuesType(enumClass, dbValue.toString() );
		}
		
		return StringValuesType;
	}

	@Override
	public Object getDBValue(StringValuesType<E> StringValuesType) {
		return TypeUtils.getEnumString(enumClass, StringValuesType == null ? new StringValuesType<E>() : StringValuesType);
	}
}