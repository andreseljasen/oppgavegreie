package application;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller implements Initializable {
	
	
	
	public dbModel dbmodel = new dbModel();
	
	@FXML
	private Label isConnected;

    @FXML
    private Button seOppgaver;

    @FXML
    private Button Lagre;

    @FXML
    private Label leggTil;

    @FXML
    private TextField txtField;

    @FXML
    private TextField txtOppgave;
    
    @FXML
    private Button btnEndre;
	    

	    @FXML
	    void setOnAction(ActionEvent event) {

	    }

		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			// TODO Auto-generated method stub
			if (dbmodel.isDbConnected()) {
				isConnected.setText("Tilkoblet");
				String makeDB="CREATE TABLE Oppgaver (Oppgave TEXT PRIMARY KEY;)";
			} else {
				isConnected.setText("Ikke tilkoblet");
			}
			
		}
		
		public void Lagre (ActionEvent event) {
			try {
				if (dbmodel.erLagret()); {
					isConnected.setText("Lagret!");
				}
				
			}
				
			 catch (Exception e) {
				isConnected.setText("ikke lagret");
				e.printStackTrace();
			}
			
		}
		
		public void fjernOppave(ActionEvent event)  {
			try {
			if (dbmodel.oppgaveFerdig ()); {
				isConnected.setText("Oppgave markert som fullført!");
			}
			
		}
			
			catch (Exception e) {
				isConnected.setText("Error");
				e.printStackTrace();
			}
		}
		
		
		
		public void SeOppgaver (ActionEvent event) {
			try {
				
			if(dbmodel.oppgaveSe()) {
				isConnected.setText("Nåværende oppgaver:");
			}
		}
			catch (Exception e) {
				isConnected.setText("Error");
				e.printStackTrace();
			}	
			
		}
}
