/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FinancialApp.CredCardPayoff;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import FinancialApp.Algorithm.creditCardpayOff;
import javafx.scene.text.Text;
/**
 * FXML Controller class
 *
 * @author aabdin02
 */
public class CreditCardUIController implements Initializable {
    creditCardpayOff creditCard;
    @FXML
    private TextField balance;
    @FXML
    private TextField interestRatePr;
    @FXML
    private TextField monthlyPay;
    @FXML
    private TextField debtFree;
    @FXML
    private Text totalInterest;
    @FXML
    private Text totalPayment;
    @FXML
    private Text totalInterestPayment;
    @FXML
    private Text totalPaymentAmount;

    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    

    @FXML
    private void reset(ActionEvent event) {
        inject(totalInterest,"", totalInterestPayment, -1);
        inject(totalPayment,"", totalPaymentAmount, -1);
    }

    private double checkNull(TextField text){
        if(text.getText().length() > 0){
//            return 0;//Double.parseDouble(text.getText());
        }
        return 0.00;
    }
    
    private int checkNullInt(TextField text){
        if(text.getText().length() > 0){
            return Integer.parseInt(text.getText());
        }
        return 0;
    }
    @FXML
    private void dispalyInterestPayment(ActionEvent event) {
        creditCard = new creditCardpayOff(checkNull(balance),
                                          checkNull(interestRatePr),
                                          checkNullInt(monthlyPay),
                                          checkNullInt(debtFree));
        
        inject(totalInterest,"Total Interest", totalInterestPayment, creditCard.calculateTotalInterest());
        inject(totalPayment,"Total Payment", totalPaymentAmount, creditCard.calculateTotalPayment());
    }
    
    private void inject(Text t, String s, Text val, double value){
        t.setText(s);
        if(value > 0){
          val.setText(Double.toString(value));
        }else{
            val.setText("");
        }
    }
    
}
