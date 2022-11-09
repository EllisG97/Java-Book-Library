package library;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;

public class BookSearch {
	
	static JFrame f = new JFrame();

	public static void searchPage() {
		JLabel lblSearch;
		JButton btnExit = new JButton("Exit");
		JButton btnSearch = new JButton("Search");



		JTextField txtSearch;

		lblSearch = new JLabel("Search: ");
		lblSearch.setBounds(100, 80, 100, 30);
		f.add(lblSearch);

		f.setSize(750, 900);
		f.setLayout(null);// using no layout managers
		f.setVisible(true);// making the frame visible

		txtSearch = new JTextField("");
		txtSearch.setBounds(150, 80, 400, 30);
		f.add(txtSearch);

		btnExit.setBounds(300, 200, 100, 40);
		f.add(btnExit);

		btnSearch.setBounds(200, 200, 100, 40);
		f.add(btnSearch);

		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				f.dispose();
				new Login();
				Login.loginUI();

			}
		});

		/*
		 * JScrollPane scrollPane = new JScrollPane(); scrollPane.setBounds(50, 300,
		 * 600, 200); f.add(scrollPane);
		 */

		GetBooks obj = new GetBooks();

		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				String book = txtSearch.getText();
				showLibraryData(book);
			}
		});

	}
	
	public static void showLibraryData(String book) {
		
		
		DefaultTableModel model = new DefaultTableModel();
		String[] columnNames = { "Name", "Genre", "Author", "Publisher" };
		model.setColumnIdentifiers(columnNames);
		
		JTable table = new JTable();
		table.setModel(model);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table.setFillsViewportHeight(true);

		
		 JScrollPane scroll = new JScrollPane(table);
		 scroll.setHorizontalScrollBarPolicy(
		 JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		 scroll.setVerticalScrollBarPolicy( JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		 scroll.setBounds(50, 300, 600, 200);
		 


		String title = "";
		String author = "";
		String genre = "";
		String publisher = "";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/library?characterEncoding=latin1&autoReconnect=true", "root",
					"password");
			PreparedStatement pst = (PreparedStatement) con
					.prepareStatement("select * from book where title='" + book + "'");
			ResultSet rs = (ResultSet) pst.executeQuery();
			int i = 0;
			if (rs.next()) {
				title = rs.getString("title");
				genre = rs.getString("genre");
				author = rs.getString("author");
				publisher = rs.getString("publisher");
				model.addRow(new Object[] { title, genre, author, publisher });
				i++;
			}
			if (i < 1) {
				JOptionPane.showMessageDialog(null, "No Record Found", "Error", JOptionPane.ERROR_MESSAGE);
			}
			if (i == 1) {
				System.out.println(i + " Record Found");
			} else {
				System.out.println(i + " Records Found");
			}
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}

		f.add(scroll);
	}

}
