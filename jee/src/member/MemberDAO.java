package member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import global.Constants;

/*
private String id,pw,name,regDate,gender,ssn; 
private int age;*/
public class MemberDAO {
	Connection con = null;
	Statement stmt = null;
	PreparedStatement pstmt =null;
	ResultSet rs = null; //executeQuery() 에서만 리턴받는 객체
	private static MemberDAO instance = new MemberDAO();
	
	private MemberDAO() {
		// TODO Auto-generated constructor stub
	}
	
	public static MemberDAO getInstance() {
		return instance;
	}
	public int insert(MemberBean mem){
		String sql="insert into member(id,pw,name,reg_date,ssn)"
				+ "values('"+mem.getId()+"','"+mem.getPw()+"','"+mem.getName()+"','"+mem.getRegDate()+"','"+mem.getSsn()+"')";
		return exeUpdate(sql);
	}
	public int update(MemberBean bean){
		String sql ="update member set pw ='"+bean.getPw()+"'where id ='"+bean.getId()+"'";
		return exeUpdate(sql);
	}
	public int delete(String id){
		String sql = "delete from member where id ='" +id+"'";
		return exeUpdate(sql);
	}	
	
	public int exeUpdate(String sql) {
		int updateResult =0;
		try {
			Class.forName(Constants.ORACLE_DRIVER);
			con = DriverManager.getConnection(Constants.ORACLE_URL,Constants.USER_ID,Constants.USER_PW);
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
	public List<MemberBean> List(){
		String sql = "select * from member";
		List<MemberBean> list = new ArrayList<MemberBean>();
		MemberBean mem = null;
		try {
			Class.forName(Constants.ORACLE_DRIVER);
			con = DriverManager.getConnection(Constants.ORACLE_URL,Constants.USER_ID,Constants.USER_PW);
			stmt = con.createStatement();
			rs =stmt.executeQuery(sql);
			while(rs.next()){
				MemberBean mem2 = new MemberBean(
						rs.getString("ID"),
						rs.getString("NAME"),
						rs.getString("PW"),
						rs.getString("SSN"));
						
				mem2.setRegDate(rs.getString("REG_DATE"));
				list.add(mem2);
			}
					
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
		}
	public MemberBean findById(String pk){
		String sql = "select * from member where id '"+pk+"'";
		MemberBean temp = new MemberBean();
			try {
				Class.forName(Constants.ORACLE_DRIVER);
				con =DriverManager.getConnection(Constants.ORACLE_URL,Constants.USER_ID,Constants.USER_PW);
				stmt = con.createStatement();
				rs = stmt.executeQuery(sql);
				if (rs.next()) {
					temp.setId(rs.getString("ID"));
					temp.setName(rs.getNString("NAME"));
					temp.setPw(rs.getString("PW"));
					temp.setRegDate(rs.getString("REG_DATE"));
					temp.setSsn(rs.getString("SSN"));
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return temp;
		}
	public List<MemberBean> findByName(String name){
		String sql=  "select * from member where name = '"+name+"'";
		List<MemberBean> list2 = new ArrayList<MemberBean>();
		try {
			Class.forName(Constants.ORACLE_DRIVER);
			con = DriverManager.getConnection(Constants.ORACLE_URL,Constants.USER_ID,Constants.USER_PW);
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				MemberBean mem3 = new MemberBean(
						rs.getString("ID"),
						rs.getString("NAME"),
						rs.getString("PW"),
						rs.getString("SSN"));
						
				mem3.setRegDate(rs.getString("REG_DATE"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list2;
		}
	public int countQuery(){
		return 0;
		}
	public int count() {
		String sql = "select count(*) as count from member";
		int count = 0;
		try {
			Class.forName(Constants.ORACLE_DRIVER);
			con = DriverManager.getConnection(Constants.ORACLE_URL,Constants.USER_ID,Constants.USER_PW);
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			if (rs.next()) {
				count = rs.getInt("count");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
	}
