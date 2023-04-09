package Server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class connection {
	 
	private static Connection connect=null;

	public static Connection myconnect(){
		if(connect==null) {
			String url="jdbc:mysql://localhost:3306/student";
		try {
			connect=DriverManager.getConnection(url,"root","");
		    JOptionPane.showMessageDialog(null,"Connection established");
			
		}catch(SQLException e) {
			System.err.println("SQlException"+e.getMessage());
		}catch (Exception e) {
			System.err.println("Something went wrong"+e.getMessage());
		}
	
	}
		return connect;
	
	}
	
	

}
