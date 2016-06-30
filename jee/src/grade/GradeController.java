/**
 * 
 */
package grade;

import javax.swing.JOptionPane;

/**
 * @date : 2016. 6. 8.
 * @author : 박승주
 * @file : avg.java
 * @story :
 */

public class GradeController {
	/*
	 * 클라이언트에서 프로그램 개발 요청이 왔습니다. 이름과 국,영,수 세과목점수를 입력받아서 [홍길동 : 총점 ***점, 평균 ***점,
	 * 학점 : F] 을 출력하는 프로그램을 만들어 주세요. 단) 평균은 소수점이하는 절삭합니다 평균점수가 90점 이상 A 80점 이상이면
	 * B 70점 이상이면 C 60점 이상이면 D 50점 이상이면 E 50점 미만이면 F 출력되게 해주세요 [단]switch-case
	 * 문으로 해결하세요.
	 */
	public static void main(String[] args) {
		// ---------------변수 선언부,준비,초기화(init)--------------
		String name = "", input=""; 
		int kor=0,eng=0,math=0;
		GradeService service = new GradeServiceImpl();
		// ===============연산부 (알고리즘)---------------------------
		input = JOptionPane.showInputDialog("이름,국어,영어,수학?");
		String[] inputArr =input.split(",");
		name =inputArr[0];
		kor = Integer.parseInt(inputArr[1]);
		eng = Integer.parseInt(inputArr[2]);
		math = Integer.parseInt(inputArr[3]);
		service.total(kor, eng, math);
		service.avg(service.total(kor, eng, math));
		service.grade(service.avg(service.total(kor, eng, math)));
		JOptionPane.showMessageDialog(null, "이름:"+name+"등급"+service.showResult(service.grade(service.avg(service.total(kor, eng, math)))));
		
	}
}
