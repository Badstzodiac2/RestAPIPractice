package com.example.section8.controller;

import com.example.section8.dto.UsersDto;
import com.example.section8.services.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(
        name = "CRUD REST API FOR USER RESOURCES",
        description = "CRUD REST API'S = CREATE, READ, UPDATE, DELETE"
)
@RestController
@AllArgsConstructor
@RequestMapping("/api/user")
public class UserController {

    private UserService service;

    @Operation(
            summary = "Create user REST API",
            description = "Create user to save into database"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP Status CREATED"
    )
    @PostMapping("/create")
    public ResponseEntity<?> createUser(@Valid @RequestBody UsersDto users) {
        UsersDto users1 = service.createUser(users);
        return new ResponseEntity<>(users1, HttpStatus.CREATED);
    }

    @Operation(
            summary = "Get user by id REST API",
            description = "GET USER BASED OF ID GENERATED"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status FOUNDED"
    )
    @GetMapping("/get/{id}")
    public ResponseEntity<?> getUserById(@PathVariable("id") Long id) {
        UsersDto user = service.getById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @Operation(
            summary = "Get all user REST API",
            description = "GET ALL USER FROM DATABASE"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status FOUNDED"
    )
    @GetMapping("")
    public ResponseEntity<?> getAllUsers() {
        List<UsersDto> usersList = service.getAllUser();
        return new ResponseEntity<>(usersList, HttpStatus.OK);
    }

    @Operation(
            summary = "Update user by id REST API",
            description = "UPDATE USER FROM DATABASE BY ID"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status UPDATED"
    )
    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateUsers(@Valid @RequestBody UsersDto users1, @PathVariable("id") Long id) {
        UsersDto users = service.updateUsers(id, users1);
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @Operation(
            summary = "Delete user by id REST API",
            description = "DELETE USER FROM DATABASE BY ID"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status DELETED"
    )
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteUsers(@PathVariable("id") Long id) {
        service.deleteUser(id);
        return new ResponseEntity<>("Deleted user successfully", HttpStatus.OK);
    }


}
