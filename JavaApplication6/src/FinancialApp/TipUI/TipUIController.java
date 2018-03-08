/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FinancialApp.TipUI;

import java.awt.event.ActionListener;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author aabdin02
 */
public class TipUIController implements Initializable {

    @FXML
    private TextField enterBillLabel;
    @FXML
    private TextField enterTaxPercent;
    @FXML
    private TextField showTipPercent;
    @FXML
    private TextField showSplitLabel;
    @FXML
    private Button increaseTipAmountBy1;
    @FXML
    private Button reduceSplitBy1;
    @FXML
    private Button increaseSplit1;
    @FXML
    private Label EmptyBox;
    @FXML
    private Label taxAmountLabel;
    @FXML
    private Label TipAmount;
    @FXML
    private Label Payment;
    @FXML
    private Label showTaxTotal;
    @FXML
    private Label showTaxAmount1;
    @FXML
    private Label showTaxAmount2;
    @FXML
    private Label showTaxAmount3;
    @FXML
    private Label showEach;
    @FXML
    private Label showEachAmount1;
    @FXML
    private Label showEachAmount2;
    @FXML
    private Label showEachAmount3;
    @FXML
    private Label showRoundEachPaymentUp;
    @FXML
    private Button showReset;
    @FXML
    private Button showEmail;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    } 
    
    
    
    //Tax Amount = Same as the User Input
    //Tip Amount = (Tip % * Bill)
    //Payment = Tax Amount + TipAmount
    private double calculateTipAmount(){
        double tipPercent = Double.parseDouble(showTipPercent.getText());
        double bill = getBill();
        double tipAmmount = tipPercent/100 * bill;
        
        return tipAmmount;
    }
    private double getTaxAmount(){
        //System.out.print(Double.parseDouble(TipAmount.getText()));
        
        return getBill() *  (Double.parseDouble(enterTaxPercent.getText())/100);
    }
    private double getBill(){
        return Double.parseDouble(enterBillLabel.getText());
    }
    private double calculatePayment(){
       return getBill() + calculateTipAmount() + getTaxAmount();
    }

    @FXML
    private void calculate(ActionEvent event) {
         showTaxTotal.setText("Total ");
         taxAmountLabel.setText("Tax Amount");
         TipAmount.setText("Tip Amount");
         Payment.setText(" Payment");
         
         showTaxTotal.setText("Total ");
         String value = Double.toString(getTaxAmount());
         showTaxAmount1.setText(value);
        
         String tip = Double.toString(calculateTipAmount());
         showTaxAmount2.setText(tip);
         
         String payment = Double.toString(calculatePayment());
         showTaxAmount3.setText(payment);
         
         showEach.setText("Each");
         double noOfSplit = Double.parseDouble(showSplitLabel.getText());
         double taxAmount = Double.parseDouble(showTaxAmount1.getText());
         taxAmount = Math.round((taxAmount / noOfSplit) * 100.00)/100.00;
         showEachAmount1.setText(Double.toString(taxAmount));
         
         taxAmount = Double.parseDouble(showTaxAmount2.getText());
         taxAmount = Math.round((taxAmount / noOfSplit) * 100.00)/100.00;
         showEachAmount2.setText(Double.toString(taxAmount));
         
         taxAmount = Double.parseDouble(showTaxAmount3.getText());
         taxAmount = Math.round((taxAmount / noOfSplit)* 1.00);
         showEachAmount3.setText(Double.toString(taxAmount));
         
         String valueText = "Round each payment up: each pays ";
         valueText += "payment";
         valueText += "; each tip is ";
         valueText += "tipAmount, TipPercent";
         
         showRoundEachPaymentUp .setText(valueText );
         
    }

    @FXML
    private void reduceTipBy1(ActionEvent event) {
        Double tip = Double.parseDouble(showTipPercent.getText());
        tip -= 1;
        if(tip < 0){
            return;
        }
        String tipValue = Double.toString(tip);
        showTipPercent.setText(tipValue);
        calculate(event);
        
    }

    @FXML
    private void increaseTipBy1(ActionEvent event) {
        Double tip = Double.parseDouble(showTipPercent.getText());
        tip -= 1;
        if(tip < 0){
            return;
        }
        String tipValue = Double.toString(tip);
        showTipPercent.setText(tipValue);
        calculate(event);
    }

    @FXML
    private void reduceSplitBy1(ActionEvent event) {
        Double tip = Double.parseDouble(showSplitLabel.getText());
        tip -= 1;
        if(tip < 0){
            return;
        }
        String tipValue = Double.toString(tip);
        showSplitLabel.setText(tipValue);
        calculate(event);
    }

    @FXML
    private void increaseSplitBy1(ActionEvent event) {
        Double tip = Double.parseDouble(showSplitLabel.getText());
        tip += 1;
        if(tip < 0){
            return;
        }
        String tipValue = Double.toString(tip);
        showSplitLabel.setText(tipValue);
        calculate(event);
    }

    
    
    
}
