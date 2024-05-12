package com.dev.Splitwise.Splitwise.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExceptionResponseDto {
    private int errorCode;
    private String errorMessage;
}
