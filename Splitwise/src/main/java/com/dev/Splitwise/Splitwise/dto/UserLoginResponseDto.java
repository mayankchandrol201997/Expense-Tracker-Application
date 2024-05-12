package com.dev.Splitwise.Splitwise.dto;

import com.dev.Splitwise.Splitwise.entity.SplitwiseGroup;
import com.dev.Splitwise.Splitwise.entity.User;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class UserLoginResponseDto {
    private int id;
    private String email;
    private String name;
    private List<GroupResponseDto> groups;
    private List<FriendResponseDto> friends;
}
