/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FinancialApp.Algorithm.UI;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author dawitabera
 */
public class AppMainWindowController implements Initializable {

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void calulatePersonalLoan(ActionEvent event) {
        loadWindow("/FinancialApp/Algorithm/UI/PersonalLoan/personalLoanUI.fxml", "Personal Loan Calculator");
    }

    @FXML
    private void calulateCreditPayoff(ActionEvent event) {
    }

    @FXML
    private void calulateAutoLoan(ActionEvent event) {
    }

    @FXML
    private void calulateTVM(ActionEvent event) {
    }

    @FXML
    private void calulateTip(ActionEvent event) {
        loadWindow("/FinancialApp/TipUI/FinancialApp.TipUI.fxml", "Tip Calculator");
    }

    @FXML
    private void calulateDiscount(ActionEvent event) {
    }
    void loadWindow(String location, String title){
        try {
            Parent parent = FXMLLoader.load(getClass().getResource(location));
            Stage stage = new Stage(StageStyle.DECORATED);
            stage.setTitle(title);
            stage.setScene(new Scene(parent));
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(AppMainWindowController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
