package com.example.apartment.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class LoginRequest {
    @NotBlank(message = "username must be not null")
    private String username;
    @NotBlank(message = "username must be not blank")
    private String password;
}
