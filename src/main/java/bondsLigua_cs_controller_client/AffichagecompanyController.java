/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bondsLigua_cs_controller_client;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import tn.esprit.bondsLiga.bondsLigua_server.interfaces.companyServices;
import tn.esprit.bondsLiga.bondsLigua_server.persistence.Company;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

import bondsLigua_client.MainApp;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import tn.esprit.bondsLiga.bondsLigua_server.interfaces.companyServices;
import tn.esprit.bondsLiga.bondsLigua_server.persistence.Company;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.application.*;
import javafx.stage.Stage;
import javafx.scene.*;
import javafx.fxml.*;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.beans.*;
import java.net.URL;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;
import java.util.function.Predicate;
import java.util.logging.Filter;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ResourceBundle;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.collections.FXCollections;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import javafx.collections.ObservableList;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import java.sql.Date;
import java.util.*;
import javafx.event.EventHandler;
import javafx.scene.*;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import java.beans.*;
/**
 * FXML Controller class
 *
 * @author MOEZ
 */
public class AffichagecompanyController implements Initializable {

    @FXML
    private JFXButton retour;
    @FXML
    private Button RETOUUUUR;
    @FXML
    private TableView<Company> table;
    @FXML
    private TableColumn<?, ?> immatriculationnumber;
    @FXML
    private TableColumn<?, ?> freesharenumber;
    @FXML
    private TableColumn<?, ?> operatingincome;
    @FXML
    private TableColumn<?, ?> tokensharenumber;
    ObservableList<Company> data = FXCollections.observableArrayList();
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    	
    	
   		
    	/*String jndiName = "SLTS_server-ear/SLTS_server-ejb/PortfolioServiceImp!tn.esprit.SLTS_server.service.Portfolioservice";
		Context context = new InitialContext();

		Portfolioservice proxy = (Portfolioservice) context.lookup(jndiName);

		idcol.setCellValueFactory(new PropertyValueFactory<>("id"));
		usercol.setCellValueFactory(new PropertyValueFactory<>("id_user"));
		datecol.setCellValueFactory(new PropertyValueFactory<>("date_creation"));
		currencycol.setCellValueFactory(new PropertyValueFactory<>("currency"));
		cashcol.setCellValueFactory(new PropertyValueFactory<>("cashflow"));
		System.out.println("ddd");

		List<Portfolio> o = proxy.findAllPortfolio();
		for (Portfolio e : o) {
			data.add(e);

		}

		table1.setItems(data);*/
    	try {
			afficher();
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    } 
    @FXML
    private void retouuuuur(ActionEvent event) throws IOException {
    	try {

			Stage stage = new Stage();
			Parent root = FXMLLoader.load(getClass().getResource("../bondsLigua_fxmlcs_client/addcompany.fxml"));
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.show();

		} catch (IOException ex) {
			Logger.getLogger(MainApp.class.getName()).log(Level.SEVERE,null,ex);
		}

    }

    @FXML
    private void retour(ActionEvent event) {
    }
    
    void afficher() throws NamingException{
    	
    	
    	
    	String jndiName = "bondsLigua_server-ear/bondsLigua_server-ejb/companyServiceImpl!tn.esprit.bondsLiga.bondsLigua_server.interfaces.companyServices";
        Company t = new Company();
   		Context context=new InitialContext();
   		companyServices proxy=(companyServices)context.lookup(jndiName);
   		
   		immatriculationnumber.setCellValueFactory(new PropertyValueFactory("immatriculationNumber") );
   		freesharenumber.setCellValueFactory(new PropertyValueFactory("freeShareNumber"));
   		operatingincome.setCellValueFactory(new PropertyValueFactory("operatingIncome"));
   		tokensharenumber.setCellValueFactory(new PropertyValueFactory("tokenSharesNUmber"));
   		List<Company> o = proxy.getAllCompany();
		for (Company e : o) {
			data.add(e);

		}

		table.setItems(data);
   		
   		
   		
    	
    	
    	
    }

    
}
