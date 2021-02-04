package com.networth.infra.mapper;

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

}
