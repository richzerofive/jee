package grade2;

public class GradeBean {
	private int kor, eng, math,seq;
	private String name,hakjum;

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public void setKor() {
		this.kor = kor;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public void setMath(int math) {
		this.math = math;
	}
	public void setName(String name){
		this.name = name;
	}
	public int getKor() {
		return kor;
	}

	public int getEng() {
		return eng;
	}

	public int getMath() {
		return math;
	}
	public String getName(){
		return name;
	}

	@Override
	public String toString() {
		return "GradeBean [kor=" + kor + ", eng=" + eng + ", math=" + math + ", seq=" + seq + ", name=" + name + "]";
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
}
