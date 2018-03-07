/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bondsLigua_cs_controller_client;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;

import bondsLigua_client.MainApp;

import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
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
public class modifcompanyController implements Initializable {
	@FXML
    private JFXButton RETOUUUUR;

	@FXML
	private JFXButton retour;
	@FXML
	private JFXTextField inputsharenumber;
	@FXML
	private JFXTextField inputtokensharenumber1;
	@FXML
	private JFXTextField inputoperatingincome;
	@FXML
	private JFXButton rechercher;
	@FXML
	private JFXButton Update;
	@FXML
	private JFXTextField idcompany;
	@FXML
	private Label msg;
	String idnew;

	/**
	 * Initializes the controller class.
	 */
	@Override
	public void initialize(URL url, ResourceBundle rb) {
		// TODO
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
	    

	@FXML
	private void rechercher(ActionEvent event) throws NamingException {

		int id = Integer.parseInt(idcompany.getText());
		String jndiName = "bondsLigua_server-ear/bondsLigua_server-ejb/companyServiceImpl!tn.esprit.bondsLiga.bondsLigua_server.interfaces.companyServices";
		Context context = new InitialContext();
		companyServices proxy = (companyServices) context.lookup(jndiName);
		Company c = proxy.searchById(id);
		if (c != null) {
			inputsharenumber.setText(c.getFreeShareNumber() + "");
			;
			inputtokensharenumber1.setText(c.getTokenSharesNUmber() + "");
			inputoperatingincome.setText(c.getOperatingIncome() + "");
		}

	}

	@FXML
	private void modifier2(ActionEvent event) throws NamingException {

		int id = Integer.parseInt(idcompany.getText());
		String jndiName = "bondsLigua_server-ear/bondsLigua_server-ejb/companyServiceImpl!tn.esprit.bondsLiga.bondsLigua_server.interfaces.companyServices";
		Context context = new InitialContext();
		companyServices proxy = (companyServices) context.lookup(jndiName);
		Company c = proxy.searchById(id);
		c.setFreeShareNumber(Integer.parseInt(inputsharenumber.getText()));
		c.setTokenSharesNUmber(Integer.parseInt(inputtokensharenumber1.getText()));
		c.setOperatingIncome(Float.parseFloat(inputoperatingincome.getText()));
		proxy.updateCompany(c);
	}

	void showPubDetails(Company e) throws ParseException {

		// System.out.println("id of event is " + e.getId_evenement());
		idnew = idcompany.getText();

		/*
		 * try { DateTimeFormatter formatter =
		 * DateTimeFormatter.ofPattern("dd/MM/yyyy"); LocalDate date =
		 * LocalDate.parse(dated, formatter); datetf.setValue(date);
		 * 
		 * } catch (DateTimeParseException exc) { // throw exc; // Rethrow the
		 * exception. }
		 */

		// status.setValue(e.getStatus());

	}
}
