package com.crediting.dto;

public class UpdateCreditResponse {
    private boolean success;
    private double newCredit;

    public UpdateCreditResponse(boolean success, double newCredit) {
        this.success = success;
        this.newCredit = newCredit;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public double getNewCredit() {
        return newCredit;
    }

    public void setNewCredit(double newCredit) {
        this.newCredit = newCredit;
    }
}