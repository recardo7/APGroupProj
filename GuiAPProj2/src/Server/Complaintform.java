package Server;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Complaintform extends JFrame {

	private JPanel contentPane;
	private JTextField ID_field;
	private JTextField Fname_text;
	private JTextField lname_text;
	private JTextField mail_text;
	private JComboBox comp_type;
	JTextArea complaint;
	//private JRadioButton m_choice;
	//private JRadioButton f_choice;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Complaintform frame = new Complaintform();
					
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
	public Complaintform() {
		
		
		JRadioButton m_choice = new JRadioButton("male");
		JRadioButton f_choice = new JRadioButton("female");
		ButtonGroup bg = new ButtonGroup();

		bg.add(m_choice);
		bg.add(f_choice);

		m_choice.setSelected(true);
       
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 769, 794);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 10, 747, 745);
		panel.setBackground(new Color(145, 171, 204));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblComplaintForm = new JLabel("Complaint Form");
		lblComplaintForm.setFont(new Font("Trebuchet MS", Font.BOLD, 22));
		lblComplaintForm.setBounds(249, 10, 210, 63);
		panel.add(lblComplaintForm);
		
		JLabel lblNewLabel = new JLabel("ID:");
		lblNewLabel.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 18));
		lblNewLabel.setBounds(93, 118, 60, 30);
		panel.add(lblNewLabel);
		
		JLabel lblFirstname = new JLabel("Firstname:");
		lblFirstname.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 18));
		lblFirstname.setBounds(93, 181, 93, 30);
		panel.add(lblFirstname);
		
		JLabel lblLastname = new JLabel("Lastname:");
		lblLastname.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 18));
		lblLastname.setBounds(93, 234, 93, 30);
		panel.add(lblLastname);
		
		JLabel lblSex = new JLabel("Sex:");
		lblSex.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 18));
		lblSex.setBounds(93, 307, 93, 30);
		panel.add(lblSex);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 18));
		lblEmail.setBounds(93, 353, 93, 30);
		panel.add(lblEmail);
		
		JLabel lblTypeofcomplaint = new JLabel("Type of Complaint :");
		lblTypeofcomplaint.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 18));
		lblTypeofcomplaint.setBounds(81, 429, 155, 30);
		panel.add(lblTypeofcomplaint);
		
		JLabel lblComplaint = new JLabel("Complaint :");
		lblComplaint.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 18));
		lblComplaint.setBounds(93, 508, 155, 30);
		panel.add(lblComplaint);
		
		ID_field = new JTextField();
		ID_field.setBounds(192, 121, 210, 30);
		panel.add(ID_field);
		ID_field.setColumns(10);
		
		Fname_text = new JTextField();
		Fname_text.setColumns(10);
		Fname_text.setBounds(196, 184, 275, 30);
		panel.add(Fname_text);
		
		lname_text = new JTextField();
		lname_text.setColumns(10);
		lname_text.setBounds(192, 237, 279, 30);
		panel.add(lname_text);
		
		mail_text = new JTextField();
		mail_text.setColumns(10);
		mail_text.setBounds(186, 353, 285, 30);
		panel.add(mail_text);
		
		
		m_choice.setFont(new Font("Tahoma", Font.PLAIN, 14));
		m_choice.setBackground(new Color(145, 171, 204));
		m_choice.setBounds(192, 303, 86, 38);
		panel.add(m_choice);
		
		
		f_choice.setFont(new Font("Tahoma", Font.PLAIN, 14));
		f_choice.setBackground(new Color(145, 171, 204));
		f_choice.setBounds(318, 303, 74, 38);
		panel.add(f_choice);
		
		JComboBox<String> comp_type = new JComboBox<>(); 
		comp_type.setModel(new DefaultComboBoxModel(new String[] {"Delayed Transcript", "Missing /Incorrect Grades", "Unable to access portal", "Lost/Stolen ID", "Harassment"}));
		comp_type.setBounds(229, 429, 184, 37);
		panel.add(comp_type);
		
		
		
	     complaint = new JTextArea();
		complaint.setBounds(192, 508, 279, 135);
		panel.add(complaint);
		
		JButton btnNewButton = new JButton("SUBMIT");
		btnNewButton.addActionListener(new ActionListener() {
			
			public boolean verify() {
				
				  if(ID_field.getText().equals("")||Fname_text.getText().equals("")||lname_text.getText().equals("")/*||ID_field.getText().equals("")*/||mail_text.getText().equals("")||/*comp_type.getText().equals("")||*/complaint.getText().equals("")) {
				      JOptionPane.showMessageDialog(null,"Please complete all fields before submiting complaint");
					  return false;
			}  
				  else {
				return true;
			}
			}
			public void actionPerformed(ActionEvent e) {
				
				
				String id=ID_field.getText();
				String fname = Fname_text.getText();
				String lname = lname_text.getText();
				String Sex = "Male";
				if(f_choice.isSelected()) {
					Sex="Female";
				}
				String email = mail_text.getText();
				String type = comp_type.getSelectedItem().toString();
				String comp= complaint.getText();
				//String id = ID_field.getText();
				
				if(verify()) {
				student std=new student();
				std.insert('i', id, fname, lname, Sex, email, type, comp);
				
				
				}
			}
			
			
			
			
			
			
			
			
		});
		btnNewButton.setFont(new Font("Segoe UI Symbol", Font.BOLD, 14));
		btnNewButton.setBounds(452, 678, 102, 38);
		panel.add(btnNewButton);
		
		
	}
}
