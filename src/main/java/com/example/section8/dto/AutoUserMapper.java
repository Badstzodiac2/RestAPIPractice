package com.example.section8.dto;

import com.example.section8.entity.Users;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AutoUserMapper {
    AutoUserMapper MAPPER = Mappers.getMapper(AutoUserMapper.class);

    UsersDto mapToUserDto(Users users);

    Users mapToUserJpa(UsersDto usersDto);

}
