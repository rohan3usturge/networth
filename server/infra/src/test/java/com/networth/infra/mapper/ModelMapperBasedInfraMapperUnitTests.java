package com.networth.infra.mapper;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;

public class ModelMapperBasedInfraMapperUnitTests {

    @Test
    public void shouldCallModelMapper() {
        ModelMapper modelMapper = Mockito.mock(ModelMapper.class);
        InfraMapper mapper = new ModelMapperBasedInfraMapper(modelMapper);
        Object source = new Object();
        Class<String> destinationType = String.class;
        mapper.map(source, destinationType);
        verify(modelMapper, times(1)).map(source, destinationType);
    }

}
