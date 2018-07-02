import java.sql.*;

public class ConnectionDemo {

	public static void main(String[] args) {
		
		try
		{
			Class.forName("jdbc:ucanaccess://C:\\Users//adungarw\\Documents\\Test1.mdb");//sun.jdbc.odbc.JdbcOdbcDriver
			Connection con;
			Statement stmt;
			
			con = DriverManager.getConnection("jdbc:odbc:Test","","");
			stmt= con.createStatement();
			ResultSet rs= stmt.executeQuery("select * from dual");
			
			while(rs.next())
			{
				System.out.println("eeeee");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
