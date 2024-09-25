package com.crediting.dto;

public class RegisterResponse {
    private boolean success;
    private double credit;

    public RegisterResponse(boolean success, double credit) {
        this.success = success;
        this.credit = credit;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public double getCredit() {
        return credit;
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }

}