package com.dev.Splitwise.Splitwise.service.Strategy.SettleUpStrategy;

import com.dev.Splitwise.Splitwise.entity.Expense;
import com.dev.Splitwise.Splitwise.entity.SettleTransaction;
import com.dev.Splitwise.Splitwise.entity.User;

import java.util.List;

public interface SettleUpStrategy {
    public List<SettleTransaction> settleUp(List<Expense> expenses);
}
