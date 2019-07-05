package utilityclasses;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataConnection {
	Connection con;
	public Connection databaseConnection()
	{
		try {
			String url="jdbc:mysql://localhost:3306/studentdetails";
			String user="root";
			String pd="";
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection(url,user,pd);
			} catch (ClassNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();}
		catch(SQLException e)
		{ e.printStackTrace();}
		return con;
	}

}
