package grade2;

import java.util.List;

public interface GradeService {
	//총 7개의 기본 패턴이 존재하더라
	//exeU
	public String insert(GradeBean Bean);
	public String update(GradeBean Bean);
	public String delete(String ID);
	//exeQ
	public List<GradeBean> list();
	public List<GradeBean> findByHakjum(String hakjum);
	public GradeBean findBySeq(int seq);
	public int count(String date);
	
}
