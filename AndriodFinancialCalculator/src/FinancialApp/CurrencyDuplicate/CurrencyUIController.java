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
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
/**
 * FXML Controller class
 *
 * @author aabdin02
 */
public class CurrencyUIController implements Initializable {
     static URL url;
    private static String apiProver = "http://data.fixer.io/api/latest?access_key=5df0ce6206b1addd28e50cb012e0d715&format=1";
    static CurrencyRate rates;
    ObservableList<String> observableList;
    @FXML
    private ComboBox<?> fromListDisplay;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        validateApiProver();
    }
    
    public static void validateApiProver(){
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
    
    public static void main(String [] args) throws  Exception{
        validateApiProver();
        System.out.println(rates.getRates().get("AFN"));
    }

    private void FromList(){
        observableList = FXCollections.observableArrayList(rates.getRates().keySet());
        ObservableList<String> fromList = FXCollections.observableArrayList() ;
        Set set = rates.getRates().keySet();
            Iterator iterator = set.iterator();
            while (iterator.hasNext()) { 
                Map.Entry MEntry = (Map.Entry)iterator.next();
                fromList.addAll(MEntry.getKey().toString());
            }
            fromListDisplay.setItems(fromList);
        
    }

    @FXML
    private void toList(ActionEvent event) {
    }

    
    
}
