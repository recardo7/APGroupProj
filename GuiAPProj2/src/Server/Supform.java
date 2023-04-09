package Server;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.RowFilter;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class Supform extends JFrame {

	private JPanel contentPane;
	//private JTable table;
	private JTextField doublesearchtext;
	
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Supform frame = new Supform();
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

	
	
	
	public Supform() {
		
		
		// Create a DefaultTableModel
				DefaultTableModel model = new DefaultTableModel();

				// Create a JTable with the DefaultTableModel
				JTable table = new JTable(model);

				// Set the model of the table
				table.setModel(model);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1086, 807);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(222, 135, 793, 584);
		contentPane.add(scrollPane);
		
		
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("STUDENT SUPEVISOR DASHBOARD");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 19));
		lblNewLabel.setBounds(169, 22, 362, 37);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("VIEW COMPLAINTS");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					
			std.fillStudenttable(table, "");
				
				
			}
		});
		btnNewButton.setBounds(29, 229, 167, 67);
		contentPane.add(btnNewButton);
		
		JLabel lblTypeKeyword = new JLabel("Type keyword:");
		lblTypeKeyword.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblTypeKeyword.setBounds(190, 88, 132, 37);
		contentPane.add(lblTypeKeyword);
		
		doublesearchtext = new JTextField();
		doublesearchtext.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				
				table.setModel(new DefaultTableModel(null,new Object[] {"id", "first_name", "last_name", "sex", "email" , "type_of_complaint", "complaint"}));
				std.fillStudenttable(table, doublesearchtext.getText());
				
				
			}
		});
		doublesearchtext.setBounds(329, 95, 262, 30);
		contentPane.add(doublesearchtext);
		doublesearchtext.setColumns(10);
		
		JButton btnAssign = new JButton("ASSIGN");
		btnAssign.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				AssignForm af=new AssignForm();
				 af.setBounds(100, 100, 902, 694);
	              af.setVisible(true);
	              af.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	             // cf.pack();
	              af.setLocationRelativeTo(null);
				
				
			}
		});
		btnAssign.setBounds(39, 422, 140, 67);
		contentPane.add(btnAssign);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				String selectedCategory = (String) comboBox.getSelectedItem();
	            TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);

	            if (!selectedCategory.equals("All")) {
	                sorter.setRowFilter(RowFilter.regexFilter(selectedCategory, 5));
	            }

	            table.setRowSorter(sorter);
				
				
			}
		});
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"All","Delayed Transcript", "Missing /Incorrect Grades", "Unable to access portal", "Lost/Stolen ID", "Harassment", "None"}));
		comboBox.setBounds(817, 95, 208, 30);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel_1 = new JLabel("Filter by category");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel_1.setBounds(656, 88, 132, 37);
		contentPane.add(lblNewLabel_1);
	}
	
	
}
