/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FinancialApp.Algorithm;
import java.util.*;
import javafx.util.Pair;
/**
 *
 * @author aabdin02
 */
public class AutoLoan implements FinancialAppCalculator{
    double vehiclePrice; 
    double salesTaxPercent;
    double feesTaxable;
    double taxFree;
    double downPayment;
    double tradeInPayment;
    double amountOwedTradeIn;
    double interestRatePercent;
    double loanTermInMonths;
  
    public  AutoLoan(double vehPrice, double salesTaxPercent,
                     double feesTaxable, double taxFree, double downPayment,
                     double tradeInPayment,double amountOwedTradeIn, double interestRatePercent
                     , int loanTermInMonths){
        this.vehiclePrice = vehPrice - tradeInPayment + amountOwedTradeIn + feesTaxable;
        this.downPayment = downPayment;
        this.salesTaxPercent = salesTaxPercent;
        this.feesTaxable = feesTaxable;
        this.taxFree = taxFree;
        this.tradeInPayment = tradeInPayment;
        this.interestRatePercent = interestRatePercent;
        this.loanTermInMonths = loanTermInMonths;
    
    }
    public double getTotalSalesTax(){
        return (salesTaxPercent * (getLoan() - taxFree))/100;
    }
    
    public double getMonthlySalesTax(){
        return  ((1 + (1 - salesTaxPercent/100)) * getTotalSalesTax()
                * (1 + salesTaxPercent/100)) / loanTermInMonths;
    }
    
    public double getLoan(){
        double loan = vehiclePrice - downPayment;
        if(loan <= 0) return 0.00;
        return  loan;
    }
    @Override
    public double calulateMonthlyPayment() {
        double i = interestRatePercent / 1200;
        double res = Math.pow(1 + i, loanTermInMonths) - 1;
        res  /= i * Math.pow(((1 + i)), loanTermInMonths);
        
        return ((getLoan() + taxFree)  / res )+ getMonthlySalesTax() ;
        
    }
    public ArrayList<Pair<Double,Pair<Double,Double>>> populateAmount(){
        //  Amount        Princ             Balance
        //monthlyPayment  Am - calMonInt    getLoan - amount
        ArrayList<Pair<Double, Pair<Double,Double>>> pair0 = new ArrayList<>();
        Pair<Double, Double> inner;
        Pair<Double, Pair<Double, Double>> outer;
        
        while(Math.round(getLoan()*100.00/100.00) > 1){
            inner = new Pair<>(calulateMonthlyPayment() - calculateMonthlyInterest(),
                                getLoan() - calulateMonthlyPayment());
            
            outer = new Pair<> (calulateMonthlyPayment(), inner);
            downPayment += getMonthlySalesTax();
            
            pair0.add(outer);
        }
        
        return pair0;
    }

    @Override
    public double calculateAmortization() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public double calculateMonthlyInterest(){
        return calculateInterest() /loanTermInMonths * 12;
    }

    @Override
    public double calculateTotalPayment() {
        return calulateMonthlyPayment() * loanTermInMonths;
    }

    public double getAmountFinanced(){
        return getLoan() + getTotalSalesTax();
    }
    @Override
    public double calculateInterest() {
        return  calculateTotalPayment() - getAmountFinanced();
    }

    @Override
    public double calculateAnnualPayment() {
        return calulateMonthlyPayment() * 12;
    }
    
}
