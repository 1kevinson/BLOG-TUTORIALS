package com.example.f_no_getter_and_no_setter;

import java.math.BigDecimal;

public class Wallet {

    private BigDecimal balance;

    public Wallet(BigDecimal balance) {
        this.balance = balance;
    }

    void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public BigDecimal getBalance() {
        return balance;
    }
}
