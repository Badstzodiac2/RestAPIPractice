package com.example.section8.services.impl;

import com.example.section8.dto.AutoUserMapper;
import com.example.section8.dto.UserMapper;
import com.example.section8.dto.UsersDto;
import com.example.section8.entity.Users;
import com.example.section8.exception.ResourceNotFoundException;
import com.example.section8.repository.UsersRepository;
import com.example.section8.services.UserService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UsersRepository repository;

    private ModelMapper modelMapper;

    @Override
    public UsersDto createUser(UsersDto users) {
        //Transfer from Users to UserDto
//        Users users1 = modelMapper.map(users, Users.class);
        Users users1 = AutoUserMapper.MAPPER.mapToUserJpa(users);
        Users savedUsers = repository.save(users1);
        UsersDto usersDto = AutoUserMapper.MAPPER.mapToUserDto(savedUsers);
        return usersDto;
    }

    @Override
    public UsersDto getById(Long id) {
        Users users = repository.findById(id).orElseThrow(
                ()  -> new ResourceNotFoundException("User", "Id", id)
        );
        return AutoUserMapper.MAPPER.mapToUserDto(users);
    }

    @Override
    public List<UsersDto> getAllUser() {
        List<Users>list = repository.findAll();
        return list.stream().map(users -> AutoUserMapper.MAPPER.mapToUserDto(users))
                .collect(Collectors.toList());
    }

    @Override
    public UsersDto updateUsers(Long id, UsersDto userUpdate) {
        //create an user to find if exist or not
        Users users = repository.findById(id).orElseThrow(
                ()  -> new ResourceNotFoundException("User", "Id", id)
        );
            users.setFirstName(userUpdate.getFirstName());
            users.setLastName(userUpdate.getLastName());
            users.setEmail(userUpdate.getEmail());
            // save the updated user, if user not exist, create a new one
//            return modelMapper.map(repository.save(updatedUser), UsersDto.class);
            return AutoUserMapper.MAPPER.mapToUserDto(repository.save(users));
    }

    @Override
    public void deleteUser(Long id) {
        Optional<Users> users = repository.findById(id);
        if(users.isPresent()){
            Users users1 = users.get();
            repository.delete(users1);
        }
    }
}
