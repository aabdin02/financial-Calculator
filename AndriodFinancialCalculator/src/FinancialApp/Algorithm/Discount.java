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
public class Discount {
    private  final double regularPrice;
    private final double salesTax;
    private double toPayPrice;
    private final double percent;
    private final double additional;
    private final double additional1;
    
    public Discount(boolean off, double reg, double salesT, double per
                    , double add, double add1){
        this.regularPrice = reg;
        this.additional = add;
        this.salesTax= salesT;
        this.percent = per;
        this.additional1 = add1;
        this.toPayPrice = reg - (reg * per)/100;
        this.toPayPrice -= (add * toPayPrice)/100;
        this.toPayPrice -= (add1 * toPayPrice)/100;
    }
   
    
    public double getSavings(){
        return (regularPrice + getSalesTax() - getTotalPayment());
    }
    public double getSalesTax(){
        return (toPayPrice * salesTax)/100;
    }
    public double getTotalPayment(){
        return toPayPrice + getSalesTax();
    }
    
    public double totalPercentOff(){
        return (getSavings() * toPayPrice)/100;
    }
}
