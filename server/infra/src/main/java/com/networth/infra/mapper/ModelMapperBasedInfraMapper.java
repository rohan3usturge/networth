package com.networth.infra.mapper;

import java.lang.reflect.Type;

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

	public void map(Object source, Object destination) {
		this.modelMapper.map(source, destination);
	}

	@Override
	public <D> D map(Object source, Type destinationType) {
		return this.modelMapper.map(source, destinationType);
	}

}
