package com.dev.Splitwise.Splitwise.controller;

import com.dev.Splitwise.Splitwise.dto.UserLoginRequestDto;
import com.dev.Splitwise.Splitwise.dto.UserLoginResponseDto;
import com.dev.Splitwise.Splitwise.dto.UserRegistrationRequestDto;
import com.dev.Splitwise.Splitwise.exception.UserLoginInvalidDataException;
import com.dev.Splitwise.Splitwise.exception.UserRegistrationInvalidDataException;
import com.dev.Splitwise.Splitwise.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PutMapping("/updateProfile/{id}")
    public ResponseEntity<Boolean> updateProfile(@PathVariable("id") int id,@RequestBody UserRegistrationRequestDto userRegistrationRequestDto)
    {
        validateUserRegistrationRequestDto(userRegistrationRequestDto);
        return ResponseEntity.ok(userService.update(userRegistrationRequestDto,id));
    }

    @GetMapping("/login")
    public ResponseEntity<UserLoginResponseDto> login(@RequestBody UserLoginRequestDto userLoginRequestDto)
    {
        validateUserLoginRequestDto(userLoginRequestDto);
        userService.login(userLoginRequestDto);
        return ResponseEntity.ok(userService.login(userLoginRequestDto));
    }

    private void validateUserLoginRequestDto(UserLoginRequestDto userLoginRequestDto) {
        String email = userLoginRequestDto.getEmail();
        String password = userLoginRequestDto.getPassword();
        if (email.isBlank() || email.isEmpty() ||
                 password.isBlank() || password.isEmpty())
        {
            throw new UserLoginInvalidDataException("Invalid login data");
        }
    }

    @PostMapping("/signUp")
    public ResponseEntity<UserLoginResponseDto> signUp(@RequestBody UserRegistrationRequestDto userRegistrationRequestDto)
    {
        validateUserRegistrationRequestDto(userRegistrationRequestDto);
        return ResponseEntity.ok(userService.signUp(userRegistrationRequestDto));
    }

    private void validateUserRegistrationRequestDto(UserRegistrationRequestDto userRegistrationRequestDto)
    {
        String email = userRegistrationRequestDto.getEmail();
        String name = userRegistrationRequestDto.getName();
        String password = userRegistrationRequestDto.getPassword();
        if (email == null || email.isBlank() || email.isEmpty() || name == null ||
                name.isEmpty() || name.isBlank() || password == null || password.isBlank() || password.isEmpty())
        {
            throw new UserRegistrationInvalidDataException("Invalid sign up data");
        }
    }
}
