package com.jean.entity;

public class TransactionStatus {
    private Boolean error;
    private String message;
    private Object payload;

    public TransactionStatus() {
    }

    public TransactionStatus(Boolean error, String message,  Object payload) {
        this.error = error;
        this.message = message;
        this.payload = payload;
    }

    public Boolean getError() {
        return error;
    }

    public void setError(Boolean error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getPayload() {
        return payload;
    }

    public void setPayload(Object payload) {
        this.payload = payload;
    }

    @Override
    public String toString() {
        return "TransactionStatus{" +
                "error=" + error +
                ", message='" + message + '\'' +
                ", payload=" + payload +
                '}';
    }
}

