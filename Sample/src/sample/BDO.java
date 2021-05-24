/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample;

/**
 *
 * @author Christian Y. Jaena
 */
public class BDO extends MindanaoBank implements Bank {

    private final String name;
    private int balance;

    public BDO(String name, int initialBalance) {
        this.name = name;
        balance = initialBalance;
    }
    
    @Override
    public int withdraw(int amount) {
       if (amount > balance) {
           throw new ArithmeticException("Insufficient Balance");
       } else {
           return balance -= amount;
       }
    }

    @Override
    public int deposit(int amount) {
        return balance += amount;
    }

    @Override
    public int checkBalance() {
        return balance;
    }
   
    @Override
    public void getName() {
        System.out.println(name);
    }

    @Override
    public void getBranch() {
        System.out.println("BDO Mindanao Branch");
    }
    
}
