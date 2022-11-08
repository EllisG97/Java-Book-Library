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
	        lblName.setBounds(58, 75, 110, 43);
	        f.add(lblName);
	        
	        username = new JTextField();
	        username.setBounds(150, 80,200, 30);
	        f.add(username);
	        
	        JLabel lblPassword = new JLabel("Password: ");
	        lblPassword.setBounds(58, 125, 110, 29);
	        f.add(lblPassword);
	        
	        passwordField = new JPasswordField();
	        passwordField.setBounds(150, 130,200, 30);
	        f.add(passwordField);
	        
	        JLabel lblEmailAddress = new JLabel("Email Address: ");
	        lblEmailAddress.setBounds(58, 175, 200, 36);
	        f.add(lblEmailAddress);
	        
	        email = new JTextField();
	        email.setBounds(150, 180,200, 30);
	        f.add(email);
	        
	        btnRegister = new JButton("Register");
	        
	        btnRegister.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                String name = username.getText();
	                String emailId = email.getText();
	                String password = passwordField.getText();

	                String msg = "" + name;
	                msg += " \n";


	                try {
	                    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/library?characterEncoding=latin1&autoReconnect=true", "root", "password");

	                    String query = "INSERT INTO users VALUES('" + name + "','" + password + "','" + emailId + "')";

	                    Statement sta = connection.createStatement();
	                    int x = sta.executeUpdate(query);
	                    if (x == 0) {
	                        JOptionPane.showMessageDialog(btnRegister, "This user already exists");
	                    } else {
	                        JOptionPane.showMessageDialog(btnRegister,
	                            "Welcome, " + msg + " Your account has been successfully created");
	                    }
	                    connection.close();
	                } catch (Exception exception) {
	                    exception.printStackTrace();
	                }
	            }
	        });
	        
	        
	        btnRegister.setFont(new Font("Times New Roman", Font.PLAIN, 22));
	        btnRegister.setBounds(400, 300, 200, 60);
	        f.add(btnRegister);
	        
	        
	        btnExit = new JButton("Exit");
	        
			btnExit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent ae) {
					f.dispose();
					new Login();
					Login.loginUI();
				}
			});
	        
	        btnExit.setFont(new Font("Times New Roman", Font.PLAIN, 22));
	        btnExit.setBounds(50, 300, 200, 60);
	        f.add(btnExit);

	        

	    }

	
}
