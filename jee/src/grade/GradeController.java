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
	/**
	 * 클라이언트에서 프로그램 개발 요청이 왔습니다. 
	 * 이름과 국,영,수 세과목점수를 입력받아서() [홍길동 : 총점 ***점,
	 * 평균***점,학점 : F] 을 출력하는 프로그램을 만들어 주세요. 
	 * 단) 평균은 소수점이하는 절삭합니다 평균점수가 90점 이상 A
	 * 80점 이상이면 B 70점 이상이면 C 60점 이상이면 D 
	 * 50점 이상이면 E 50점 미만이면 F 학점입니다라고 출력되게 해주세요
	 * [단]switch-case 문으로 해결하세요
	 */
	public static void main(String[] args) {
		GradeService service = GradeServiceImpl.getInstance();
		
		while (true) {
			
			switch (JOptionPane.showInputDialog(""
					+ "1추가 2수정 3삭제 4전체조회 5학점을 포함한 시험내역 조회(SEQ) "
					+ "6시퀀스조회(ID) 7응시생수(시험일자별) 0종료"
					+ "")) {
			case "1":
				service.score(JOptionPane.showInputDialog("id,date,java,sql,html,js").split(","));
				break;
			case "2":
				GradeBean bean = new GradeBean();
				 String input=JOptionPane.showInputDialog("과목,점수,seq");
				 String[] inputArr = input.split(",");
				 bean.setSubject(inputArr[0]);
				 bean.setScore(Integer.parseInt(inputArr[1]));
				 bean.setSeq(inputArr[2]);
				 service.update(bean);
				 
				break;
			case "3":
				String del = JOptionPane.showInputDialog("시퀀스를 입력하시오.");
				service.delete(del);
				break;
			case "4":
				GradeUI ui = new GradeUI();
				break;
			case "5":
				String seq = JOptionPane.showInputDialog("조회하려는 SEQ");
				JOptionPane.showMessageDialog(null, service.findBySeq(seq));
				break;
			case "6":
				String sid = JOptionPane.showInputDialog("조회하려는 ID");
				JOptionPane.showMessageDialog(null, service.findById(sid));
				break;
			case "7":
			String examDate = JOptionPane.showInputDialog("조회하려는 시험일자(예:2016-05)");
				JOptionPane.showMessageDialog(null, service.count(examDate)+"명");
				break;
			case "0":return;
			default:
				break;
			}
		}
	}
}
