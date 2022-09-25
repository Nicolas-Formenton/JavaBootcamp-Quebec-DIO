package entities;

import exceptions.BusinessException;

import java.util.Scanner;

public class Account {

    private Integer number;
    private String holder;
    private Double balance;
    private Double withdrawLimit;

    public Account() {

    }

    public Account(Integer number, String holder, Double balance, Double withdrawLimit) {
        this.number = number;
        this.holder = holder;
        this.balance = balance;
        this.withdrawLimit = withdrawLimit;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getHolder() {
        return holder;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Double getWithdrawLimit() {
        return withdrawLimit;
    }

    public void setWithdrawLimit(Double withdrawLimit) {
        this.withdrawLimit = withdrawLimit;
    }

    public void deposit(double amount){
        balance += amount;
    }

    public void withdraw(double amount){
        //3rd method only
        validateWithdraw(amount);
        //
        balance -= amount;
    }

    //Gambiarra Method (2o)
//    public String validateWithdraw(double amount) {
//        if (amount > getWithdrawLimit()) {
//            return "Erro de Saque: A quantia excede o limite de saque.";
//        }
//        if (amount > getBalance()) {
//            return "Erro de Saque: Saldo insuficiente.";
//        }
//        return null;
//    }

    //Exceptions Method (3o)
    private void validateWithdraw(double amount) {
        if (amount > getWithdrawLimit()) {
            throw new BusinessException("Erro de Saque: A quantia excede o limite de saque.");
        }
        if (amount > getBalance()) {
            throw new BusinessException("Erro de Saque: Saldo insuficiente.");
        }
    }
}

