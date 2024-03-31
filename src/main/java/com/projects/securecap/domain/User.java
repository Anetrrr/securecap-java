package com.projects.securecap.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.projects.securecap.exception.ApiException;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.springframework.beans.factory.annotation.Autowired;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_DEFAULT;

@SuperBuilder
@RequiredArgsConstructor
@AllArgsConstructor
@Data
@JsonInclude(NON_DEFAULT)
public class User {
    public final ApiException apiException;

    private Long id;
    @NotEmpty(message = "First name cannot be empty")
    private String firstName;
    @NotEmpty(message = "First name cannot be empty")
    private String lastName;
    @NotEmpty(message = "First name cannot be empty")
    @Email(message = "Invalid email. Please enter a valid email.")
    private String email;
    @NotEmpty(message = "Password cannot be empty")
    private String password;
    private String address;
    private String phone;
    private  String title;
    private String bio;
    private String imageUrl;
    private boolean enabled;
    private boolean isNotLocked
    private boolean isUsingMfa;
    private boolean LocalDateTime;
}
