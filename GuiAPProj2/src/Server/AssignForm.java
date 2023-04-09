package Server;

import java.awt.EventQueue;
import java.awt.Point;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AssignForm extends JFrame {

	private JPanel contentPane;
	//private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AssignForm frame = new AssignForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	
 student std= new student();



	/**
	 * Create the frame.
	 */
	public AssignForm() {
		
		
		
		

		// Create a DefaultTableModel
				DefaultTableModel model = new DefaultTableModel();
				
				
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 902, 694);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
	
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"1000White", "1001Caldroun", "1002Diesal", "1003Man"}));
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				
				
			}
		});
		comboBox.setBounds(334, 41, 135, 37);
		contentPane.add(comboBox);
		
		
		
		JTable table = new JTable(model);
		table.setModel(model);
		std.filltable(table, "");
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
				int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    // Get the values from the selected row
                    String complaintId = table.getValueAt(selectedRow, 1).toString();
                    String staffId = comboBox.getSelectedItem().toString();

                    // Update the database with the new staff ID
                    Connection con = connection.myconnect();
                    PreparedStatement ps = null;
                    try {
                        ps = con.prepareStatement("UPDATE students SET Staff_id=? WHERE complaint_id=?");
                        ps.setString(1, staffId);
                        ps.setString(2, complaintId);
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
		scrollPane.setBounds(74, 105, 712, 433);
		contentPane.add(scrollPane);
		scrollPane.setViewportView(table);
		
		
		
		
		JButton btnNewButton = new JButton("Assign");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			
				int selectedRow = table.getSelectedRow();

		        // check if a row is selected
		        if (selectedRow == -1) {
		            JOptionPane.showMessageDialog(contentPane, "Please select a row to assign");
		            return;
		        }

		        // get the selected staff ID from the combo box
		        String staffId = (String) comboBox.getSelectedItem();

		        // update the staff ID in the selected row in the database
		        String complaintId = (String) table.getValueAt(selectedRow, 1); // get the complaint ID from the selected row
		        try {
		            Connection con = connection.myconnect();
		            PreparedStatement ps = con.prepareStatement("UPDATE students SET Staff_id = ? WHERE complaint_id = ?");
		            ps.setString(1, staffId);
		            ps.setString(2, complaintId);
		            int rowsUpdated = ps.executeUpdate();

		            // check if the row was successfully updated
		            if (rowsUpdated == 1) {
		                JOptionPane.showMessageDialog(contentPane, "Assigned successfully");
		                std.filltable(table, ""); // refresh the table
		            } else {
		                JOptionPane.showMessageDialog(contentPane, "Failed to assign");
		            }

		        } catch (SQLException ex) {
		            ex.printStackTrace();
		        }
				
				
				
				
				
				
				
			}
			
		});
		btnNewButton.setBounds(321, 599, 165, 48);
		contentPane.add(btnNewButton);
	}
}
