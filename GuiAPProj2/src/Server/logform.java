package Server;





import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;
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



public class logform extends JFrame {

	private JPanel contentPane;
	private JTextField text_user;
	private JPasswordField text_pass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					logform frame = new logform();
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
	public logform()  {
	
	
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 661, 386);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel stu_log = new JLabel("Student Login");
		stu_log.setFont(new Font("Showcard Gothic", Font.BOLD, 20));
		stu_log.setBounds(225, 24, 203, 60);
		contentPane.add(stu_log);
		
		text_user = new JTextField();
		text_user.setBounds(223, 94, 205, 28);
		contentPane.add(text_user);
		text_user.setColumns(10);
		
		JLabel user = new JLabel("Username :");
		user.setFont(new Font("Segoe UI Symbol", Font.BOLD | Font.ITALIC, 17));
		user.setBounds(113, 94, 110, 28);
		contentPane.add(user);
		
		JLabel pass = new JLabel("Password :");
		pass.setFont(new Font("Segoe UI Symbol", Font.BOLD | Font.ITALIC, 17));
		pass.setBounds(113, 150, 110, 28);
		contentPane.add(pass);
		
		text_pass = new JPasswordField();
		text_pass.setBounds(225, 150, 203, 27);
		contentPane.add(text_pass);
		
		JLabel lbl_1 = new JLabel("*");
		lbl_1.setForeground(new Color(255, 0, 0));
		lbl_1.setBackground(new Color(0, 0, 0));
		lbl_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lbl_1.setBounds(427, 94, 45, 13);
		contentPane.add(lbl_1);
		
		
		JLabel lbl_2 = new JLabel("*");
		lbl_2.setForeground(Color.RED);
		lbl_2.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lbl_2.setBackground(Color.BLACK);
		lbl_2.setBounds(427, 150, 45, 13);
		contentPane.add(lbl_2);
		

		
		
		
		
		JButton stu_login = new JButton("Login");
		stu_login.setFont(new Font("Showcard Gothic", Font.ITALIC, 16));
		stu_login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			
				lbl_2.setVisible(false);
				lbl_1.setVisible(false);
				
				if(text_user.getText().equals("")){
					
					lbl_1.setVisible(true);
					
				} if(String.valueOf(text_pass.getPassword()).equals("")) {
					
					lbl_2.setVisible(true);
					
				}
				
				
				else {
					
					Connection con= connection.myconnect();
					PreparedStatement ps;
					
					
					try {
						
					
						if (con !=null ) {
					     ps= con.prepareStatement("SELECT * FROM user WHERE username = ? and password = ?");
					     ps.setString(1,text_user.getText());
					     ps.setString(2,String.valueOf(text_pass.getPassword()));
					     
					     ResultSet rs= ps.executeQuery();
					     
					     if(rs.next()) {
					    	 
					    	Testform tf=new Testform();
					    	tf.setVisible(true);
					    	tf.pack();
					    	tf.setLocationRelativeTo(null);
					        tf.setExtendedState(JFrame.MAXIMIZED_BOTH);
					         
					    	
					Testform.Label_user.setText("Welcome<"+text_user.getText()+">");
					        
					        
					        
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
		
		
		stu_login.setBounds(269, 219, 119, 43);
		contentPane.add(stu_login);
		
		JButton stu_can = new JButton("CANCEL");
		stu_can.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
		});
		stu_can.setFont(new Font("Showcard Gothic", Font.ITALIC, 16));
		stu_can.setBounds(269, 272, 119, 43);
		contentPane.add(stu_can);
		
		
	
		
		
		
	}
}
