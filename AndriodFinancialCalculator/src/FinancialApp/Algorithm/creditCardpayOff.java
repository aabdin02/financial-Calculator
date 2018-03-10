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
public class creditCardpayOff {
    private double balance;
    private double interestRatePer;
    private int monthlyPayment;
    private int desiredMonthUntilDebtFree;
    
    public creditCardpayOff(double balance, double interestRatePer,
                            int monthlyPayment, int desiredMonthUntilFree){
        this.balance = balance;
        this.interestRatePer = interestRatePer;
        this.monthlyPayment = monthlyPayment;
        this.desiredMonthUntilDebtFree = desiredMonthUntilFree;
    }
    
    public double calculateTotalInterest(){
       return 1299.00; 
    }
    
    public double calculateTotalPayment(){
        return balance + (interestRatePer * balance/100);
    }
}
