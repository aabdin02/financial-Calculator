/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FinancialApp.CurrencyDuplicate;

import java.util.Map;
import java.util.TreeMap;
/**
 *
 * @author aabdin02
 */
public class CurrencyRate {
    Map<String, Double> rates = new TreeMap();
    
    public Map<String,Double> getRates(){
        return rates;
    }
}
