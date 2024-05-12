package com.dev.Splitwise.Splitwise.dto;

import com.dev.Splitwise.Splitwise.entity.UserExpenseType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserExpenseResponseDto {
    private double amount;
    private FriendResponseDto participant;
    private UserExpenseType userExpenseType;
}
