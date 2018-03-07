/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bondsLigua_cs_controller_client;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

import bondsLigua_client.MainApp;

import java.awt.Button;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import tn.esprit.bondsLiga.bondsLigua_server.interfaces.companyServices;
import tn.esprit.bondsLiga.bondsLigua_server.persistence.Company;

/**
 * FXML Controller class
 *
 * @author MOEZ
 */
public class DeletecompanyController implements Initializable {
	@FXML
    private JFXButton RETOUUUUR;

    @FXML
    private JFXButton rechercher;
    @FXML
    private JFXButton supprimer;
    @FXML
    private Label msg;
    @FXML
    private JFXButton retour;
    @FXML
    private JFXTextField inputtokensharenumber;
    @FXML
    private JFXTextField inputfreesharenumber;
    @FXML
    private JFXTextField inputoperatingincome;
    @FXML
    private JFXTextField idcompany;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  
    @FXML
    private void retouuuurrr(ActionEvent event) {
    }
    
   
    @FXML
    private void rechercher(ActionEvent event) {
    }

    @FXML
    private void supprimer(ActionEvent event)throws NamingException {
    	
    	
    	String jndiName = "bondsLigua_server-ear/bondsLigua_server-ejb/companyServiceImpl!tn.esprit.bondsLiga.bondsLigua_server.interfaces.companyServices";
        Company t = new Company();
   		Context context=new InitialContext();
   		companyServices proxy=(companyServices)context.lookup(jndiName);
   	proxy.delete(Integer.parseInt(idcompany.getText()));
   		
   		
   		
   
    	
    }

    @FXML
    private void retour(ActionEvent event) {
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
    
}
