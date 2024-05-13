package com.dev.Splitwise.Splitwise.helper;

import java.util.Comparator;

public class UserOutstandingAmountMinComparator implements Comparator<UserOutstanding> {
    @Override
    public int compare(UserOutstanding o1, UserOutstanding o2) {
        return Double.compare(o1.getAmount(), o2.getAmount());
    }
}
