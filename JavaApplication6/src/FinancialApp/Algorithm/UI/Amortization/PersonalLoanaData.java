/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FinancialApp.Algorithm.UI.Amortization;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;

/**
 *
 * @author dawitabera
 */
public class PersonalLoanaData {
    private final SimpleIntegerProperty mIndicator; 
    private final SimpleDoubleProperty mDue; 
    private final SimpleDoubleProperty mInterest; 
    private final SimpleDoubleProperty mPrincipal;  
    private final SimpleDoubleProperty mbalanceDue; 
    
    public PersonalLoanaData(int mIndicator,double mDue, double mInterest, double mPrincipal,double mbalanceDue ){
        this.mIndicator = new SimpleIntegerProperty(mIndicator);
        this.mDue = new SimpleDoubleProperty(mDue);
        this.mInterest = new SimpleDoubleProperty(mInterest);
        this.mPrincipal = new SimpleDoubleProperty(mPrincipal);
        this.mbalanceDue = new SimpleDoubleProperty(mbalanceDue);    
    }

    public Integer getmIndicator() {
        return mIndicator.get();
    }

    public Double getmDue() {
        return mDue.get();
    }

    public Double getmInterest() {
        return mInterest.get();
    }

    public Double getmPrincipal() {
        return mPrincipal.get();
    }

    public Double getMbalanceDue() {
        return mbalanceDue.get();
    }
    
    
}
