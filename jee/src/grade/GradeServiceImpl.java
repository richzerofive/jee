package grade;

import java.util.List;



public class GradeServiceImpl implements GradeService {
	GradeDAO dao = GradeDAO.getInstance();
	
	private static GradeServiceImpl instance = new GradeServiceImpl(); 
	public static GradeServiceImpl getInstance() {
		return instance;
	}
	private GradeServiceImpl() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public int insert(GradeBean grade) {
		return dao.Create(grade);
		}
		
	@Override
	public String update(GradeBean grade) {
		String result = "";
		 if (dao.update(grade)==1) {
			result = "수정성공";
		} else {
			result = "수정실패";
		}
		 
		 return result;
	}

	@Override
	public String delete(String ID) {
		String result = "";
		 if (dao.delete(ID)==1) {
			result = "삭제성공";
		} else {
			result = "삭제실패";
		}
		 return result;
	}

	@Override
	public List<GradeBean> list() {
		List<GradeBean> list = dao.List();
		return list;
	}

	@Override
	public List<GradeBean> findById(String id) {
		
		return dao.findByHakjum(id);
	}

	@Override
	public GradeBean findBySeq(String seq) {
		return dao.findBySeq(seq);
	}

	@Override
	public int count(String date) {
		return dao.count(date);
	}
	@Override
	public String GradeCal(GradeBean bean) {
		// TODO Auto-generated method stub
		return null;
	}
	}



