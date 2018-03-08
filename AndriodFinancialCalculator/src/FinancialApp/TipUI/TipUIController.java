/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FinancialApp.TipUI;


import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author aabdin02
 */
public class TipUIController implements Initializable {

    @FXML
    private TextField enterTaxPercent;
    @FXML
    private TextField showTipPercent;
    @FXML
    private TextField showSplitLabel;
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
    @FXML
    private TextField enterBillLabel;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    } 
    
 
    private double calculateTipAmount(){
         double tipAmount = 0.00;
        try{
            double tipPercent = Double.parseDouble(showTipPercent.getText());
            double bill = getBill();
            tipAmount = tipPercent/100 * bill;
        }catch(NumberFormatException ex){
            System.out.println("Wrong Number");
        }
        return tipAmount;
    }
    private double getTaxAmount()throws NumberFormatException{    
        return getBill() *  (Double.parseDouble(enterTaxPercent.getText())/100);
    }
    private double getBill() throws  NumberFormatException{
        return Double.parseDouble(enterBillLabel.getText());
    }
    private double calculatePayment(){
       return getBill() + calculateTipAmount() + getTaxAmount();
    }

    @FXML
    private void calculate(ActionEvent event)  {
        try{
            showTaxTotal.setText("Total ");
            taxAmountLabel.setText("Tax Amount");
            TipAmount.setText("Tip Amount");
            Payment.setText(" Payment");

            showTaxTotal.setText("Total ");
            String value = Double.toString(getTaxAmount());
            showTaxAmount1.setText(value);

            String tip = Double.toString(Math.round(calculateTipAmount() * 100.00)/100.00);
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
        }catch(NumberFormatException exception){
            System.out.println("Enter A number");
        }

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
        tip += 1;
        
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

        String tipValue = Double.toString(tip);
        showSplitLabel.setText(tipValue);
        calculate(event);
    }

    
    
    
}
