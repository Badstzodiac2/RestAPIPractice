package com.example.section8.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Schema(description = "User Dto model information")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UsersDto {

    @Schema(description = "User id")
    private Long id;

    @Schema(description = "User first name")
    @NotEmpty(message = "User first name should not be null or empty")
    private String firstName;

    @Schema(description = "User last name")
    @NotEmpty(message = "User last name should not be null or empty")
    private String lastName;

    @Schema(description = "User email")
    @NotEmpty(message = "User email should not be null or empty")
    @Email(message = "User email should be in right format")
    private String email;
}
