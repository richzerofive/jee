/**
 * 
 */
package member;

import javax.swing.JOptionPane;

/**
 *@date   : 2016. 6. 16.
 *@author : 박승주
 *@file   : schoolControler.java
 *@story  : 스테틱 변수 : 한빛 학원 인스턴스 Id , pw , name , regDate , gender ,800101-1(ssn)int age
 *1. 등록 :ssn,아이디,비번,이름 2. 조회 (결과값 : 홍길동,h,남)
*/
public class MemberControler {
	public static void main(String[] args) {
		MemberService impl = MemberServiceImpl.getInstance();
		while (true) {
			switch (JOptionPane.showInputDialog("1. 등록 2. 보기 3. 수정 4.삭제 0.종료")){
				
			case "1":
				MemberBean stu = new MemberBean();
				String input = JOptionPane.showInputDialog("ID,PW,이름,주민번호");
				String[] inputArr = input.split(",");
				stu.setId(inputArr[0]);
				stu.setPw(inputArr[1]);
				stu.setName(inputArr[2]);
				stu.setSsn(inputArr[3]);
				stu.setRegDate();
				String result = impl.regist(stu);
				JOptionPane.showMessageDialog(null, result);
				
				break;
				
			case "2":
				JOptionPane.showMessageDialog(null,impl.show());
				break;
			case "3":
				String rpw=JOptionPane.showInputDialog("변경할 비밀번호");
				impl.update(rpw);
				break;
			case "4":
				impl.delete();
				break;
			case "0" :
				int yes =JOptionPane.showConfirmDialog(null, "종료?");
				if (yes==0) {
					return;
				}else{
				continue;}
			default:
				break;
			}
		}
		
	}
}
