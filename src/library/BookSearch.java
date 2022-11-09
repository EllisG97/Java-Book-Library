package library;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class BookSearch {

	
	 public static void searchPage() {
		 JFrame f=new JFrame(); 
		 JLabel lblSearch;
		 JButton btnExit=new JButton("Exit");
		 JButton btnSearch = new JButton("Search");
		 
		 JTextField txtSearch;
		 
		 lblSearch = new JLabel("Search: ");
		 lblSearch.setBounds(100, 80, 100, 30);
		 f.add(lblSearch);
		 
		 f.setSize(750,900); 
		 f.setLayout(null);//using no layout managers
		 f.setVisible(true);//making the frame visible
		 
		 txtSearch = new JTextField("");
		 txtSearch.setBounds(150, 80,400, 30);
	     f.add(txtSearch);
	     
	     btnExit.setBounds(300,200,100, 40);
	     f.add(btnExit);
	     
	     btnExit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent ae) {
					f.dispose();
					new Login();
					Login.loginUI();
				
				}
			});
	     

	     
	     JScrollPane scrollPane = new JScrollPane();
	 	 scrollPane.setBounds(50, 300, 600, 107);
	 	 f.add(scrollPane);
	 	 
	 	GetBooks obj = new GetBooks();
	 	 
	 	String[] column= {"ID","Name","Genre","Author","Publisher"};
	 	
	 	JTable jt1;
		jt1 = new javax.swing.JTable(obj.my_db_select(),column);
		scrollPane.setViewportView(jt1);
	 	
	    }
	 
	
}
