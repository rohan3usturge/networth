package com.networth.infra.mapper;

import java.lang.reflect.Type;

public interface InfraMapper {

	public <D> D map(Object source, Class<D> destinationType);

	public void map(Object source, Object destination);
	
	public <D> D map(Object source, Type destinationType);

}
