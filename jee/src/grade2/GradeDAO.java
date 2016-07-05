package grade2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import global.Constants;
import global.DatabaseFactory;
import global.Vendor;
import member.MemberBean;

public class GradeDAO {
	private static GradeDAO instance = new GradeDAO();

	private GradeDAO() {
		con = DatabaseFactory.createDatabase(Vendor.ORACLE, Constants.USER_ID, Constants.USER_PW).getConnection();
	}

	public static GradeDAO getInstance() {
		return instance;
	}

	Connection con;
	ResultSet rs;
	Statement stmt;
	PreparedStatement pstmt;
	int updateResult = 0;
	String sql = "";
	String sqlCreate = "create table grade(" + "kor int grade," + "eng int grade," + "math int grade,"
			+ "name varchar2(20))";

	String sqlDrop = "";

	public List<GradeBean> List() {
		String sql = "select * from member";
		List<GradeBean> list = new ArrayList<GradeBean>();
		GradeBean mem = null;
		try {
			Class.forName(Constants.ORACLE_DRIVER);
			con = DriverManager.getConnection(Constants.ORACLE_URL, Constants.USER_ID, Constants.USER_PW);
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				GradeBean mem2 = new GradeBean();
				rs.getString("JAVA");
				rs.getString("SQL");
				rs.getString("HTML");
				rs.getString("JAVASCRIPT");
				rs.getString("ID");
				rs.getString("DATE");
				rs.getString("Grade");
				list.add(mem2);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	public int exeUpdate(String sql) {
		int updateResult = 0;
		try {
			Class.forName(Constants.ORACLE_DRIVER);
			con = DriverManager.getConnection(Constants.ORACLE_URL, Constants.USER_ID, Constants.USER_PW);
			stmt = con.createStatement();
			updateResult = stmt.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (updateResult == 1) {
			System.out.println("성공");
		} else {
			System.out.println("실패");
		}
		return updateResult;
	}

	public int Create(GradeBean bean) {
		int result = 0;
		String sql = "insert into grade(seq,grade,java,sql,html,javascript,id,exam_date)"
				+ "values(seq.nextval,?,?,?,?,?,?,?)";
		try {
			Class.forName(Constants.ORACLE_DRIVER);
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, bean.getGrade());
			pstmt.setInt(2, bean.getJava());
			pstmt.setInt(3, bean.getSql());
			pstmt.setInt(4, bean.getHtml());
			pstmt.setInt(5, bean.getJavascript());
			pstmt.setString(6, bean.getId());
			pstmt.setString(7, bean.getDate());
			result = pstmt.executeUpdate();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public int update(GradeBean bean) {
		String sql = "update grade set exam_date ='" + bean.getJava() + "','" + bean.getSeq() + "','" + bean.getHtml()
				+ "','" + bean.getJavascript() + "'where id ='" + bean.getId() + "'";
		return exeUpdate(sql);
	}

	public int delete(String Id) {
		String sql = "delete from member where id ='" + Id + "'";
		return exeUpdate(sql);
	}

	public List<GradeBean> findByHakjum(String hakjum) {
		String sql = "select * from Grade where hakjum = '" + hakjum + "'";
		List<GradeBean> list3 = new ArrayList<GradeBean>();
		try {
			Class.forName(Constants.ORACLE_DRIVER);
			con = DriverManager.getConnection(Constants.ORACLE_URL, Constants.USER_ID, Constants.USER_PW);
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				GradeBean mem3 = new GradeBean();
				rs.getString("JAVA");
				rs.getString("SQL");
				rs.getString("HTML");
				rs.getString("JAVASCRIPT");
				rs.getString("ID");
				rs.getString("DATE");
				rs.getString("Grade");
				list3.add(mem3);

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list3;

	}

	public GradeBean findById(int seq) {
		String sql = "select * from member where seq '" + seq + "'";
		GradeBean temp5 = new GradeBean();
		try {
			Class.forName(Constants.ORACLE_DRIVER);
			con = DriverManager.getConnection(Constants.ORACLE_URL, Constants.USER_ID, Constants.USER_PW);
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			if (rs.next()) {
				Integer.parseInt(rs.getString("JAVA"));
				Integer.parseInt(rs.getString("SQL"));
				Integer.parseInt(rs.getString("html"));
				Integer.parseInt(rs.getString("javascript"));
				rs.getString("ID");
				rs.getString("date");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return temp5;
	}

	public GradeBean count(String date) {

		return null;
	}

}