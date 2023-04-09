package Server;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
 




public class viewcompform extends JFrame {

	private JPanel contentPane;
	//private JTable table;
	private JTextField search_textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					viewcompform frame = new viewcompform();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	student std =new student();
	//private JTable table;
	public viewcompform() {
		// Create a DefaultTableModel
		DefaultTableModel model = new DefaultTableModel();

		// Create a JTable with the DefaultTableModel
		JTable table = new JTable(model);

		// Set the model of the table
		table.setModel(model);
		
		
		
	std.fillStudenttable(table, "");
	
	

		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 903, 669);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		   
		search_textField = new JTextField();
		search_textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				table.setModel(new DefaultTableModel(null,new Object[] {"id", "first_name", "last_name", "sex", "email" , "type_of_complaint", "complaint"}));
				std.fillStudenttable(table, search_textField.getText());
			}
		});
		search_textField.setBounds(268, 558, 282, 36);
		contentPane.add(search_textField);
		search_textField.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(55, 56, 770, 471);
		contentPane.add(scrollPane);
		

		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("Type keyword here :");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel.setBounds(55, 558, 203, 36);
		contentPane.add(lblNewLabel);
	}
}
