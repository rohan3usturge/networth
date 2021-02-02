package com.networth.infra.mapper;

import java.util.Collection;
import java.util.List;

public interface InfraMapper {

	public <D> D map(Object source, Class<D> destinationType);

	public <D, T> List<D> mapAll(Collection<T> entityList, Class<D> outCLass);

}
