package grade2;

public class GradeBean {
	private String id,seq,date,grade;
	private int java,sql,html,javascript;

	
	private static GradeBean instance = new GradeBean();
	public static GradeBean getInstance() {
		return instance;
	}
	GradeBean() {
		// TODO Auto-generated constructor stub
	}
	

	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public int getJava() {
		return java;
	}
	public String getSeq() {
		return seq;
	}
	public void setSeq(String seq) {
		this.seq = seq;
	}
	public void setJava(int java) {
		this.java = java;
	}
	public int getSql() {
		return sql;
	}
	public void setSql(int sql) {
		this.sql = sql;
	}
	public int getHtml() {
		return html;
	}
	public void setHtml(int html) {
		this.html = html;
	}
	public int getJavascript() {
		return javascript;
	}
	public void setJavascript(int javascript) {
		this.javascript = javascript;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String level) {
		this.grade=level;
	}	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return "No." + seq + ", 성적표 [이름:" + id + ", 학점:" + grade + "\n 자바:" + java + ", SQL:" + sql
				+ ", HTML5:" + html + ", 자바스크립트:" + javascript + "]";
	}

}
