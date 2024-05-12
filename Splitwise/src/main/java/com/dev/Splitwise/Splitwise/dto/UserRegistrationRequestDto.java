package com.dev.Splitwise.Splitwise.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRegistrationRequestDto {
    private String email;
    private String name;
    private String password;
}
