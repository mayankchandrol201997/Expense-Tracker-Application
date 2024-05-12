package com.dev.Splitwise.Splitwise.mapper;

import com.dev.Splitwise.Splitwise.dto.*;
import com.dev.Splitwise.Splitwise.entity.Expense;
import com.dev.Splitwise.Splitwise.entity.SplitwiseGroup;
import com.dev.Splitwise.Splitwise.entity.User;
import com.dev.Splitwise.Splitwise.entity.UserExpense;

import java.util.ArrayList;
import java.util.List;

public class EntityToDtoMapper {
    public static UserLoginResponseDto convertToUserLoginResponseDto(User user)
    {
        UserLoginResponseDto userLoginResponseDto = new UserLoginResponseDto();
        userLoginResponseDto.setEmail(user.getEmail());
        userLoginResponseDto.setName(user.getName());
        userLoginResponseDto.setId(user.getId());
        if(user.getFriends()!=null) {
            List<FriendResponseDto> friendResponseDtos = new ArrayList<>();
            for (User friend:user.getFriends())
            {
                friendResponseDtos.add(convertToFriendResponseDto(friend));
            }
            userLoginResponseDto.setFriends(friendResponseDtos);
        }
        if(user.getGroups()!=null) {
            List<GroupResponseDto> groupResponseDtos = new ArrayList<>();
            for (SplitwiseGroup group:user.getGroups())
            {
                groupResponseDtos.add(convertSpliwiseGroupResponseDto(group));
            }
            userLoginResponseDto.setGroups(groupResponseDtos);
        }
        return userLoginResponseDto;
    }

    private static FriendResponseDto convertToFriendResponseDto(User user) {
            FriendResponseDto friendResponseDto = new FriendResponseDto();
            friendResponseDto.setId(user.getId());
            friendResponseDto.setName(user.getName());

        return friendResponseDto;
    }

    public static GroupResponseDto convertSpliwiseGroupResponseDto(SplitwiseGroup splitwiseGroup) {
        GroupResponseDto groupResponseDto = new GroupResponseDto();
        groupResponseDto.setName(splitwiseGroup.getName());
        groupResponseDto.setId(splitwiseGroup.getId());
        groupResponseDto.setCreatedBy(convertToFriendResponseDto(splitwiseGroup.getCreatedBy()));

        List<FriendResponseDto> friendResponseDtos = new ArrayList<>();
        for (User member:splitwiseGroup.getMembers())
        {
            friendResponseDtos.add(convertToFriendResponseDto(member));
        }
        groupResponseDto.setMembers(friendResponseDtos);
        return groupResponseDto;
    }

    public static GroupInfoResponseDto convertToSpliwiseGroupInfoResponseDto(SplitwiseGroup splitwiseGroup) {

        GroupInfoResponseDto groupInfoResponseDto = new GroupInfoResponseDto();
        groupInfoResponseDto.setName(splitwiseGroup.getName());
        groupInfoResponseDto.setId(splitwiseGroup.getId());
        groupInfoResponseDto.setCreatedBy(convertToFriendResponseDto(splitwiseGroup.getCreatedBy()));

        List<FriendResponseDto> friendResponseDtos = new ArrayList<>();
        for (User member:splitwiseGroup.getMembers())
        {
            friendResponseDtos.add(convertToFriendResponseDto(member));
        }

        groupInfoResponseDto.setMembers(friendResponseDtos);
        groupInfoResponseDto.setTotalAmountSpent(splitwiseGroup.getTotalAmountSpent());

        List<ExpenseResponseDto> expenseResponseDtos = new ArrayList<>();
        for (Expense expense:splitwiseGroup.getExpenses())
        {
            ExpenseResponseDto expenseResponseDto = convertToExpenseResponseDto(expense);
            expenseResponseDtos.add(expenseResponseDto);
        }

        groupInfoResponseDto.setExpense(expenseResponseDtos);
        return groupInfoResponseDto;
    }

    private static ExpenseResponseDto convertToExpenseResponseDto(Expense expense) {
        ExpenseResponseDto expenseResponseDto = new ExpenseResponseDto();
        expenseResponseDto.setExpenseDate(expense.getExpenseDate());
        expenseResponseDto.setCurrency(expense.getCurrency());
        expenseResponseDto.setDescription(expenseResponseDto.getDescription());
        expenseResponseDto.setAddedBy(convertToFriendResponseDto(expense.getAddedBy()));

        List<UserExpenseResponseDto> userExpenseResponseDtos = new ArrayList<>();
        for (UserExpense userExpense:expense.getUserExpenses())
        {
            UserExpenseResponseDto userExpenseResponseDto =
                    convertToUserExpenseResponseDto(userExpense);

            userExpenseResponseDtos.add(userExpenseResponseDto);
        }
        expenseResponseDto.setUserExpense(userExpenseResponseDtos);
        return expenseResponseDto;
    }

    private static UserExpenseResponseDto convertToUserExpenseResponseDto(UserExpense userExpense) {
        UserExpenseResponseDto userExpenseResponseDto = new UserExpenseResponseDto();
        userExpenseResponseDto.setUserExpenseType(userExpense.getUserExpenseType());
        userExpenseResponseDto.setAmount(userExpense.getAmount());
        userExpenseResponseDto.setParticipant(convertToFriendResponseDto(userExpense.getUser()));
        return userExpenseResponseDto;
    }
}
