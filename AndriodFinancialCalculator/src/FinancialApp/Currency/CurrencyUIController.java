/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FinancialApp.Currency;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import FinancialApp.Algorithm.*;
import static FinancialApp.Algorithm.CurrecyConvertor.convert;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * FXML Controller class
 *
 * @author dawitabera
 */
public class CurrencyUIController implements Initializable {
    private static final String API_PROVIDER = "http://data.fixer.io/api/latest?access_key=5df0ce6206b1addd28e50cb012e0d715&format=1";
    CurrecyConversion response = null;
    Gson gson;
    StringBuffer sb;

    @FXML
    private ComboBox<String> fromRate;
    @FXML
    private ComboBox<String> toRate;
    @FXML
    private Label showCalLabel;
    @FXML
    private TextField exRateField;
    @FXML
    private TextField amountField;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        fromCountryComboBox();
        toCountryComboBox();
    }    

    @FXML
    private void calculateCurrency(ActionEvent event) {
        String getFrom = fromRate.getValue();
        String getTo = toRate.getValue();
        if(getFrom.isEmpty() || getTo.isEmpty() || amountField.getText().isEmpty()){
            return;
        }
        System.out.println(getFrom);
        System.out.println(getTo);
        double conRate = Math.round((convert(getFrom, getTo)*100.00)/100.00);
        System.out.println(conRate);
        String rate = Double.toString(conRate);
        exRateField.setText(rate);
        
        String amountString = amountField.getText();
        double amount = Double.parseDouble(amountString);
        showCalLabel.setText("The: " + amount + " "+ getFrom + " is "+
                            Math.round((conRate*amount)*100.00)/100+" "+
                            getTo + " today");
    }
    public void fromCountryComboBox(){
        ObservableList<String> fromList = FXCollections.observableArrayList();
        gson = new Gson();
        sb = new StringBuffer();
        
        if(API_PROVIDER == null || API_PROVIDER.isEmpty()){
            System.out.println("Application Error");
            return;
        }
        URL url; 
        try {
            url = new URL(API_PROVIDER);
            HttpURLConnection connection = (HttpURLConnection)url.openConnection();
            InputStream stream = connection.getInputStream();
            System.out.println("Application API connection Succesful.....");
            int data = stream.read();
            while (data !=-1) {
                sb.append((char)data);
                data = stream.read();
            }
            stream.close();
            response = gson.fromJson(sb.toString(), CurrecyConversion.class);
            //System.out.println(sb.toString());
            //
            Set set = response.rates.entrySet();
            Iterator iterator = set.iterator();
            while (iterator.hasNext()) { 
                Map.Entry MEntry = (Map.Entry)iterator.next();
                fromList.addAll(MEntry.getKey().toString());
            }
        } catch(IOException e){
            System.out.println(e.getMessage());
        }
        fromRate.setItems(fromList);
    }
    public void toCountryComboBox(){
        ObservableList<String> fromList = FXCollections.observableArrayList();
        gson = new Gson();
        sb = new StringBuffer();
        
        if(API_PROVIDER == null || API_PROVIDER.isEmpty()){
            System.out.println("Application Error");
            return;
        }
        URL url; 
        try {
            url = new URL(API_PROVIDER);
            HttpURLConnection connection = (HttpURLConnection)url.openConnection();
            InputStream stream = connection.getInputStream();
            
            int data = stream.read();
            while (data !=-1) {
                sb.append((char)data);
                data = stream.read();
            }
            stream.close();
            response = gson.fromJson(sb.toString(), CurrecyConversion.class);
            
            Set set = response.rates.entrySet();
            Iterator iterator = set.iterator();
            while (iterator.hasNext()) { 
                Map.Entry MEntry = (Map.Entry)iterator.next();
                //System.out.println((String[]) MEntry.getKey());
                
                fromList.addAll(MEntry.getKey().toString());
            }
        } catch(IOException e){
            System.out.println(e.getMessage());
        }
        toRate.setItems(fromList);
    }
    
}
