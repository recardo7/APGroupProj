package controller;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;
import java.sql.SQLException;


//connection

public class Dbconn {
        private static Connection conn=null;
   
        
        public  static Connection getcon() {
        	if(conn==null) {
        		String url="jdbc:mysql://localhost:3306/studentsdb";
        		try {
        			
        			conn=DriverManager.getConnection(url,"root","");
        			JOptionPane.showMessageDialog(null,"Connection Established", "Connection status", JOptionPane.INFORMATION_MESSAGE);
        			
  
        		}
        		catch(SQLException e) {
        			System.err.println("SQLException"+e.getMessage());
        			
        		}
        		catch(Exception e) {
        			
        			System.err.println("Connection Failed"+e.getMessage());
        		}
        	}
			return conn;
        	
        }
}
