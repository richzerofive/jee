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

	public int create(AccountBean bean) {
		// "NAME,ID,PW"
		String sql = "insert into account(account_no,money,id)" + "values(?,?,?)";
		int result = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "account_no");
			pstmt.setInt(2, Integer.parseInt("money"));
			pstmt.setString(3, "id");
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}
		public int deposit(int money){
		int result = 0;
		String sql = "";
		try {
			pstmt = con.prepareStatement(sql);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
			return result;
}
}