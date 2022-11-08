package library;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class UserRegistration extends JFrame {
	
	  
	    
	    public static void registrationForm() {
	    	
	    	JFrame f=new JFrame(); 
	    	
		    JPanel contentPane;
		    JTextField email;
		    JTextField username;
		    JPasswordField passwordField;
		    JButton btnRegister, btnExit;
	    	
	        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			f.setSize(750,500); 
			f.setLayout(null);//using no layout managers
			f.setVisible(true);//making the frame visible
			
			JLabel lblNewUserRegister = new JLabel("New User Register");
			lblNewUserRegister.setFont(new Font("Times New Roman", Font.PLAIN, 32));
		    lblNewUserRegister.setBounds(250, 15, 300, 40);
		    f.add(lblNewUserRegister);
		    
	        JLabel lblName = new JLabel("Username: ");
	        lblName.setFont(new Font("Times New Roman", Font.PLAIN, 20));
	        lblName.setBounds(58, 50, 110, 43);
	        f.add(lblName);
	        
	        JLabel lblPassword = new JLabel("Password: ");
	        lblPassword.setFont(new Font("Times New Roman", Font.PLAIN, 20));
	        lblPassword.setBounds(58, 100, 110, 29);
	        f.add(lblPassword);
	        
	        JLabel lblEmailAddress = new JLabel("Email Address: ");
	        lblEmailAddress.setFont(new Font("Times New Roman", Font.PLAIN, 20));
	        lblEmailAddress.setBounds(58, 150, 200, 36);
	        f.add(lblEmailAddress);
	        
	        btnRegister = new JButton("Register");
	        
	        btnExit = new JButton("Exit");
	        
			btnExit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent ae) {
					f.dispose();
					new Login();
					Login.loginUI();
				}
			});
	        
	        btnExit.setFont(new Font("imes New Roman", Font.PLAIN, 22));
	        btnExit.setBounds(50, 300, 200, 60);
	        f.add(btnExit);

	        

	    }

	
}
