package bank;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AccountDAO {
	private static AccountDAO instance = new AccountDAO();
	public static AccountDAO getInstance() {
		return instance;
	}
	private AccountDAO() {
	}
	Connection con = null;
	Statement stmt = null;
	ResultSet rs = null;
	PreparedStatement pstmt = null;
	
	public String create(String[] create) {
		//"NAME,ID,PW"
		AccountBean bean = new AccountBean();
		String sql = "";
		String result =null;
		
		if (create[1]==bean.getId()) {
			System.out.println("이미 있는 아이디입니다.");
		} else {
			try {
				pstmt = con.prepareStatement(sql);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
		return result;
	}
}
