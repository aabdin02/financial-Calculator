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
public interface FinancialAppCalculator {
    public double calulateMonthlyPayment();
    public double calculateAmortization();
    public double calculateTotalPayment();
    public double calculateInterest();
    public double calculateAnnualPayment();
}
