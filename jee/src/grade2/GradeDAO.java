package grade2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import global.Constants;

public class GradeDAO {
	public static void main(String[] args) {
		Connection con = null;
		ResultSet rs = null;
		Statement stmt = null;
		int updateResult = 0;
		String sql = "";
		String sqlCreate ="create table grade("
				+"kor int grade,"
				+"eng int grade,"
				+"math int grade,"
				+"name varchar2(20))";
				
		String sqlDrop = "";
		
		try {
			Class.forName(Constants.ORACLE_DRIVER);
			con = DriverManager.getConnection(Constants.ORACLE_URL,Constants.ORACLE_ID,Constants.ORACLE_PW);
			stmt = con.createStatement();
			updateResult = stmt.executeUpdate(sqlCreate);
			
		} catch (Exception e) {
			e.printStackTrace();
		}System.out.println("DB출력값"+updateResult);
	}
}
