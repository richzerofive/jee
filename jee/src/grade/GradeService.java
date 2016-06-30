package grade;

public interface GradeService {
	
	public abstract int total(int kor,int eng, int math);
	public abstract int avg(int total);
	public abstract String grade(int avg);
	public abstract String showResult(String grade);
	
}
