package com.example.section8.services;

import com.example.section8.dto.UsersDto;
import com.example.section8.entity.Users;

import java.util.List;

public interface UserService {
    UsersDto createUser(UsersDto users);
    UsersDto getById(Long id);
    List<UsersDto> getAllUser();
    UsersDto updateUsers(Long id, UsersDto userUpdate);
    void deleteUser(Long id);
}
