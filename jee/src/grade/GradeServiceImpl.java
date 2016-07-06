package grade;

import java.util.List;



public class GradeServiceImpl implements GradeService {
	GradeDAO dao = GradeDAO.getInstance();
	private static GradeServiceImpl instance = new GradeServiceImpl();
	public static GradeServiceImpl getInstance() {
		return instance;
	}
	private GradeServiceImpl() {}
	@Override
	public int insert(GradeBean grade) {
		return dao.insert(grade);
	}

	@Override
	public void update(GradeBean grade) {
		if (dao.update(grade)==1) {
			System.out.println("성공");
		} else {
			System.out.println("실패");
		}
	}

	@Override
	public String delete(String del) {
		String msg = "";
		if (dao.delete(del) == 1) {
			msg = "삭제완료";
		} else {
			msg = "실패";
		}
			
		return msg;
	}

	@Override
	public List<GradeBean> list() {
		List<GradeBean> list = dao.list();
		return list;
	}

	@Override
	public List<GradeBean> findById(String id) {
		
		return dao.findById(id);
	}

	@Override
	public GradeBean findBySeq(String seq) {
		return dao.findBySeq(seq);
	}

	@Override
	public int count(String examDate) {
		return dao.count(examDate);
	}
	@Override
	public void score(String[] a) {
		GradeBean g = new GradeBean();
		g.setId(a[0]);
		g.setExamDate(a[1]);
		g.setJava(Integer.parseInt(a[2]));
		g.setSql(Integer.parseInt(a[3]));
		g.setHtml(Integer.parseInt(a[4]));
		g.setJavascript(Integer.parseInt(a[5]));
		this.insert(g);
	}
	

}



