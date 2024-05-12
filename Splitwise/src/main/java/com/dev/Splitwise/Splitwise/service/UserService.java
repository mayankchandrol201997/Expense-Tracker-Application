package com.dev.Splitwise.Splitwise.service;

import com.dev.Splitwise.Splitwise.dto.UserLoginRequestDto;
import com.dev.Splitwise.Splitwise.dto.UserLoginResponseDto;
import com.dev.Splitwise.Splitwise.dto.UserRegistrationRequestDto;

public interface UserService {
    UserLoginResponseDto signUp(UserRegistrationRequestDto userRegistrationRequestDto);
    UserLoginResponseDto login(UserLoginRequestDto userLoginRequestDto);
    Boolean update(UserRegistrationRequestDto userLoginRequestDto, int id);
}
