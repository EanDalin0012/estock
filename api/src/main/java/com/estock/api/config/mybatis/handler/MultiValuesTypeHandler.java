package com.estock.api.config.mybatis.handler;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.estock.api.common.type.MultiValuesType;
import com.estock.api.util.TypeUtils;
import org.apache.ibatis.type.JdbcType;


public class MultiValuesTypeHandler<E extends Enum<E>> extends AbstractTypeHandler<MultiValuesType<E>> {

	private Class<E> enumClass;
	
	public MultiValuesTypeHandler(Class<E> enumClass) {
		if (enumClass == null) {
			throw new IllegalArgumentException("enumClass must not be null");
		}
		this.enumClass = enumClass;
	}
	
	@Override
	public void setParameter(PreparedStatement ps, int i, MultiValuesType<E> parameter, JdbcType jdbcType) throws SQLException {
		if (parameter == null) {
			String binaryMaskString = TypeUtils.getBinaryMaskString(enumClass, null);
			ps.setString(i, binaryMaskString);
		} else {
			super.setParameter(ps, i, parameter, jdbcType);
		}
	}
	
	@Override
	public MultiValuesType<E> getType(Object dbValue) {
		MultiValuesType<E> multiValuesType = new MultiValuesType<>();
		
		if (dbValue != null) {
			multiValuesType = TypeUtils.getMultiValuesType(enumClass, dbValue.toString());
		}
		
		return multiValuesType;
	}

	@Override
	public Object getDBValue(MultiValuesType<E> multiValuesType) {
		return TypeUtils.getBinaryMaskString(enumClass, multiValuesType == null ? new MultiValuesType<E>() : multiValuesType);
	}
}