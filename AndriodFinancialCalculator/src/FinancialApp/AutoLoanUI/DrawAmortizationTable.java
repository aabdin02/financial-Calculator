/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FinancialApp.AutoLoanUI;

import javafx.scene.layout.BorderPane;
import javafx.util.Pair;
import java.util.ArrayList;
import javafx.beans.value.ObservableIntegerValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
/**
 *
 * @author aabdin02
 */
public class DrawAmortizationTable {

    public DrawAmortizationTable(ArrayList<Pair <Double, Pair<Double, Double>>> table) {
        BorderPane border = new BorderPane();
        ScrollPane scroll = new ScrollPane();
        TableView<Double> tableView = new TableView<>();
        ObservableList<Double> list = FXCollections.observableArrayList(12.0, 13.0);

        TableColumn no_months = new TableColumn("No of Months           ");
//        TableColumn amount    = new TableColumn("Monthly Payment");
//        TableColumn monthlyI = new TableColumn("Monthly Interest");
//        TableColumn monthlyPr    = new TableColumn("Principal");
//        TableColumn balance = new TableColumn("Balance");
//        tableView.getColumns().addAll(no_months, amount, monthlyI, monthlyPr, balance);
//        tableView.getColumns().addAll(no_months);

        tableView.getColumns().addAll(no_months);
        
        scroll.setContent(tableView);
        border.setTop(scroll);
        Stage primaryStage = new Stage();
        Scene scene = new Scene(border,500, 500);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    public void draw(){
        
    }
    
    
}
