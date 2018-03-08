/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FinancialApp.Algorithm.UI.PersonalLoan;

import FinancialApp.Algorithm.PersonalLoan;
import FinancialApp.Algorithm.UI.Amortization.PersonalLoanaData;
import java.io.IOException;
import java.net.URL;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author dawitabera
 */
public class PersonalLoanUIController implements Initializable {
    TableView<PersonalLoanaData> tableView = new TableView<>();
    ObservableList<PersonalLoanaData> list = FXCollections.observableArrayList();
    Stage primaryStage;
    PersonalLoan personalLoan;
    NumberFormat numberFormat ;
    
    Integer montlyPaymentIndicator;
    Double balance;
    Double interest;
    Double principal;
    Double mPayment;
    
    @FXML
    private TextField getLoanAmount;
    @FXML
    private TextField getInterestRate;
    @FXML
    private Label monthlyPaymentLabel;
    @FXML
    private Label totalPaymentLabel;
    @FXML
    private Label totalInterestLabel;
    @FXML
    private Label annualPaymentLabel;
    @FXML
    private Label showMonthlyPayment;
    @FXML
    private Label showTotalPayment;
    @FXML
    private Label showTotalInterest;
    @FXML
    private Label showAnnualPayment;
    @FXML
    private TextField getLoanTerm;
    @FXML
    private TextField getExtraPayment;
    

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    @FXML
    private void rest(ActionEvent event) {
        getExtraPayment.clear();
        getInterestRate.clear();
        getLoanAmount.clear();
        getLoanTerm.clear();
        showAnnualPayment.setText("");
        showMonthlyPayment.setText("");
        showTotalInterest.setText("");
        showTotalPayment.setText("");
    }

    @FXML
    private void email(ActionEvent event) {
    }

    @FXML
    private void caculate(ActionEvent event) {
        numberFormat = NumberFormat.getNumberInstance(Locale.US);
        if(getLoanAmount.getText().isEmpty()|| getLoanAmount.getText() ==""){
            return;
        }
        try {
            Integer.parseInt(getLoanAmount.getText());
            int loan = Integer.parseInt(getLoanAmount.getText());
            Double.parseDouble(getInterestRate.getText());
            double apr = Double.parseDouble(getInterestRate.getText());
            Integer.parseInt(getLoanTerm.getText());
            int term = Integer.parseInt(getLoanTerm.getText());
        if(loan == 0 || apr == 0 || term ==0){
            return;
        }
        
        personalLoan = new PersonalLoan(loan, (apr/100), term);
        monthlyPaymentLabel.setText("Monthly Payment: ");
        String MonthlyPayment = Double.toString(personalLoan.calulateMonthlyPayment());
        showMonthlyPayment.setText(MonthlyPayment);
        totalPaymentLabel.setText("Total Payment:");
        double total_Payment = personalLoan.calculateTotalPayment();
        String TotalPayment = numberFormat.format(total_Payment);
        showTotalPayment.setText(TotalPayment);
        totalInterestLabel.setText("Total Interest:");
        double total_interest = personalLoan.calculateInterest();
        String TotalInterest = numberFormat.format(total_interest);
        showTotalInterest.setText(TotalInterest);
        annualPaymentLabel.setText("Annual Payment:");
        double annual_Payment = personalLoan.calculateAnnualPayment();
        String annualPayment = numberFormat.format(annual_Payment);
        showAnnualPayment.setText(annualPayment);
        } catch (NumberFormatException e) {
            System.out.println("string found");
        }
        
    }

    @FXML
    private void amortization(ActionEvent event) {
        //create the table view 
        BorderPane border = new BorderPane();
        GridPane grid = new GridPane();
        ScrollPane scroll = new ScrollPane();
        
        Label labelTitle = new Label("Amortization Table");
        
        
        
        TableColumn noMonthColumn = new TableColumn("No.");
        noMonthColumn.setMinWidth(50);
        noMonthColumn.setCellValueFactory(new PropertyValueFactory("mIndicator"));
        
        TableColumn mpaymentColumn = new TableColumn("Monthly Payment");
        mpaymentColumn.setMinWidth(50);
        mpaymentColumn.setCellValueFactory(new PropertyValueFactory<>("mDue"));
        
        TableColumn interestColumn = new TableColumn("Interest");
        interestColumn.setMinWidth(50);
        interestColumn.setCellValueFactory(new PropertyValueFactory<>("mInterest"));

        TableColumn prinColumn = new TableColumn("Principal");
        prinColumn.setMinWidth(50);
        prinColumn.setCellValueFactory(new PropertyValueFactory<>("mPrincipal"));

        TableColumn balColumn = new TableColumn("Balance");
        balColumn.setMinWidth(50);
        balColumn.setCellValueFactory(new PropertyValueFactory<>("mbalanceDue"));

        tableView.getColumns().addAll(noMonthColumn,mpaymentColumn, interestColumn, prinColumn, balColumn);
        
        Double loanTotal = Double.parseDouble(getLoanAmount.getText());
        Integer year = Integer.parseInt(getLoanTerm.getText());
        Double rateInterest = Double.parseDouble(getInterestRate.getText());
        double monthlyInterest = rateInterest / 1200;
        double monthlyPayment = Math.round((loanTotal * monthlyInterest / (1 - 1 / Math.pow(1 + monthlyInterest, year * 12)))*100.00)/100.00;
        balance = loanTotal;

        for(int i = 1; i < year * 12; i++) {
            interest = Math.round((monthlyInterest * balance)*100.00)/100.00;
            principal = Math.round((monthlyPayment - interest)*100.00)/100.00;
            balance = Math.round((balance - principal)*100.00)/100.00;
            montlyPaymentIndicator = i;
            list.add(new PersonalLoanaData(montlyPaymentIndicator, monthlyPayment,interest, principal, balance));
            System.out.println("mIndicator: "+montlyPaymentIndicator+ "\t"+
                               "monthlyPayment: "+monthlyPayment+"\t"+
                                "interest: " +interest +"\t"+
                                "principal: "+ principal + "\t"+
                                "balance: " +balance);
        }
        tableView.getItems().setAll(list);
        
        grid.add(labelTitle, 0, 0);
        grid.add(new Label(), 0, 1);
        
        scroll.setContent(tableView);
        border.setTop(grid);
        border.setBottom(scroll);
        
        primaryStage = new Stage();
        Scene scene = new Scene(border, 800, 800);

        primaryStage.setScene(scene);
        primaryStage.show();
        
    }
    /**
     * 
     * @param loc   location of the fxml class
     * @param title to the scene 
     */
    void loadWindow(String loc, String title){
        try {
            Parent parent = FXMLLoader.load(getClass().getResource(loc));
            Stage stage = new Stage(StageStyle.DECORATED);
            stage.setTitle(title);
            stage.setScene(new Scene(parent));
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(PersonalLoanUIController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
