package com.dev.Splitwise.Splitwise.mapper;

import com.dev.Splitwise.Splitwise.dto.GroupRequestDto;
import com.dev.Splitwise.Splitwise.dto.UserRegistrationRequestDto;
import com.dev.Splitwise.Splitwise.entity.SplitwiseGroup;
import com.dev.Splitwise.Splitwise.entity.User;

public class DtoToEntityMapper {
    public static User convertUserLoginRequestDtoToUserEntity(UserRegistrationRequestDto userRegistrationRequestDto)
    {
        User user = new User();
        user.setEmail(userRegistrationRequestDto.getEmail());
        user.setName(userRegistrationRequestDto.getName());
        user.setPassword(userRegistrationRequestDto.getPassword());
        return user;
    }
}
