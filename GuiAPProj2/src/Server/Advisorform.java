package Server;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class Advisorform extends JFrame {

	private JPanel contentPane;
	//private JTable table;
	private JTextField responsField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Advisorform frame = new Advisorform();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	student std=new student();
	private JTextField search_textField;
	
	
	
	
	
	/**
	 * Create the frame.
	 */
	public Advisorform() {
		
		
		
		DefaultTableModel model = new DefaultTableModel();
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1020, 792);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		JTable table = new JTable();
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
				  int selectedRow = table.getSelectedRow();
				    if (selectedRow != -1) {
				        // Get the values from the selected row
				        String complaintId = table.getValueAt(selectedRow, 1).toString();
				        String response = JOptionPane.showInputDialog("Enter Response");
				        String complaintStatus = JOptionPane.showInputDialog("Enter Complaint Status");

				        // Update the database with the new values for Response and Complaint Status
				        Connection con = connection.myconnect();
				        PreparedStatement ps = null;
				        try {
				            ps = con.prepareStatement("UPDATE students SET Response=?, Complaint_status=? WHERE complaint_id=?");
				            ps.setString(1, response);
				            ps.setString(2, complaintStatus);
				            ps.setString(3, complaintId);
				            ps.executeUpdate();
				        } catch (SQLException ex) {
				            ex.printStackTrace();
				        } finally {
				            try {
				                if (ps != null) ps.close();
				                if (con != null) con.close();
				            } catch (SQLException ex) {
				                ex.printStackTrace();
				            }
				        }

				        // Refresh the table to show the updated data
				        model.setRowCount(0);
				        std.filltable(table, "");
				    }
				
				
				
				
				
			}
		});
		scrollPane.setBounds(134, 171, 862, 528);
		contentPane.add(scrollPane);
		
		
		scrollPane.setViewportView(table);
		table.setModel(model);
		
		
		std.fillassigned(table, "");
		
		JLabel lblNewLabel = new JLabel("Advisor Dashboard");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 26));
		lblNewLabel.setBounds(718, 0, 379, 47);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Response:");
		lblNewLabel_1.setFont(new Font("Trebuchet MS", Font.ITALIC, 18));
		lblNewLabel_1.setBounds(10, 55, 102, 34);
		contentPane.add(lblNewLabel_1);
		
		responsField = new JTextField();
		responsField.setBounds(107, 54, 265, 34);
		contentPane.add(responsField);
		responsField.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Complaint Status:");
		lblNewLabel_1_1.setFont(new Font("Trebuchet MS", Font.ITALIC, 18));
		lblNewLabel_1_1.setBounds(10, 130, 156, 34);
		contentPane.add(lblNewLabel_1_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Resolved ", "Unresolved", "Pending"}));
		comboBox.setBounds(176, 130, 164, 31);
		contentPane.add(comboBox);
		
		JButton SubmitButton = new JButton("Submit Record");
		SubmitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow = table.getSelectedRow();

		        // check if a row is selected
		        if (selectedRow == -1) {
		            JOptionPane.showMessageDialog(contentPane, "Please select a row to edit");
		            return;
		        }

		        // get the new response and complaint status values
		        String response = responsField.getText();
		        String status = comboBox.getSelectedItem().toString();

		        // update the response and complaint status in the selected row in the database
		        String complaintId = (String) table.getValueAt(selectedRow, 1); // get the complaint ID from the selected row
		        try {
		            Connection con = connection.myconnect();
		            PreparedStatement ps = con.prepareStatement("UPDATE students SET Response = ?, Complaint_status = ? WHERE Complaint_id = ?");
		            ps.setString(1, response);
		            ps.setString(2, status);
		            ps.setString(3, complaintId);
		            int rowsUpdated = ps.executeUpdate();

		            // check if the row was successfully updated
		            if (rowsUpdated == 1) {
		                JOptionPane.showMessageDialog(contentPane, "Updated successfully");
		                std.fillassigned(table, ""); // refresh the table
		            } else {
		                JOptionPane.showMessageDialog(contentPane, "Failed to update");
		            }

		        } catch (SQLException ex) {
		            ex.printStackTrace();
		        }
				
				
				
			}
		});
		SubmitButton.setFont(new Font("Tahoma", Font.ITALIC, 18));
		SubmitButton.setBounds(456, 53, 170, 45);
		contentPane.add(SubmitButton);
		
		JButton btnLogOut = new JButton("LOG OUT");
		btnLogOut.setFont(new Font("Tahoma", Font.ITALIC, 18));
		btnLogOut.setBounds(-4, 709, 170, 45);
		contentPane.add(btnLogOut);
		
		search_textField = new JTextField();
		search_textField.setColumns(10);
		search_textField.setBounds(456, 127, 265, 34);
		contentPane.add(search_textField);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("SEARCH :");
		lblNewLabel_1_1_1.setFont(new Font("Trebuchet MS", Font.ITALIC, 18));
		lblNewLabel_1_1_1.setBounds(363, 127, 110, 34);
		contentPane.add(lblNewLabel_1_1_1);
	}
}
