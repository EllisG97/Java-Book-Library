package library;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class MySQLAccess {
    private Connection connect = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

    public void readDataBase() throws Exception {
        try
        {
        	Class.forName("com.mysql.jdbc.Driver");  
        	Connection con=DriverManager.getConnection(  
        	"jdbc:mysql://localhost:3306/library?characterEncoding=latin1&autoReconnect=true","root","password");  
        	Statement stmt=con.createStatement();  
        	ResultSet rs=stmt.executeQuery("SELECT * FROM admin");  
        	while(rs.next())  
        		System.out.println(rs.getString(1)+"  "+rs.getString(2));  
        		con.close();  
        }


        catch ( Exception e)
        {
            e.printStackTrace();
        }
        }
}

