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
		GradeService service = GradeServiceImpl.getInstance();
		GradeBean bean = GradeBean.getInstance();
		while (true) {
			switch (JOptionPane.showInputDialog("1.추가 2.수정 3.삭제 4.전체조회 5.학점을 포함한 시험내역 조회(SEQ) 6.시퀀스조회(ID) 7.응시생수(시험일자별) 0.종료")) {
			case "1":
				String input = JOptionPane.showInputDialog("날짜,id,java,sql,html,javascript 입력");
				String[] inputArr = input.split(",");
				bean.setDate(inputArr[0]);
				bean.setId(inputArr[1]);
				bean.setJava(Integer.parseInt(inputArr[2]));
				bean.setSql(Integer.parseInt(inputArr[3]));
				bean.setHtml(Integer.parseInt(inputArr[4]));
				bean.setJavascript(Integer.parseInt(inputArr[5]));
				String result = service.insert(bean);
				JOptionPane.showMessageDialog(null, result);
				break;
			case "2":
				String update = JOptionPane.showInputDialog("ID,java,sql,html,javascript 입력");
					String[] updateArr = update.split(",");
					bean.setId(updateArr[0]);
					bean.setJava(Integer.parseInt(updateArr[1]));
					bean.setSql(Integer.parseInt(updateArr[2]));
					bean.setHtml(Integer.parseInt(updateArr[3]));
					bean.setJavascript(Integer.parseInt(updateArr[4]));
					JOptionPane.showMessageDialog(null, service.insert(bean));
				break;
			case "3":
				String delete=JOptionPane.showInputDialog("삭제할ID");
					service.delete(delete);
				break;
			case "4":
				JOptionPane.showMessageDialog(null, service.list());
				break;
			case "5":
				String hakjum=JOptionPane.showInputDialog("학점입력");
					service.findByHakjum(hakjum);
				break;
			case "6":
				int seq = Integer.parseInt(JOptionPane.showInputDialog("seq입력"));
				service.findBySeq(seq);
				break;
			case "7":
				String inputDate = JOptionPane.showInputDialog("날짜입력");
					service.count(inputDate);
				break;
			case "0":return;
			default:
				break;
			}
		}
	}
}
