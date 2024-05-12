package com.dev.Splitwise.Splitwise.service.Strategy.SettleUpStrategy;

import com.dev.Splitwise.Splitwise.entity.*;
import com.dev.Splitwise.Splitwise.helper.UserOutstanding;
import com.dev.Splitwise.Splitwise.helper.UserOutstandingAmountComparator;

import java.util.*;

public class MinimumTransactionSettlementStrategy implements SettleUpStrategy{
    @Override
    public List<SettleTransaction> settleUp(List<Expense> expenses) {
        Queue<UserOutstanding> lenderMax = new PriorityQueue<>(new UserOutstandingAmountComparator());
        Queue<UserOutstanding> borrowerMin = new PriorityQueue<>();

        HashMap<User, Double> userExpenseMap = getUserExpenseMap(expenses);
        for(Map.Entry<User, Double> entry:userExpenseMap.entrySet())
        {
            UserOutstanding userOutstanding = new UserOutstanding();
            userOutstanding.setUser(entry.getKey());
            userOutstanding.setAmount(entry.getValue());
            if (entry.getValue()<0)
            {
                borrowerMin.add(userOutstanding);
            }
            else {
                lenderMax.add(userOutstanding);
            }
        }
        return getMinimumSettlementTransaction(lenderMax,borrowerMin);
    }

    private List<SettleTransaction> getMinimumSettlementTransaction(Queue<UserOutstanding> lenderMax, Queue<UserOutstanding> borrowerMin) {
        List<SettleTransaction> settleTransactions = new ArrayList<>();

        while (!lenderMax.isEmpty() && !borrowerMin.isEmpty())
        {
            SettleTransaction settleTransaction = new SettleTransaction();
            UserOutstanding lender = lenderMax.remove();
            UserOutstanding borrower = borrowerMin.remove();

            double borrowerAmount = borrower.getAmount();
            double lenderAmount = lender.getAmount();
            if(Math.abs(borrowerAmount)!=lenderAmount) {
                settleTransaction.setBorrower(borrower.getUser());
                settleTransaction.setLender(lender.getUser());
                if (Math.abs(borrowerAmount) > lenderAmount) {
                    settleTransaction.setAmount(lenderAmount);
                    borrower.setAmount(borrowerAmount + lenderAmount);
                    borrowerMin.add(borrower);
                } else if (Math.abs(borrowerAmount) < lenderAmount) {
                    settleTransaction.setAmount(Math.abs(borrowerAmount));
                    lender.setAmount(lenderAmount - borrowerAmount);
                    lenderMax.add(lender);
                }
                settleTransactions.add(settleTransaction);
            }
        }

        return settleTransactions;
    }

    private HashMap<User, Double> getUserExpenseMap(List<Expense> expenses) {
        HashMap<User,Double> userExpenseMap = new HashMap<>();
        for(Expense expense : expenses)
        {
            for (UserExpense userExpense:expense.getUserExpenses())
            {
                User user = userExpense.getUser();
                double amount = userExpense.getAmount();
                if (userExpense.getUserExpenseType().equals(UserExpenseType.Paid))
                {
                    if (userExpenseMap.containsKey(user)){
                        userExpenseMap.put(user,userExpenseMap.get(user)+amount);
                    }
                    else {
                        userExpenseMap.put(user,amount);
                    }
                }
                else {
                    if (userExpenseMap.containsKey(user)){
                        userExpenseMap.put(user,userExpenseMap.get(user)-amount);
                    }
                    else {
                        userExpenseMap.put(user,0-amount);
                    }
                }
            }
        }
        return userExpenseMap;
    }
}
