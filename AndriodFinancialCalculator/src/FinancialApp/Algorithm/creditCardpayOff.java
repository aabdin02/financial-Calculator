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
    private final double balance;
    private final double interestRatePer;
    private final int monthlyPayment;
    private final int desiredMonthUntilDebtFree;
    
    public creditCardpayOff(double balanc, double interestRatePe,
                            int monthlyPaymen, int desiredMonthUntilFre){
        this.balance = balanc;
        this.interestRatePer = interestRatePe;
        this.monthlyPayment = monthlyPaymen;
        this.desiredMonthUntilDebtFree = desiredMonthUntilFre;
    }
    
    public double calculateTotalInterest(){
       return 1299.00; 
    }
    
    public double calculateTotalPayment(){
        return balance + (interestRatePer * balance/100);
    }
}
