package Server;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.xdevapi.Statement;

public class student {
        
	@SuppressWarnings("null")
	public void insert(char op,String id,String fname, String lname, String Sex,String email, String comp_type, String comp ) {
		
		
		Connection con= connection.myconnect();
	    PreparedStatement ps = null;
	    
	    //i stands for insert
	    if(op=='i') {
	    	try {
	    		
				ps =con.prepareStatement("INSERT INTO `students`(id, first_name, last_name, sex, email, type_of_complaint, complaint) VALUES (?,?,?,?,?,?,?)");
				ps.setString(1, id);
				ps.setString(2, fname);
		        ps.setString(3, lname);
		        ps.setString(4, Sex);
		        ps.setString(5, email);
		        ps.setString(6, comp_type);
		        ps.setString(7, comp);

			  
			    if(ps.executeUpdate()>0) {
			    	JOptionPane.showMessageDialog(null,"NEW COMPLAINT ADDED");
			    }
			   
			    
	    	
	    	
	    	} catch (SQLException e) {
				Logger.getLogger(student.class.getName()).log(Level.SEVERE,null,e);
			}
	    }
	}
	
	public void fillStudenttable(JTable table, String SEARCH) {
		Connection con= connection.myconnect();
		PreparedStatement ps=null;
		try {
			ps= con.prepareStatement("SELECT * FROM students WHERE CONCAT(id, first_name, last_name, sex, email, type_of_complaint, complaint, Staff_id, Response, Complaint_status, complaint_id) LIKE ?");
		    ps.setString(1, "%"+SEARCH+"%");
		    
		    
		    
		    
		    
		   ResultSet rs=ps.executeQuery();
		   ResultSetMetaData rmsd=rs.getMetaData();
				   
				   
				   
		    DefaultTableModel model=(DefaultTableModel)table.getModel();

		    int cols=rmsd.getColumnCount();
		    String[] colName=new String[cols];
		    
		    for(int i=0; i<cols; i++)
		    	colName[i]=rmsd.getColumnName(i+1);
		    model.setColumnIdentifiers(colName);
		    
		  Object[] row;
		  
		  while (rs.next()) {
			  row=new Object[10];
			  row[0]=rs.getString(1);
			  row[1]=rs.getString(2);
			  row[2]=rs.getString(3);
			  row[3]=rs.getString(4);
			  row[4]=rs.getString(5);
			  row[5]=rs.getString(6);
			  row[6]=rs.getString(7);
			  row[7]=rs.getString(8);
			  row[8]=rs.getString(9);
			  row[9]=rs.getString(10);
			
				 
			  
			  
			  model.addRow(row); 
		
			 
		  }
		          
		    
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void filltable(JTable table, String test) {
		
		 Connection con = connection.myconnect();
		    PreparedStatement ps = null;
		    try {
		        ps = con.prepareStatement("SELECT Staff_id, complaint_id, complaint, type_of_complaint FROM students WHERE CONCAT(id, first_name, last_name, sex, email, type_of_complaint, complaint, Staff_id,  Response, Complaint_status, complaint_id) LIKE ?");
		        ps.setString(1, "%" + test + "%");

		        ResultSet rs = ps.executeQuery();
		        ResultSetMetaData rmsd = rs.getMetaData();

		        DefaultTableModel model = (DefaultTableModel) table.getModel();
		        model.setRowCount(0); // clear existing rows

		        int cols = rmsd.getColumnCount();
		        String[] colName = new String[cols];

		        colName[0] = "Staff_id";
		        colName[1] = "complaint_id";
		        colName[2] = "complaint";
		        colName[3] = "type_of_complaint";

		        model.setColumnIdentifiers(colName);

		        Object[] row;

		        while (rs.next()) {
		            row = new Object[4];
		            row[0] = rs.getString("Staff_id");
		            row[1] = rs.getString("complaint_id");
		            row[2] = rs.getString("complaint");
		            row[3] = rs.getString("type_of_complaint");

		            boolean rowExists = false;
		            for (int i = 0; i < model.getRowCount(); i++) {
		                if (row[0].equals(model.getValueAt(i, 0)) &&
		                    row[1].equals(model.getValueAt(i, 1)) &&
		                    row[2].equals(model.getValueAt(i, 2)) &&
		                    row[3].equals(model.getValueAt(i, 3))) {
		                    rowExists = true;
		                    break;
		                }
		            }
		            if (!rowExists) {
		                model.addRow(row);
		            }
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		
		
		
		
		
		
		
		
		
		
	
		
		
		
		
		
		
		
		
		
	}
	
	
	
	
	
	public void fillassigned(JTable table, String search) {
		Connection con = connection.myconnect();
	    PreparedStatement ps = null;
	    try {
	        ps = con.prepareStatement("SELECT Staff_id, complaint_id, complaint, type_of_complaint, Response, Complaint_status FROM students WHERE CONCAT(id, first_name, last_name, sex, email, type_of_complaint, complaint, Staff_id,  Response, Complaint_status, complaint_id) LIKE ?");
	        ps.setString(1, "%" + search + "%");

	        ResultSet rs = ps.executeQuery();
	        ResultSetMetaData rmsd = rs.getMetaData();

	        DefaultTableModel model = (DefaultTableModel) table.getModel();
	        model.setRowCount(0); // clear existing rows

	        int cols = rmsd.getColumnCount();
	        String[] colName = new String[cols];

	        colName[0] = "Staff_id";
	        colName[1] = "complaint_id";
	        colName[2] = "complaint";
	        colName[3] = "type_of_complaint";
	        colName[4] = "Response";
	        colName[5] =  "Complaint_status";
	        model.setColumnIdentifiers(colName);

	        Object[] row;

	        while (rs.next()) {
	            row = new Object[6];
	            row[0] = rs.getString("Staff_id");
	            row[1] = rs.getString("complaint_id");
	            row[2] = rs.getString("complaint");
	            row[3] = rs.getString("type_of_complaint");
                row[4]=rs.getString("Response");
                row[5]=rs.getString("Complaint_status");
                
                
	            boolean rowExists = false;
	            for (int i = 0; i < model.getRowCount(); i++) {
	                if (row[0].equals(model.getValueAt(i, 0)) &&
	                    row[1].equals(model.getValueAt(i, 1)) &&
	                    row[2].equals(model.getValueAt(i, 2)) &&
	                    row[3].equals(model.getValueAt(i, 3)) &&
	                    row[4].equals(model.getValueAt(i, 4)) &&
	                    row[5].equals(model.getValueAt(i, 5))) {
	                    rowExists = true;
	                    break;
	                }
	            }
	            if (!rowExists) {
	                model.addRow(row);
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	
		
	
	}
	
	
}
