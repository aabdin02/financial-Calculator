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
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
/**
 *
 * @author aabdin02
 */
public class DrawAmortizationTable {

    public DrawAmortizationTable(ArrayList<Pair <Double, Pair<Double, Double>>> table) {
        BorderPane border = new BorderPane();
        GridPane grid = new GridPane();
        ScrollPane scroll = new ScrollPane();
        TableView<ArrayList<Pair <Double, Pair<Double, Double>>>> tableView = new TableView<>();
        ObservableList<ArrayList<Pair <Double, Pair<Double, Double>>>> list = FXCollections.observableArrayList();
        
        TableColumn no_months = new TableColumn("No of Months");
        TableColumn amount    = new TableColumn("Monthly Payment");
        TableColumn monthlyI = new TableColumn("Monthly Interest");
        TableColumn monthlyPr    = new TableColumn("Principal");
        TableColumn balance = new TableColumn("Balance");
        
        Label labelTitle = new Label("Amortization Table");
        tableView.getColumns().addAll(no_months, amount, monthlyI, monthlyPr, balance);
        list.add(table);
        tableView.getItems().setAll(list);

//        grid.add(labelTitle, 0, 0);
//        grid.setMaxHeight(10);
//        grid.add(new Label(), 0, 1);
        
        scroll.setContent(tableView);
//        border.setTop(grid);
        border.setTop(scroll);
//        border.setBottom(grid);
        
        Stage primaryStage = new Stage();
        Scene scene = new Scene(border, 1000, 1000);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    
}
