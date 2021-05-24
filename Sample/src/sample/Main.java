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
public class Main {
	public static void main(String[] args) {
        Bank cust1 = new BDO("John", 50);
        Bank cust2 = new RCBC("Christian", 100);
        getBranch(new BDO("Kei", 19));
        getBranch(new RCBC("John", 20));
    }	
    
    public Bank BDO(String name, int amount) {
       return new BDO(name, amount); 
    }
    
    public Bank RCBC(String name, int amount) {
        return new RCBC(name, amount);
    }
    
    public static void getBranch(MindanaoBank branch) {
        branch.getBranch();
    }
}
