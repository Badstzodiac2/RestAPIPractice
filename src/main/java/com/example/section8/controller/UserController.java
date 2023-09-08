package com.example.section8.controller;

import com.example.section8.dto.UserMapper;
import com.example.section8.dto.UsersDto;
import com.example.section8.entity.Users;
import com.example.section8.exception.ErrorDetails;
import com.example.section8.exception.ResourceNotFoundException;
import com.example.section8.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService service;

    @PostMapping("/create")
    public ResponseEntity<?>createUser(@RequestBody UsersDto users){
        UsersDto users1 = service.createUser(users);
        return new ResponseEntity<>(users1, HttpStatus.CREATED);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?>getUserById(@PathVariable("id") Long id){
        UsersDto user = service.getById(id);
        if(user.equals(null)){
            return new ResponseEntity<>(user, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<?>getAllUsers(){
        List<UsersDto>usersList = service.getAllUser();
        return new ResponseEntity<>(usersList, HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?>updateUsers(@RequestBody UsersDto users1, @PathVariable("id")Long id){
        UsersDto users = service.updateUsers(id, users1);
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?>deleteUsers(@PathVariable("id")Long id){
        service.deleteUser(id);
        return new ResponseEntity<>("Deleted user succesfully", HttpStatus.OK);
    }

//    @ExceptionHandler(ResourceNotFoundException.class)
//    public ResponseEntity<ErrorDetails>handleResourceNotFoundException(ResourceNotFoundException exception,
//                                                                       WebRequest webRequest){
//        ErrorDetails errorDetails = new ErrorDetails(
//                LocalDateTime.now(),
//                exception.getMessage(),
//                webRequest.getDescription(false),
//                "USER NOT FOUND"
//        );
//        return new ResponseEntity<>()
//    }
}
