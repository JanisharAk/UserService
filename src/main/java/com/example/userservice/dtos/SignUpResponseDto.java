package com.example.userservice.dtos;

import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class SignUpResponseDto {
    private String name;
    private String email;
    private boolean isEmailVerified;
   // private long id;
   // private String password;
}