package com.estock.api.config.mybatis.handler;


import com.estock.api.common.type.Type;

public class TypeHandler<E extends Enum<E> & Type<?>> extends AbstractTypeHandler<E> {

	private Class<E> enumClass;
	
	public TypeHandler(Class<E> enumClass) {
		if (enumClass == null) {
			throw new IllegalArgumentException("enumClass must not be null");
		}
		this.enumClass = enumClass;
	}

	@Override
	public E getType( Object dbValue ) {
		return getEnumType(dbValue);
	}

	@Override
	public Object getDBValue( E type ) {
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
}