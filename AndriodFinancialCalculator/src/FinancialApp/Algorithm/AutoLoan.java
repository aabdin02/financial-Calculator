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
        this.vehiclePrice = vehPrice - tradeInPayment + amountOwedTradeIn;
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
        System.err.println(getTotalSalesTax());
        return  ((1 + (1 - salesTaxPercent/100)) * getTotalSalesTax()
                * (1 + salesTaxPercent/100)) / loanTermInMonths;
    }
    
    public double getLoan(){
        return vehiclePrice + feesTaxable - downPayment ;
    }
    @Override
    public double calulateMonthlyPayment() {
        double i = interestRatePercent / 1200;
        double res = Math.pow(1 + i, loanTermInMonths) - 1;
        res  /= i * Math.pow(((1 + i)), loanTermInMonths);
        
        return ((getLoan() + taxFree)  / res )+ getMonthlySalesTax() ;
        
    }

    @Override
    public double calculateAmortization() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double calculateTotalPayment() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double calculateInterest() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double calculateAnnualPayment() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
