package conn;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connect {
	public static Connection conn;
	
	private static String classname="com.mysql.jdbc.Driver";
	private static String url="jdbc:mysql://localhost:3306/mydb";
	private static String user="root";
	private static String pwd="admin";
	
	public static Connection getConnection() throws Exception{
		Class.forName(classname);
		conn =DriverManager.getConnection(url,user,pwd);
		
		return conn;
	}
	

}
