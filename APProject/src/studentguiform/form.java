package studentguiform;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;



import controller.Dbconn;

import java.sql.PreparedStatement;



public class form extends JFrame {

	private JPanel contentPane;
	private JTextField id;
	private JTextField fname;
	private JTextField lname;
	private JTextField email;
	private JTextField con;
	private JTextField details;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					form frame = new form();
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
	public form() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 754, 682);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel Fname = new JLabel("First name: ");
		Fname.setFont(new Font("Tahoma", Font.PLAIN, 18));
		Fname.setBounds(26, 222, 97, 50);
		contentPane.add(Fname);
		
		JLabel Lname = new JLabel("Last name: ");
		Lname.setFont(new Font("Tahoma", Font.PLAIN, 18));
		Lname.setBounds(350, 222, 125, 50);
		contentPane.add(Lname);
		
		JLabel S_ID = new JLabel("Student ID:");
		S_ID.setFont(new Font("Tahoma", Font.PLAIN, 18));
		S_ID.setBounds(26, 127, 125, 50);
		contentPane.add(S_ID);
		
		JLabel add = new JLabel("Email address");
		add.setFont(new Font("Tahoma", Font.PLAIN, 18));
		add.setBounds(26, 324, 125, 50);
		contentPane.add(add);
		
		JLabel lblDetails = new JLabel("Details ");
		lblDetails.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDetails.setBounds(36, 451, 104, 50);
		contentPane.add(lblDetails);
		
		JLabel lblContactNumber = new JLabel("Contact number");
		lblContactNumber.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblContactNumber.setBounds(358, 324, 151, 50);
		contentPane.add(lblContactNumber);
		
		JLabel add_2 = new JLabel("");
		add_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		add_2.setBounds(316, 492, 125, 50);
		contentPane.add(add_2);
		
		id = new JTextField();
		id.setBounds(133, 138, 156, 36);
		contentPane.add(id);
		id.setColumns(10);
		
		fname = new JTextField();
		fname.setColumns(10);
		fname.setBounds(133, 222, 184, 43);
		contentPane.add(fname);
		
		lname = new JTextField();
		lname.setColumns(10);
		lname.setBounds(452, 222, 194, 43);
		contentPane.add(lname);
		
		email = new JTextField();
		email.setColumns(10);
		email.setBounds(145, 324, 184, 43);
		contentPane.add(email);
		
		con = new JTextField();
		con.setColumns(10);
		con.setBounds(499, 324, 194, 50);
		contentPane.add(con);
		
		details = new JTextField();
		details.setColumns(10);
		details.setBounds(133, 451, 259, 77);
		contentPane.add(details);
		
		JLabel lblTypeOfIssue = new JLabel("Type of issue :");
		lblTypeOfIssue.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTypeOfIssue.setBounds(26, 384, 124, 50);
		contentPane.add(lblTypeOfIssue);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(164, 394, 125, 36);
		contentPane.add(comboBox);
		
		JButton ADD = new JButton("ADD");
		ADD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				
				
				
				
				
				
			}
		});
		ADD.setFont(new Font("Tahoma", Font.PLAIN, 18));
		ADD.setBounds(135, 574, 85, 50);
		contentPane.add(ADD);
	}
}
