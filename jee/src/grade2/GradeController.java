/**
 * 
 */
package grade2;

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
		while (true) {
			switch (JOptionPane.showInputDialog("1.추가 2.수정 3.삭제 4.전체조회 5.학점조회 6.시퀀스조회 7.응시생수")) {
			case "1":
				
				break;
			case "2":break;
			case "3":break;
			case "4":break;
			case "5":break;
			case "6":break;
			case "7":break;
			default:
				break;
			}
		}
	}
}
