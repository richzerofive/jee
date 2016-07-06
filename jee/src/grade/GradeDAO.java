package grade;

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
		List<GradeBean> list = new ArrayList<GradeBean>();
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

	public int Create(GradeBean g) {
		int result = 0;
		String sql="insert into grade(seq,grade,java,sql,html,javascript,id,exam_date)"
				+ "values(seq.nextval,?,?,?,?,?,?,?)";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, g.getGrade());
			pstmt.setInt(2, g.getJava());
			pstmt.setInt(3,g.getSql());
			pstmt.setInt(4, g.getHtml());
			pstmt.setInt(5, g.getJavascript());
			pstmt.setString(6, g.getId());
			pstmt.setString(7, g.getDate());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	
	public int update(GradeBean bean) {
		int revise = 0;
		String sql = "update grade set ";
		GradeService impl = GradeServiceImpl.getInstance();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, String.valueOf(bean.getScore()));
			pstmt.setString(2, bean.getSeq());
			pstmt.executeUpdate();
			bean = findBySeq(bean.getSeq());
		String sql2 = "update grade set grade = ? where seq = ?";
			pstmt = con.prepareStatement(sql2);
			pstmt.setString(1, impl.GradeCal(bean));
			pstmt.setString(2, bean.getSeq());
			revise = pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return revise;
	}

	public int delete(String Id) {
		String sql = "delete from member where id ='" + Id + "'";
		return exeUpdate(sql);
	}

	public List<GradeBean> findByHakjum(String id) {
		List<GradeBean> result = null;
		String sql = "select * from grade "
				+ "where id = ?";
			try {
				pstmt = con.prepareStatement(sql);
				rs = pstmt.executeQuery();
				if (rs.next()) {
					//seq,grade,java,sql,html,javascript,id,exam_date
					GradeBean m6 = GradeBean.getInstance();
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		return result;
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


	public int count(String date) {
		int result = 0;
		String sql ="select count(*) as count from grade"
				+ "where exam_date = ?";
		
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, date);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				result = rs.getInt("count");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}

	public GradeBean findBySeq(String seq) {
		GradeBean result = null;
		String sql ="select * from grade"
				+"where seq = ?";
		
			try {
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, Integer.parseInt(seq));
				rs = pstmt.executeQuery();
				if (rs.next()) {
					//seq,grade,java,sql,html,javascript,id,exam_date
					GradeBean m1 = GradeBean.getInstance();
					m1.setDate(rs.getString("EXAM_DATE"));
					m1.setSeq(rs.getString("SEQ"));
					m1.setGrade(rs.getString("GRADE"));
					m1.setJava(Integer.parseInt(rs.getString("Java")));
					m1.setSql(Integer.parseInt(rs.getString("SQL")));
					m1.setHtml(Integer.parseInt(rs.getString("HTML")));
					m1.setJavascript(Integer.parseInt(rs.getString("JAVASCRIPT")));
					m1.setId(rs.getString("ID"));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		return result;
	}	

}