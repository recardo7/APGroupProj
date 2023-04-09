package Server;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.event.ActionEvent;

public class Suplog extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Suplog frame = new Suplog();
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
	public Suplog() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 719, 537);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel contentPane_1 = new JPanel();
		contentPane_1.setLayout(null);
		contentPane_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane_1.setBackground(Color.LIGHT_GRAY);
		contentPane_1.setBounds(0, 10, 705, 492);
		contentPane.add(contentPane_1);
		
		JLabel stu_log = new JLabel("Supervisor login");
		stu_log.setFont(new Font("Showcard Gothic", Font.BOLD, 20));
		stu_log.setBounds(225, 24, 222, 60);
		contentPane_1.add(stu_log);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(223, 94, 205, 28);
		contentPane_1.add(textField);
		
		JLabel user = new JLabel("Username :");
		user.setFont(new Font("Segoe UI Symbol", Font.BOLD | Font.ITALIC, 17));
		user.setBounds(113, 94, 110, 28);
		contentPane_1.add(user);
		
		JLabel pass = new JLabel("Password :");
		pass.setFont(new Font("Segoe UI Symbol", Font.BOLD | Font.ITALIC, 17));
		pass.setBounds(113, 150, 110, 28);
		contentPane_1.add(pass);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(225, 150, 203, 27);
		contentPane_1.add(passwordField);
		
		JLabel lbl_1 = new JLabel("*");
		lbl_1.setForeground(Color.RED);
		lbl_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lbl_1.setBackground(Color.BLACK);
		lbl_1.setBounds(427, 94, 45, 13);
		contentPane_1.add(lbl_1);
		
		JLabel lbl_2 = new JLabel("*");
		lbl_2.setForeground(Color.RED);
		lbl_2.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lbl_2.setBackground(Color.BLACK);
		lbl_2.setBounds(427, 150, 45, 13);
		contentPane_1.add(lbl_2);
		
		JButton stu_login = new JButton("Login");
		stu_login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				
				
				lbl_2.setVisible(false);
				lbl_1.setVisible(false);
				
				if(textField.getText().equals("")){
					
					lbl_1.setVisible(true);
					
				} if(String.valueOf(passwordField.getPassword()).equals("")) {
					
					lbl_2.setVisible(true);
					
				}
				
				
				else {
					
					Connection con= connection.myconnect();
					PreparedStatement ps;
					
					
					try {
						
					
						if (con !=null ) {
					     ps= con.prepareStatement("SELECT * FROM supervisor WHERE id = ? and password = ?");
					     ps.setString(1,textField.getText());
					     ps.setString(2,String.valueOf(passwordField.getPassword()));
					     
					     ResultSet rs= ps.executeQuery();
					     
					     if(rs.next()) {
					    	 
					    	Supform sf=new Supform();
					    	sf.setVisible(true);
					    	sf.setBounds(100, 100, 1086, 807);
					
					    	sf.setLocationRelativeTo(null);
					      
					         
					    	
					Testform.Label_user.setText("Welcome<"+textField.getText()+">");
					        
					        
					        
					     }  else{
					    	 
					    	 System.out.println("NO");
					     }
					     
						}
					     
					     
					}catch(SQLException ex) {
						Logger.getLogger(logform.class.getName()).log(Level.SEVERE,null,ex);
					}
				}
				
			}
			
			
			
			
				
				
				
				
			
		});
		stu_login.setFont(new Font("Showcard Gothic", Font.ITALIC, 16));
		stu_login.setBounds(269, 219, 119, 43);
		contentPane_1.add(stu_login);
		
		JButton stu_can = new JButton("CANCEL");
		stu_can.setFont(new Font("Showcard Gothic", Font.ITALIC, 16));
		stu_can.setBounds(269, 272, 119, 43);
		contentPane_1.add(stu_can);
	}
}
