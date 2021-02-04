package com.networth.infra.mapper;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class ModelMapperBasedInfraMapper implements InfraMapper {

	private ModelMapper modelMapper;

	public ModelMapperBasedInfraMapper(ModelMapper modelMapper) {
		super();
		this.modelMapper = modelMapper;
	}

	public <D> D map(Object source, Class<D> destinationType) {
		return this.modelMapper.map(source, destinationType);
	}

	@Override
	public <D, T> List<D> mapAll(Collection<T> entityList, Class<D> outCLass) {
		return entityList.stream().map(entity -> map(entity, outCLass)).collect(Collectors.toList());
	}

}
