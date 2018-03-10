/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CredCardPayoff;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author aabdin02
 */
public class CreditCardUIController implements Initializable {

    @FXML
    private TextField balance;
    @FXML
    private TextField interestRatePr;
    @FXML
    private TextField monthlyPay;
    @FXML
    private TextField debtFree;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void reset(ActionEvent event) {
    }

    @FXML
    private void dispalyInterestPayment(ActionEvent event) {
    }
    
}
