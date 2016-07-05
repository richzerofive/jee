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
			switch (JOptionPane.showInputDialog(""+"--- 회원이 보는 화면\n"+"1.회원가입 2.로그인 3. 내정보보기(detail) 4.내정보수정(비번) 5.탈퇴 0.종료\n"+"---관리자 화면 ---\n"+"11.회원목록 12.검색(ID) 13.검색(이름) 14.검색(성별) 15.회원수")){
				
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
				break;
			case "4":
				MemberBean bean = new MemberBean();
				String rpw=JOptionPane.showInputDialog("ID,변경할 비밀번호");
				String[] inputRpw = rpw.split(",");
				bean.setId(inputRpw[0]);
				bean.setPw(inputRpw[1]);
				JOptionPane.showMessageDialog(null,impl.update(bean));
				break;
			case "5":
				String result2 =impl.delete(JOptionPane.showInputDialog("삭제할ID"));
				JOptionPane.showMessageDialog(null,result2);
				break;
			case "11":
				JOptionPane.showMessageDialog(null, impl.list());
				break;
			case "12":
				String findID=JOptionPane.showInputDialog("아이디입력");
				JOptionPane.showMessageDialog(null, impl.findById(findID));
				break;
			case "13" :
				String findNAME = JOptionPane.showInputDialog("이름입력");
				JOptionPane.showMessageDialog(null, impl.findByName(findNAME));
			case "14":
				
				break;
			
			case "15":
				int count =impl.count();
				JOptionPane.showMessageDialog(null, count);
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
