package com.dev.Splitwise.Splitwise.helper;

import com.dev.Splitwise.Splitwise.entity.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserOutstanding{
    private User user;
    private double amount;
}
