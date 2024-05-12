package com.dev.Splitwise.Splitwise.service;

import com.dev.Splitwise.Splitwise.dto.UserLoginRequestDto;
import com.dev.Splitwise.Splitwise.dto.UserLoginResponseDto;
import com.dev.Splitwise.Splitwise.dto.UserRegistrationRequestDto;
import com.dev.Splitwise.Splitwise.entity.User;
import com.dev.Splitwise.Splitwise.exception.InvalidEmailIdException;
import com.dev.Splitwise.Splitwise.exception.InvalidPasswordException;
import com.dev.Splitwise.Splitwise.exception.NoUserFoundException;
import com.dev.Splitwise.Splitwise.mapper.DtoToEntityMapper;
import com.dev.Splitwise.Splitwise.mapper.EntityToDtoMapper;
import com.dev.Splitwise.Splitwise.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserLoginResponseDto signUp(UserRegistrationRequestDto userRegistrationRequestDto) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        User user = DtoToEntityMapper.convertUserLoginRequestDtoToUserEntity(userRegistrationRequestDto);
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        User savedUser = userRepository.save(user);
        return EntityToDtoMapper.convertToUserLoginResponseDto(savedUser);
    }

    @Override
    public UserLoginResponseDto login(UserLoginRequestDto userLoginRequestDto) {
        User user = userRepository.findByEmail(userLoginRequestDto.getEmail());
        if (user==null)
            throw new InvalidEmailIdException("Incorrect Email");

        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        if (!bCryptPasswordEncoder.matches(userLoginRequestDto.getPassword(),user.getPassword()))
        {
            throw new InvalidPasswordException("Incorrect Password");
        }
        return EntityToDtoMapper.convertToUserLoginResponseDto(user);
    }

    @Override
    public Boolean update(UserRegistrationRequestDto userRegistrationRequestDto, int id) {
        User user = userRepository.findById(id).orElseThrow(
                ()-> new NoUserFoundException("No user found by id "+id)
        );
        user.setEmail(userRegistrationRequestDto.getEmail());
        user.setPassword(userRegistrationRequestDto.getPassword());
        user.setName(userRegistrationRequestDto.getName());
        userRepository.save(user);
        return true;
    }
}
