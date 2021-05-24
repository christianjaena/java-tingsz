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
public interface Bank {
   public int withdraw(int amount);
   public int deposit(int amount);
   public int checkBalance();
   abstract public void getName();
}
