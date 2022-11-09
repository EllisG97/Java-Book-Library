package library;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.*;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;

public class Login {

	public static void main(String[] args) throws Exception {

		MySQLAccess dao = new MySQLAccess();
		dao.readDataBase();
		loginUI();

	}
	
	public static void loginUI() {
		
		 JFrame f=new JFrame(); 
		 JButton btnLogin=new JButton("Login");
		 JTextField username;
		 JPasswordField password;
		 JLabel nameLabel, passLabel, welcome;
		 
		 f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 
		 nameLabel = new JLabel("Username: ");
		 passLabel = new JLabel("Password: ");
		 welcome = new JLabel("Welcome to Castle Rock Library!");
		 
		 username = new JTextField("");
		 password = new JPasswordField("");
		 password.setToolTipText("Enter your Password"); 
		 
		 JButton register = new JButton("Register");
		 
		 welcome.setFont(new Font("Times New Roman", Font.PLAIN, 32));
		 
		 welcome.setBounds(150, 15, 600, 35);
		 btnLogin.setBounds(300,200,100, 40);//x axis, y axis, width, height
		 username.setBounds(270, 100, 200, 30);
		 nameLabel.setBounds(170, 100, 100, 30);
		 passLabel.setBounds(170, 150, 100, 30);
		 password.setBounds(270, 150, 200, 30);
		 register.setBounds(300, 300, 100, 40);
		 
		 f.add(btnLogin);//adding button in JFrame
		 f.add(register);
		 f.add(username);
		 f.add(password);
		 f.add(nameLabel);
		 f.add(passLabel);
		 f.add(welcome, SwingConstants.CENTER);

		 f.setSize(750,500); 
		 f.setLayout(null);//using no layout managers
		 f.setVisible(true);//making the frame visible
		 
		f.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		f.getContentPane().add(register);
		
		  btnLogin.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                String userName = username.getText();
	                String pword = password.getText();
	                try {
	                    Connection connection = (Connection) DriverManager
	                       .getConnection("jdbc:mysql://localhost:3306/library?characterEncoding=latin1&autoReconnect=true", "root", "password");

	                    PreparedStatement st = (PreparedStatement) connection
	                      .prepareStatement("Select username, password from users where username=? and password=?");

	                    st.setString(1, userName);
	                    st.setString(2, pword);
	                    ResultSet rs = (ResultSet) st.executeQuery();
	                    if (rs.next()) {
	                        JOptionPane.showMessageDialog(btnLogin, "You have successfully logged in");
	                        f.dispose();
	                        new BookSearch();
	                        BookSearch.searchPage();
	                    } else {
	                        JOptionPane.showMessageDialog(btnLogin, "Wrong Username & Password");
	                    }
	                    } catch (SQLException sqlException) {
	                        sqlException.printStackTrace();
	                }
	            }
	        });

		 
		 
		register.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent ae) {
					f.dispose();
					new UserRegistration();
					UserRegistration.registrationForm();
				}
			});
		
	}
	
	
}


