/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bondsLigua_cs_controller_client;

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


/**
 * FXML Controller class
 *
 * @author MOEZ
 */
public class addcompanyController implements Initializable {

    @FXML
    private JFXTextField inputsharenumber;
    @FXML
    private JFXTextField inputtokensharenumber;
    @FXML
    private JFXButton Ajouter;
    @FXML
    private JFXButton Afficher;
    @FXML
    private JFXButton supprimer;
    @FXML
    private JFXButton modifier;
    @FXML
    private JFXButton retour;
    @FXML
    private JFXTextField inputoperatingincome;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void Ajouter(ActionEvent event) throws NamingException {
    	String jndiName = "bondsLigua_server-ear/bondsLigua_server-ejb/companyServiceImpl!tn.esprit.bondsLiga.bondsLigua_server.interfaces.companyServices";
        Company t = new Company();
   		Context context=new InitialContext();
   		companyServices proxy=(companyServices)context.lookup(jndiName);
   	
   		t.setFreeShareNumber(Integer.parseInt(inputsharenumber.getText()));
   		t.setOperatingIncome(Float.parseFloat(inputoperatingincome.getText()));
   		t.setTokenSharesNUmber(Integer.parseInt(inputtokensharenumber.getText()));
   		proxy.addCompany(t);
    	
    }

    @FXML
    private void Afficher(ActionEvent event)throws IOException {
    	try {

			Stage stage = new Stage();
			Parent root = FXMLLoader.load(getClass().getResource("../bondsLigua_fxmlcs_client/affichagecompany.fxml"));
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.show();

		} catch (IOException ex) {
			Logger.getLogger(MainApp.class.getName()).log(Level.SEVERE,null,ex);
		}
    }

    @FXML
    private void supprimer(ActionEvent event)throws IOException {
    	try {

			Stage stage = new Stage();
			Parent root = FXMLLoader.load(getClass().getResource("../bondsLigua_fxmlcs_client/deletecompany.fxml"));
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.show();

		} catch (IOException ex) {
			Logger.getLogger(MainApp.class.getName()).log(Level.SEVERE,null,ex);
		}

    }

    @FXML
    private void modifier(ActionEvent event) throws IOException{
    	try {

			Stage stage = new Stage();
			Parent root = FXMLLoader.load(getClass().getResource("../bondsLigua_fxmlcs_client/modifcompany.fxml"));
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
    
}
