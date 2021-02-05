package com.networth.infra.mapper;

public interface InfraMapper {

	public <D> D map(Object source, Class<D> destinationType);

}
