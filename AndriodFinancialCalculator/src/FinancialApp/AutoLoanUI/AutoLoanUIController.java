/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FinancialApp.AutoLoanUI;

import FinancialApp.Algorithm.AutoLoan;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author aabdin02
 */

public class AutoLoanUIController implements Initializable {
    FinancialApp.Algorithm.AutoLoan autoLoan;
    @FXML
    private TextField vehPrice;
    @FXML
    private TextField salesTaxPercent;
    @FXML
    private TextField feesTaxable;
    @FXML
    private TextField taxFree;
    @FXML
    private TextField downPayment;
    @FXML
    private TextField tradeInPayment;
    @FXML
    private TextField amountOwedTradeIn;
    @FXML
    private TextField interestRatePercent;
    @FXML
    private TextField loanTermMonths;
    @FXML
    private Text monthly;
    @FXML
    private Text sales;
    @FXML
    private Text amount;
    @FXML
    private Text total;
    @FXML
    private Text total1;
    @FXML
    private Text payment;
    @FXML
    private Text tax;
    @FXML
    private Text financed;
    @FXML
    private Text interest;
    @FXML
    private Text payment1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }   

    private double checkNull(TextField s){
        if(s.getText().length() <= 0){
            return 0.00;
        }
        return Double.parseDouble(s.getText());
    }
    private void calculatePayments(){
        int loanMonths = 0;
        
        checkNull(vehPrice);
        
        if(loanTermMonths.getText().length() > 0){
            loanMonths = Integer.parseInt(loanTermMonths.getText());
        }
        
        autoLoan = new AutoLoan(checkNull(vehPrice),
                                checkNull(salesTaxPercent),
                                checkNull(feesTaxable),
                                checkNull(taxFree),
                                checkNull(downPayment),
                                checkNull(tradeInPayment),
                                checkNull(amountOwedTradeIn),
                                checkNull(interestRatePercent),
                                loanMonths
        );
    }
    private void displayValues(){
        payment.setText(String.valueOf(Math.round((autoLoan.calulateMonthlyPayment() *100.00)/100.00)));
        tax.setText(String.valueOf(Math.round((autoLoan.getTotalSalesTax() *100.00)/100.00)));
        financed.setText(String.valueOf(Math.round((autoLoan.getAmountFinanced() *100.00)/100.00)));
        interest.setText(String.valueOf(Math.round((autoLoan.calculateInterest() *100.00)/100.00)));
        payment1.setText(String.valueOf(Math.round((autoLoan.calculateTotalPayment() *100.00)/100.00)));
        
        
    }
    //1 vehPrice,  2 salesTaxPercent,3 feesTaxable,3 taxFree, 4 downPayment,
    //5 tradeInPayment, 6 amountOwedTradeIn, 7 interestRatePercent, 8 loanTermMonths
    @FXML
    private void displayMonthSalesFinancedInterestTotalPayments(ActionEvent event) {
        calculatePayments();
        displayText();
        displayValues();
    }
    
    private void displayText(){
        this.monthly.setText("Monthly Payment:");
        this.sales.setText("            Sales Tax:");
        this.amount.setText("Amount Financed:");
        this.total.setText("     Total Interest: ");
        this.total1.setText("    Total Payment:");
    }
    
    
}
