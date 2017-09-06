package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {
	
	static final String URL="jdbc:oracle:thin:@localhost:1521:orcl";
	static final String DRIVER="oracle.jdbc.driver.OracleDriver";
	static final String USER="scott";
	static final String PASSWORD="1234";
    static Connection conn;
	public static Connection getConnection(){
		try
		{
			Class.forName(DRIVER);
			conn=DriverManager.getConnection(URL, USER, PASSWORD);
			
		}catch(Exception e){
			e.getMessage();
		}
		
		return conn;
		
	}

}
