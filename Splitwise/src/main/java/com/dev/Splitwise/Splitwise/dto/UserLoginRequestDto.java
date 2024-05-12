package com.dev.Splitwise.Splitwise.dto;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SecondaryRow;

@Getter
@Setter
public class UserLoginRequestDto {
    private String email;
    private String password;
}
