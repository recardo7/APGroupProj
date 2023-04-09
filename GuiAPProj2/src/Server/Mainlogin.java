package Server;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Mainlogin extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mainlogin frame = new Mainlogin();
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
	public Mainlogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 584, 437);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Student Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				logform lf=new logform();
				
	              //cf.setSize(1000,1000);
	              lf.setBounds(100, 100, 769, 794);
	              lf.setVisible(true);
	              lf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	             // cf.pack();
	              lf.setLocationRelativeTo(null);
				
				
				
				
				
				
			}
		});
		btnNewButton.setFont(new Font("Tw Cen MT Condensed", Font.BOLD | Font.ITALIC, 29));
		btnNewButton.setBounds(135, 85, 273, 80);
		contentPane.add(btnNewButton);
		
		JButton btnSupervisorLogin = new JButton("Supervisor Login");
		btnSupervisorLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				Suplog sl=new Suplog();
				 sl.setBounds(100, 100, 500, 500);
	              sl.setVisible(true);
	              sl.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	             // cf.pack();
	              sl.setLocationRelativeTo(null);
				
				
				
				
				
				
			}
		});
		btnSupervisorLogin.setFont(new Font("Tw Cen MT Condensed", Font.BOLD | Font.ITALIC, 29));
		btnSupervisorLogin.setBounds(135, 175, 273, 80);
		contentPane.add(btnSupervisorLogin);
		
		JButton btnAdvisorLogin = new JButton("Advisor Login");
		btnAdvisorLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				advisorlog al=new advisorlog();
				 al.setBounds(100, 100, 500, 500);
	              al.setVisible(true);
	              al.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	             // cf.pack();
	              al.setLocationRelativeTo(null);
				
				
				
			}
		});
		btnAdvisorLogin.setFont(new Font("Tw Cen MT Condensed", Font.BOLD | Font.ITALIC, 29));
		btnAdvisorLogin.setBounds(135, 278, 273, 80);
		contentPane.add(btnAdvisorLogin);
	}

}
