package member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import global.Constants;

/*
private String id,pw,name,regDate,gender,ssn; 
private int age;*/
public class MemberDAO {
	Connection con = null;
	Statement stmt = null;
	ResultSet rs = null;
	private static MemberDAO instance = new MemberDAO();
	
	private MemberDAO() {
		// TODO Auto-generated constructor stub
	}
	
	public static MemberDAO getInstance() {
		return instance;
	}

	public int exeUpdate(String sql) {
		int updateResult =0;
		try {
			Class.forName(Constants.ORACLE_DRIVER);
			con = DriverManager.getConnection(Constants.ORACLE_URL,Constants.ORACLE_ID,Constants.ORACLE_PW);
			stmt = con.createStatement();
			updateResult = stmt.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if (updateResult==1) {
			System.out.println("성공");
		}else{
			System.out.println("실패");
		}
		return updateResult;
	}
	public void exeQuery(String sql){
		
	}
	}
