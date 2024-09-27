package com.example.g_no_getter_and_no_setter;

import java.math.BigDecimal;

public class WalletValid {

    private BigDecimal balance;

    public WalletValid(BigDecimal balance) {
        this.balance = balance;
    }

    void increaseMoney(BigDecimal balance) {
        this.balance.add(balance);
    }

    public BigDecimal totalAmount() {
        return balance;
    }
}
