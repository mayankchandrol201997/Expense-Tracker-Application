package com.dev.Splitwise.Splitwise.dto;

import com.dev.Splitwise.Splitwise.entity.Expense;
import com.dev.Splitwise.Splitwise.entity.User;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class GroupResponseDto {
    private int id;
    private String name;
    private List<FriendResponseDto> members;
    private FriendResponseDto createdBy;
    private double totalAmountSpent;
    private List<ExpenseResponseDto> expenses;
}
