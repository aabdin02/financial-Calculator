/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FinancialApp.Algorithm;

/**
 *
 * @author dawitabera
 */
public class PersonalLoan implements FinancialAppCalculator{
    public int loanAmount;
    public double apr;
    public int loanTerm;
    /**
     * 
     * @param loanAmount the loan amount 
     * @param apr 
     * @param loanTerm in years
     */
    public PersonalLoan(int loanAmount, double apr, int loanTerm) {
        this.loanAmount = loanAmount;
        this.apr = apr;
        this.loanTerm = loanTerm;
    }
    
    @Override
    public double calulateMonthlyPayment(){
        double ans = 12*(1-(Math.pow(1+(apr/12), -60)));
        double roundAns = Math.round((loanAmount*apr/ans)*100.0)/100.0;
        return roundAns;
    }
    @Override
    public double calculateAmortization(){
        double Amortization = 0;
        return Amortization;
    }
    @Override
    public double calculateTotalPayment(){
        double totoalPayment = Math.round((calulateMonthlyPayment()*12*loanTerm)
                                           *100.0)/100.0;
        return totoalPayment;
    }
    @Override
    public double calculateInterest(){
        double Interest = Math.round((calculateTotalPayment()-loanAmount)*100)/100;
        return Interest;
    }
    @Override
    public double calculateAnnualPayment(){
        double AnnualPayment = Math.round((calulateMonthlyPayment()*12)
                                           *100.0)/100.0;;
        return AnnualPayment;
    }

    public int getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(int loanAmount) {
        this.loanAmount = loanAmount;
    }

    public double getApr() {
        return apr;
    }

    public void setApr(double apr) {
        this.apr = apr;
    }

    public int getLoanTerm() {
        return loanTerm;
    }

    public void setLoanTerm(int loanTerm) {
        this.loanTerm = loanTerm;
    }
    
    
    
    
}
