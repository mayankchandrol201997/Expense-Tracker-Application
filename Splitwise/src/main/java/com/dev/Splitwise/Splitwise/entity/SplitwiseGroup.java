package com.dev.Splitwise.Splitwise.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
public class SplitwiseGroup extends BaseModel{
    private String name;
    @ManyToMany
    private List<User> members;
    @ManyToOne
    private User createdBy;
    private LocalDateTime creationDate;
    private double totalAmountSpent;
    @OneToMany
    private List<Expense> expenses;
    @OneToMany
    private List<SettleTransaction> settleUpTransaction;
}
