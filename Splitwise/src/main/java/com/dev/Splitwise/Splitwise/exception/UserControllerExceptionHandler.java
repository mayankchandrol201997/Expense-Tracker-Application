package com.dev.Splitwise.Splitwise.exception;

import com.dev.Splitwise.Splitwise.controller.UserController;
import com.dev.Splitwise.Splitwise.dto.ExceptionResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice(basePackageClasses = UserController.class)
public class UserControllerExceptionHandler {
    @ExceptionHandler(UserRegistrationInvalidDataException.class)
    public ResponseEntity<ExceptionResponseDto> handleUserRegistrationInvalidDataException
            (UserRegistrationInvalidDataException userRegistrationInvalidDataException)
    {
        ExceptionResponseDto exceptionResponseDto = new ExceptionResponseDto();
        exceptionResponseDto.setErrorCode(404);
        exceptionResponseDto.setErrorMessage(userRegistrationInvalidDataException.getMessage());
        return new ResponseEntity<>(exceptionResponseDto,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UserLoginInvalidDataException.class)
    public ResponseEntity<ExceptionResponseDto> handleUserLoginInvalidDataException
            (UserLoginInvalidDataException userLoginInvalidDataException)
    {
        ExceptionResponseDto exceptionResponseDto = new ExceptionResponseDto();
        exceptionResponseDto.setErrorCode(404);
        exceptionResponseDto.setErrorMessage(userLoginInvalidDataException.getMessage());
        return new ResponseEntity<>(exceptionResponseDto,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InvalidPasswordException.class)
    public ResponseEntity<ExceptionResponseDto> handleInvalidPasswordException
            (InvalidPasswordException invalidPasswordException)
    {
        ExceptionResponseDto exceptionResponseDto = new ExceptionResponseDto();
        exceptionResponseDto.setErrorCode(404);
        exceptionResponseDto.setErrorMessage(invalidPasswordException.getMessage());
        return new ResponseEntity<>(exceptionResponseDto,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InvalidEmailIdException.class)
    public ResponseEntity<ExceptionResponseDto> handleInvalidEmailIdException
            (InvalidEmailIdException invalidEmailIdException)
    {
        ExceptionResponseDto exceptionResponseDto = new ExceptionResponseDto();
        exceptionResponseDto.setErrorCode(404);
        exceptionResponseDto.setErrorMessage(invalidEmailIdException.getMessage());
        return new ResponseEntity<>(exceptionResponseDto,HttpStatus.BAD_REQUEST);
    }

}
