package com.dev.Splitwise.Splitwise.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class SettleTransaction extends BaseModel{
    @ManyToOne
    private User lender;
    @ManyToOne
    private User borrower;
    private double amount;
}
