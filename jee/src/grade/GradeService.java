package grade;

import java.util.List;

public interface GradeService {
	// 총 7개의 기본 패턴이 존재하더라
	// exeU
	public int insert(GradeBean grade);
	public void update(GradeBean grade);
	public String delete(String del);
	// exeQ
	public List<GradeBean> list();
	public List<GradeBean> findById(String id);
	public GradeBean findBySeq(String seq);
	public int count(String examDate);
	// 점수입력받는 메소드
	public void score(String[] strArr);
}
