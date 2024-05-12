package com.dev.Splitwise.Splitwise.helper;

import java.util.Comparator;

public class UserOutstandingAmountComparator implements Comparator<UserOutstanding> {
    @Override
    public int compare(UserOutstanding o1, UserOutstanding o2) {
        if (o1.getAmount()>o2.getAmount())
            return -1;
        else if(o1.getAmount()<o2.getAmount())
            return 1;
        else
            return 0;
    }
}
