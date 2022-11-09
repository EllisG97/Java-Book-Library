package library;

import java.sql.*;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;

public class GetBooks {
	
	public  String[][] my_db_select(String book) {
////////////
		String[][] data = new String[10][5]; // [rows][columns]
			
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
        	Connection con=DriverManager.getConnection(  
        	"jdbc:mysql://localhost:3306/library?characterEncoding=latin1&autoReconnect=true","root","password");
        	
        	PreparedStatement st = (PreparedStatement)con.prepareStatement("SELECT * FROM book WHERE title=? "); 

			st.setString(1, book);
			ResultSet rs = (ResultSet) st.executeQuery();
            if (rs.next()) {
			//Looping to store result in returning array data // 
			int i=0;
			while(rs.next())  {
			 for(int j=0;j<5;j++) {
				 data[i][j]=rs.getString(j);
			 	}
			 i=i+1;
			}
		con.close();  
			}
		}
		catch(Exception e)
		{ 
			e.printStackTrace();
		} 

		System.out.println(data);
		return data;
	}

}
