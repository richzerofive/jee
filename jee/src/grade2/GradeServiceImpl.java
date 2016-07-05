package grade2;

import java.util.List;



public class GradeServiceImpl implements GradeService {
	GradeDAO DAO = GradeDAO.getInstance();
	
	private static GradeServiceImpl instance = new GradeServiceImpl(); 
	public static GradeServiceImpl getInstance() {
		return instance;
	}
	private GradeServiceImpl() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String insert(GradeBean Bean) {
		GradeBean bb =GradeBean.getInstance();
		String	msg = "";
		int total = Bean.getJava()+Bean.getSql()+Bean.getHtml()+Bean.getJavascript();
		int avg = total/4;
		String level ="";
		switch (avg/10) {
		case 9:
			level = "A";
			break;
		case 8:
			level = "B";
			break;

		case 7:
			level = "C";
			break;

		case 6:
			level = "D";
			break;

		case 5:
			level = "E";
			break;

		default:
			level = "F";
			break;
		}
		int result = DAO.Create(Bean);
		if (result ==1) {
				msg = "회원가입 축하";
		} else {
				msg = "회원가입 실패";
		}
		return msg;
		
	}
	@Override
	public String update(GradeBean grade) {
		String result = "";
		 if (DAO.update(grade)==1) {
			result = "수정성공";
		} else {
			result = "수정실패";
		}
		 
		 return result;
	}

	@Override
	public String delete(String ID) {
		String result = "";
		 if (DAO.delete(ID)==1) {
			result = "삭제성공";
		} else {
			result = "삭제실패";
		}
		 return result;
	}

	@Override
	public List<GradeBean> list() {
		return DAO.List();
	}

	@Override
	public List<GradeBean> findByHakjum(String hakjum) {
		List<GradeBean> temp = DAO.findByHakjum(hakjum);
		return temp;
	}

	@Override
	public GradeBean findBySeq(int seq) {
		GradeBean temp2 = DAO.findById(seq);
		return temp2;
	}

	@Override
	public int count(String date) {
		GradeBean count2 =DAO.count(date);
		return 0;
	}
	}


