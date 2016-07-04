package member;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

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
		
		int result = dao.insert(mem);
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
	public String update(MemberBean bean) {
		String result = "";
		 if (dao.update(bean)==1) {
			result = "수정성공";
		} else {
			result = "수정실패";
		}
		 
		 return result;
	}	

	@Override
	public String delete(String id) {
		String result = "";
		 if (dao.delete(id)==1) {
			result = "삭제성공";
		} else {
			result = "삭제실패";
		}
		 return result;
		 
	}

	@Override
	public int count() {
		return dao.count();
	}

	@Override
	public MemberBean findById(String findID) {
		MemberBean temp = dao.findById(findID);
		MemberBean t2 = new MemberBean(temp.getId(),temp.getPw(),temp.getName(),temp.getSsn());
		return t2;
	}

	@Override
	public List<MemberBean> list() {
		
		return dao.List();
	}

	@Override
	public List<MemberBean> findByName(String findNAME) {
		List<MemberBean> temp2 = dao.findByName(findNAME);
		
		
		return temp2;
	}
	
}

