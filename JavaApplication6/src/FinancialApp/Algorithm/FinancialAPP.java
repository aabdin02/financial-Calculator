/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FinancialApp.Algorithm;

/**
 *
 * @author aabdin02
 */
public class FinancialAPP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int p = 12000;
        double i = 0.05;
        int t = 5;
        
        PersonalLoan loan = new PersonalLoan(p, i, t);
        System.out.println(loan.calulateMonthlyPayment());
        
    }
    
}
