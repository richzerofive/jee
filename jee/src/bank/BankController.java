/**
 * 
 */
package bank;

import java.util.List;

import javax.swing.JOptionPane;

/**
 *@date   : 2016. 6. 15.
 *@author : 박승주
 *@file   : BankController.java
 *@story  : 
*/
public class BankController {
	public static void main(String[] args) {
		AccountService service = new AccountServiceImpl();
		BankService service2 = new BankServiceImpl();
		AccountBean bean = new AccountBean();
		String spec = "";
		String[] specArr = new String[3];
		while (true) {
			switch (JOptionPane.showInputDialog("=======개인인터넷뱅킹=======\n"+"1.개설 2.입금 3.조회 4.출금 5.통장내역\n"+"=========은행창구=========\n "+"11.개설 12.조회(전체) 13.개좌번호조회 14.이름조회 15.개좌수 16.수정 17.해지 0.종료")) {
					
			case "1":
				spec= JOptionPane.showInputDialog("이름,id,pw");
				specArr=spec.split(",");
				service.openAccount(specArr[0], specArr[1], specArr[2]);
				break;
			case "2":
				String inputMoney=JOptionPane.showInputDialog("입금액?");
			//	account.setMoney(Integer.parseInt(inputMoney));
				service.deposit(Integer.parseInt(inputMoney));
				break;
			case "3":
				break;
			case "4":
				String outputMoney=JOptionPane.showInputDialog("출금액?");
				 JOptionPane.showMessageDialog(null, service.withdraw(Integer.parseInt(outputMoney)));
				break;
			case "5":
				JOptionPane.showMessageDialog(null, service.showAccount());
				break;
			case "11":
				spec= JOptionPane.showInputDialog("이름,id,pw");
				specArr=spec.split(",");
				bean.setAccountNo();
				bean.setName(specArr[0]);
				bean.setId(specArr[1]);
				bean.setPw(specArr[2]);
				service2.openAccount(bean);
				break;
			case "12":
				JOptionPane.showMessageDialog(null, service2.findAccount());
				break;
			case "13":
				bean =service2.findByAccountNo(JOptionPane.showInputDialog("검색하려는 계좌번호"));
				JOptionPane.showMessageDialog(null,(bean.getAccountNo() == null) ?bean.getAccountNo()+"조회 계좌번호 없음":bean.toString());
				break;
			case "14":
				String findName=JOptionPane.showInputDialog("이름");
				List<AccountBean> list = service2.findByName(findName);
				JOptionPane.showMessageDialog(null, (list.isEmpty())?"검색하는 이름이 없습니다":list.toString());
				break;
			case "15":
				JOptionPane.showMessageDialog(null, service2.count());
				break;
			case "16":
				String change =JOptionPane.showInputDialog("수정하려는 계좌번호, 변경할비밀번호");
				String[] changeArr = change.split(",");
				bean.setAccountNo(changeArr[0]);
				bean.setPw(changeArr[1]);
				JOptionPane.showMessageDialog(null, service2.updateAccount(bean));
				
				break;
			case "17":
				service2.deleteAccount(JOptionPane.showInputDialog("계좌번호"));
				JOptionPane.showMessageDialog(null, service2.deleteAccount(bean.toString()));
				break;
				
			case "0":
				int ok =JOptionPane.showConfirmDialog(null, "종료?");
				if (ok==0) {
					return;
				}else{
				continue;}
				default:
				return;
			}
		}
	}
	
}
