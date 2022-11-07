package library;

import javax.swing.*;

public class Login {

	public static void main(String[] args) throws Exception {

		MySQLAccess dao = new MySQLAccess();
		dao.readDataBase();
		
		 JFrame f=new JFrame(); JButton b=new JButton("click");
		 b.setBounds(130,100,100, 40);//x axis, y axis, width, height
		 
		 f.add(b);//adding button in JFrame

		 f.setSize(400,500); f.setLayout(null);//using no layout managers
		 f.setVisible(true);//making the frame visible
		  }
}
