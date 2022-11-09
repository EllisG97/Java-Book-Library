package library;

import java.sql.*;

public class GetBooks {
	
	public  String[][] my_db_select() {
////////////
		String[][] data = new String[4][5]; // [rows][columns]
			
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
        	Connection con=DriverManager.getConnection(  
        	"jdbc:mysql://localhost:3306/library?characterEncoding=latin1&autoReconnect=true","root","password");
			Statement st=con.createStatement();  
			
			ResultSet rs=st.executeQuery("SELECT * FROM book LIMIT 0,4"); 
			//Looping to store result in returning array data // 
			int i=0;
			while(rs.next())  {
			 for(int j=0;j<5;j++) {
				 data[i][j]=rs.getString(j+1);
			 	}
			 i=i+1;
			}
		con.close();  
			}
		catch(Exception e)
		{ 
			e.printStackTrace();
		} 

		
		return data;
			}

}
