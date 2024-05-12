package com.dev.Splitwise.Splitwise.dto;

import com.dev.Splitwise.Splitwise.entity.User;
import com.dev.Splitwise.Splitwise.entity.UserExpense;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Currency;
import java.util.List;

@Getter
@Setter
public class ExpenseResponseDto {
    private String description;
    private double totalAmount;
    private LocalDateTime expenseDate;
    private FriendResponseDto addedBy;
    private Currency currency;
    private List<UserExpenseResponseDto> userExpense;
}
