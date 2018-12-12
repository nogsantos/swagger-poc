package me.fabricionogueira.api.modules.hello;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface HelloMapper {

	HelloDTO toDTO(Hello hello);

}
