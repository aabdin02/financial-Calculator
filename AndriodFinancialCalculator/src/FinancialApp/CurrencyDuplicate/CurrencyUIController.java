/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FinancialApp.CurrencyDuplicate;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import com.google.gson.Gson;
import java.net.HttpURLConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
/**
 * FXML Controller class
 *
 * @author aabdin02
 */
public class CurrencyUIController implements Initializable {
     static URL url;
    private String apiProver = "http://data.fixer.io/api/latest?access_key=5df0ce6206b1addd28e50cb012e0d715&format=1";
    CurrencyRate rates;
    ObservableList<String> observableList;
    @FXML
    private  ComboBox<String> fromListDisplay;
    @FXML
    private ComboBox<String> toListDisplay;
    @FXML
    private TextArea fromAmount;
    @FXML
    private TextField toAmount;
    @FXML
    private TextField exchangeRate;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        validateApiProver();
        getCountries();

    }
    
    public  void validateApiProver(){
        Gson gson = new Gson();
        
        try{
            url = new URL(apiProver);
            HttpURLConnection connection = (HttpURLConnection)url.openConnection();

            String results = "";

            int data = connection.getInputStream().read();

            while(data != -1){
                results += (char)data;
                data = connection.getInputStream().read();
            }

            rates = gson.fromJson(results, CurrencyRate.class);
        }
        catch(Exception ex){
            System.out.println("Not Connected to API");
        }
    }
    
   
    private void getCountries(){
       ObservableList<String> observable = FXCollections.observableArrayList(rates.getRates().keySet());
       fromListDisplay.setItems(observable);
       toListDisplay.setItems(observable);
    }

    @FXML
    private void getExchange(ActionEvent event) {
        double from = rates.getRates().get(fromListDisplay.getValue());
        double to = rates.getRates().get(toListDisplay.getValue());
        
        double exchangeRate = (from * (Double.parseDouble(fromAmount.getText())));
        
        this.exchangeRate.setText(Double.toString(exchangeRate));
       
        exchangeRate /= to;
        
        this.toAmount.setText(Double.toString(exchangeRate));

        
    }


    
    
}
