package bondsLigua_client;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.application.*;
import javafx.stage.Stage;
import javafx.scene.*;
import javafx.fxml.*;
public class MainApp extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		try{
		Parent root = FXMLLoader.load(getClass().getResource("../bondsLigua_fxmlcs_client/addcompany.fxml"));
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
		
	}catch(IOException ex){
		Logger.getLogger(MainApp.class.getName()).log(Level.SEVERE,null,ex);
	}
	}	

	public static void main(String[] args)
	{ launch(args);}
}
