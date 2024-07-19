package com.example.userservice.controller;


import com.example.userservice.dtos.LoginRequestDto;
import com.example.userservice.dtos.LogoutRequestDto;
import com.example.userservice.dtos.SignUpRequestDto;
import com.example.userservice.dtos.SignUpResponseDto;
import com.example.userservice.models.Token;
import com.example.userservice.models.User;
import com.example.userservice.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public Token login( @RequestBody LoginRequestDto requestDto) {
        // check if email and password in db
        // if yes return user
        // else throw some error
        return userService.login(requestDto.getEmail(), requestDto.getPassword());
    }


    @PostMapping("/signup")
    public SignUpResponseDto signUp(@RequestBody SignUpRequestDto requestDto) {

        return toSignUpResponseDto(userService.signUp(requestDto.getName(), requestDto.getEmail(), requestDto.getPassword()));
    }


    @PostMapping("/logout")
    public ResponseEntity<Void> logout(@RequestBody LogoutRequestDto requestDto) {
        // delete token if exists -> 200
        // if doesn't exist give a 404
        //return null;

        userService.logout(requestDto.getToken());
        return ResponseEntity.ok().build(); // or throw an exception, based on your error handling policy
    }


    public SignUpResponseDto toSignUpResponseDto(User user) {
        if (user == null) {
            return null; // Or throw an exception, based on your error handling policy
        }

        SignUpResponseDto dto = new SignUpResponseDto();
        dto.setName(user.getName());
        dto.setEmail(user.getEmail());
        dto.setEmailVerified(user.isEmailVerified());
     //   dto.setPassword(user.getHashedPassword());
        return dto;
    }


    @PostMapping("/validate/{token}")
    public User validateToken(@PathVariable("token") @NonNull String token) {
        return userService.validateToken(token);
    }

}


   //Below are the postman collection for the app

//postmapping = http://localhost:8080/users/signup
//postmapping = http://localhost:8080/users/login
//postmapping = http://localhost:8080/users/logout
//postmapping = http://localhost:8080/users/validate/gOAdfgMgEtraKHPASdbWAGBnFoz
//// HJJWBYdJhLXeiQiarheCNNWhswrLLpJHOekXeIkrMgwuNdmDVBBtZrZtIDxbYYfOEmiNxbKhUZIWpefHjsZeruBPotgtMBjJAvMAo
