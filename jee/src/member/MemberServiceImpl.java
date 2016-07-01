package member;

import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.swing.JOptionPane;

import global.Constants;

/**
 *@date   : 2016. 6. 20.
 *@author : 박승주
 *@file   : StudentServiceImpl.java
 *@story  : 
*/
public class MemberServiceImpl implements MemberService{
	private static MemberServiceImpl instance = new MemberServiceImpl();
	
	MemberBean Student;
	private MemberServiceImpl() {
	}
	
	public static MemberServiceImpl getInstance() {
		return instance;
	}

	MemberDAO dao = MemberDAO.getInstance();
	
	
	@Override
	public String regist(MemberBean mem) {
		String	msg = "";
		String sql="insert into member(id,pw,name,reg_date,ssn)"
				+ "values('"+mem.getId()+"','"+mem.getPw()+"','"+mem.getName()+"','"+mem.getRegDate()+"','"+mem.getSsn()+"')";
		int result = dao.exeUpdate(sql);
		if (result ==1) {
				msg = "회원가입 축하";
		} else {
				msg = "회원가입 실패";
		}
		return msg;
	}
	@Override
	public String show() {
		return Student.toString();
	}

	@Override
	public void update(String pw) {
		Student.setPw(pw);
	}

	@Override
	public void delete() {
		Student = null;
	}
	
}

