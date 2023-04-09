package Server;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Panel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;



public class Testform extends JFrame {
  
	private JPanel contentPane;
	public static JLabel Label_user;
	private static JLabel Label_user_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Testform frame = new Testform();
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
	public Testform() {
		
	
		Label_user=new JLabel();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 693, 537);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("File ");
		menuBar.add(mnNewMenu);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Panel panel = new Panel();
		panel.setBackground(new Color(192, 192, 192));
		panel.setBounds(10, 10, 659, 458);
		contentPane.add(panel);
	    panel.setLayout(null);
		
	    Label_user_1 = new JLabel("Welcome <#####>");
	    Label_user_1.setForeground(new Color(255, 255, 255));
	    Label_user_1.setBounds(10, 64, 157, 58);
		Label_user_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.add(Label_user_1);
		
		JButton Addbutton = new JButton("Add Student");
		Addbutton.setBounds(10, 172, 186, 65);
		Addbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Complaintform cf=new Complaintform();
				
				              //cf.setSize(1000,1000);
				              cf.setBounds(100, 100, 769, 794);
				              cf.setVisible(true);
				              cf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				             // cf.pack();
				              cf.setLocationRelativeTo(null);
				
			}
		});
		Addbutton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		panel.add(Addbutton);
		
		JButton Veiwbutton = new JButton("Veiw Complaints");
		Veiwbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				viewcompform vf=new viewcompform();
				
	              //cf.setSize(1000,1000);
				  vf.setBounds(100, 100, 769, 794);
				  vf.setVisible(true);
				  vf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	             // cf.pack();
				  vf.setLocationRelativeTo(null);
	
				
				
				
				
			}
		});
		Veiwbutton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 17));
		Veiwbutton.setBounds(10, 277, 186, 87);
		panel.add(Veiwbutton);
		
		JLabel lblNewLabel = new JLabel("STUDENT  DASHBOARD");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		lblNewLabel.setBounds(138, 10, 393, 58);
		panel.add(lblNewLabel);
		
		
		
	}
}
