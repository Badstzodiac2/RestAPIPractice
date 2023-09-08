package com.example.section8.dto;

import com.example.section8.entity.Users;

public class UserMapper {

    //convert User JPA into UserDTO
    public static UsersDto mapToUserDTO(Users users){
        UsersDto usersDto = new UsersDto(
                users.getId(),
                users.getFirstName(),
                users.getLastName(),
                users.getEmail()
        );
        return usersDto;
    }

    //convert UserDTO to User JPA
    public static Users mapToUserJPA(UsersDto usersDto){
        Users users = new Users(
                usersDto.getId(),
                usersDto.getFirstName(),
                usersDto.getLastName(),
                usersDto.getEmail()
        );
        return users;
    }
}
