/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FinancialApp.Algorithm;

import java.util.ArrayList;
import javafx.util.Pair;
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
//        double i = 0.05;
        int t = 5;
        
            //1 vehPrice,  2 salesTaxPercent,3 feesTaxable,3taxFree, 4 downPayment,
            //5 tradeInPayment, 6 amountOwedTradeIn, 7 interestRatePercent, 8 loanTermMonths
                                    //1         2   3       3       4       5       6     7     8
//        AutoLoan loan = new AutoLoan(100000, 5.00, 000.00, 000.00, 000.00, 000.00, 000.00,6, 360);
////        System.out.println("Monthly payment: "+loan.calulateMonthlyPayment());
//        System.out.println("Amount Financed: "+loan.getAmountFinanced());
//        System.out.println(" Total Interest: "+loan.calculateInterest());
//        System.out.println("  Total Payment: "+loan.calculateTotalPayment());
//       ArrayList<Pair<Double, Pair<Double,Double>>> ar = new ArrayList(loan.populateAmount());
//       boolean first = true;
//       for(int i = 0; (first || i < ar.size()  && ((Math.round(ar.get(i - 1).getKey()) * 100.00/100.00) != 0)); i++){
//           int month = i;
//           double amount = Math.round(ar.get(i).getKey()) * 100.00/100.00;
//           double principal = Math.round(ar.get(i).getValue().getKey()) * 100.00/100.00;
//           double interest = principal - amount;
//           double balance = Math.round(ar.get(i).getValue().getKey()) * 100.00/100.00;
//           first = false;
//       }
        Discount dis = new Discount(true, 100, 5, 5, 0, 0);
        System.out.println("Sales Tax: " + dis.getSalesTax());
        System.out.println("Total Payment: " + dis.getTotalPayment());
        System.out.println("Savings: "+ dis.getSavings());
        System.out.println("Total Percentage Of: " + dis.totalPercentOff());
    }
    
}
