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
        
            //vehPrice, saltesTaxPercent,feesTaxable,taxFree, downPayment,
            //tradeInPayment, amountOwedTradeIn, interestRatePercent, loanTermMonths

        AutoLoan loan = new AutoLoan(100000, 0.00, 2000.00,0.00, 0.00, 0.00,0.00,6, 360);
        System.out.println("Monthly payment: "+loan.calulateMonthlyPayment());
//        System.out.println("  Total Payment: "+loan.calculateTotalPayment());
//        System.out.println(" Total Interest: "+loan.calculateInterest());
//        System.out.println("Annual  Payment: "+loan.calculateAnnualPayment());
//        loan.calulateMonthlyPayment();
    }
    
}
