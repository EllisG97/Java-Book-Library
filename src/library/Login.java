package library;

import javax.swing.*;

public class Login {

	public static void main(String[] args) throws Exception {

		MySQLAccess dao = new MySQLAccess();
		dao.readDataBase();
		loginUI();

	}
	
	public static void loginUI() {
		
		 JFrame f=new JFrame(); 
		 JButton login=new JButton("Login");
		 JTextField username;
		 JPasswordField password;
		 JLabel nameLabel, passLabel, welcome;
		 
		 nameLabel = new JLabel("Username: ");
		 passLabel = new JLabel("Password: ");
		 welcome = new JLabel("Welcome to Castle Rock Library!");
		 
		 username = new JTextField(" ");
		 password = new JPasswordField("");
		 
		 JButton register = new JButton("Register");
		 
		 welcome.setBounds(250, 15, 300, 30);
		 login.setBounds(300,200,100, 40);//x axis, y axis, width, height
		 username.setBounds(270, 100, 200, 30);
		 nameLabel.setBounds(170, 100, 100, 30);
		 passLabel.setBounds(170, 150, 100, 30);
		 password.setBounds(270, 150, 200, 30);
		 register.setBounds(300, 300, 100, 40);
		 
		 f.add(login);//adding button in JFrame
		 f.add(register);
		 f.add(username);
		 f.add(password);
		 f.add(nameLabel);
		 f.add(passLabel);
		 f.add(welcome, SwingConstants.CENTER);

		 f.setSize(750,500); 
		 f.setLayout(null);//using no layout managers
		 f.setVisible(true);//making the frame visible
		
	}
}
