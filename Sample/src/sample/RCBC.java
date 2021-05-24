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
public class RCBC extends MindanaoBank implements Bank {
    
    private final String name;
    private int balance;
    
    public RCBC(String name, int amount) {
        this.name = name;
        this.balance = amount;
    }

    @Override
    public void getBranch() {
        System.out.println("RCBC Mindanao Branch");
    }

    @Override
    public int withdraw(int amount) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int deposit(int amount) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int checkBalance() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void getName() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
