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
    private final int  initialLoan;
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
        this.initialLoan = loanAmount;
    }
    
    @Override
    public double calulateMonthlyPayment(){
        double ans = 12*(1-(Math.pow(1+(apr/12), -60)));
        double roundAns = Math.round((initialLoan*apr/ans)*100.00)/100.00;
        return roundAns;
    }
    public double calculatePrincipal(){
        return Math.round((calulateMonthlyPayment() - calculateMonthlyInterest())*100.00)/100.00;
    }
    @Override
    public double calculateAmortization(){
        loanAmount -= calculatePrincipal();

        return Math.round((loanAmount)*100.00)/100.00;
    }
    public void caluclateTotalAmortization(){
        int month = 1;
        while(loanAmount > 0){
             
             if(loanAmount  < calulateMonthlyPayment()){
                 print(month, loanAmount, calculateMonthlyInterest(),
                         calculatePrincipal(), 0);
                 return;
             }
             print(month, calulateMonthlyPayment(), calculateMonthlyInterest(),
                         calculatePrincipal(), calculateAmortization());
             
            month++;
        }
    } 
    void print (int month, double monthlyPayment, double monthlyInterest,
                double monthlyPrincipal, double remainingLoan){
        
         System.out.print((month + "\t"));
                System.out.print(monthlyPayment+ "\t");
                System.out.print(monthlyInterest + "\t");
                System.out.print(monthlyPrincipal + "\t");
                System.out.println(remainingLoan);
               
    }
    @Override
    public double calculateTotalPayment(){
        double totoalPayment = Math.round((calulateMonthlyPayment()*12*loanTerm)
                                           *100.0)/100.0;
        return totoalPayment;
    }
    @Override
    public double calculateInterest(){
        double Interest = Math.round((calculateTotalPayment()-loanAmount)*100.00)/100.00;
        return Interest;
    }
    public double calculateMonthlyInterest(){
        return Math.round((loanAmount * apr/12)*100.00)/100.00;
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
