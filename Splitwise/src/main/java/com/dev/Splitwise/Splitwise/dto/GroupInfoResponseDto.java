package com.dev.Splitwise.Splitwise.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class GroupInfoResponseDto {
    private int id;
    private String name;
    private List<FriendResponseDto> members;
    private FriendResponseDto createdBy;
    private double totalAmountSpent;
    private List<ExpenseResponseDto> expense;
}
