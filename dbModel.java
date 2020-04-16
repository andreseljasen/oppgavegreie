package application;
import java.awt.TextField;
import java.sql.*;

import javax.swing.JOptionPane;

import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import net.proteanit.sql.DbUtils;
public class dbModel {
	Connection connection;
	 
	@FXML
	 private TextField txtOppgave;
    @FXML
    private TextField txtField;
    
    @FXML
    private TableView<?> table;
	
	public dbModel () {
		connection = sqliteConnection.Connector();
		if (connection==null) System.exit(1);
	}
	
	public boolean isDbConnected() {
		try {
			return !connection.isClosed();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	private Connection connect1() {
        String url = "jdbc:sqlite:obligDB.sqlite";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

	public boolean erLagret() throws SQLException {
		String sql="INSERT INTO Oppgaver (Oppgave) VALUES (?)";

		try (Connection conn = this.connect1();
            PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setString(1, txtField.getText());
            pst.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
		return false;
	}
	

	/*public boolean oppgaveFerdig() {
		String sql2="DELETE FROM Oppgaver WHERE Oppgave ='"+txtOppgave.getText()+"'";
		TextField txtOppgave = new TextField();

		try (Connection conn = this.connect1();
            PreparedStatement pst = conn.prepareStatement(sql2)) {
            pst.setString(1, txtOppgave.getText());
            pst.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
		return true;
	}*/
	
	public boolean oppgaveSe() {
		try {
			String query="select * from Oppgaver";
			ResultSet rs = connection.createStatement().executeQuery(query);
			PreparedStatement pst=connection.prepareStatement(query);
			//ResultSet rs = pst.executeQuery();
			//pst.setString(1, txtField.getText());
			
			
		} catch(Exception a) {
			a.printStackTrace();
		}
		return false;
	}
	
	public boolean oppgaveFerdig() {
	  {
	    try
	    {
	      // create the mysql database connection
	      String sqlDriver = "com.mysql.jdbc.Driver";
	      String myUrl = "jdbc:mysql:obligDB.sqlite";
	      Class.forName(sqlDriver);
	      Connection conn = DriverManager.getConnection(myUrl, "root", "");
	      
	      // create the mysql finished statement.
	      String query = "delete from Oppgaver where Oppgave ='txtOppgave.getText()'";
	      PreparedStatement preparedStmt = conn.prepareStatement(query);
	      preparedStmt.setInt(1, 3);

	      // execute the preparedstatement
	      preparedStmt.execute();
	      
	      conn.close();
	    }
	    catch (Exception e)
	    {
	      System.err.println("Error");
	      System.err.println(e.getMessage());
	    }
	    return false;
	  }
	  
	}
	
}
