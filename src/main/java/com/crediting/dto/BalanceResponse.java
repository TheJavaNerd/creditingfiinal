package com.crediting.dto;

public class BalanceResponse {
    private double credit;

    public BalanceResponse(double credit) {
        this.credit = credit;
    }

    public double getCredit() {
        return credit;
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }
}