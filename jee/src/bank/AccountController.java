/**
 * 
 */
package bank;

import java.util.List;

import javax.swing.JOptionPane;

/**
 * @date : 2016. 6. 15.
 * @author : 박승주
 * @file : BankController.java
 * @story :
 */
public class AccountController {
	public static void main(String[] args) {
		AccountService service = AccountServiceImpl.getInstance();
		AccountBean bean = AccountBean.getInstance();
		// 1.개설 2.입금 3.출금4.수정5.해지6.조회(전체)7.조회(계좌번호)8.조회(이름)9.조회(전체통장수)
		switch (JOptionPane.showInputDialog("1.개설 2.입금 3.출금4.수정5.해지6.조회(전체)7.조회(계좌번호)8.조회(이름)9.조회(전체통장수)")) {
		case "1":
			String input = JOptionPane.showInputDialog("NAME,ID,PW");
			String[] inputArr = input.split(",");
			bean.setName(inputArr[0]);
			bean.setId(inputArr[1]);
			bean.setPw(inputArr[2]);
			service.openAccount(bean);
			break;
		case "2":
			int inputM=Integer.parseInt(JOptionPane.showInputDialog("금액"));
			bean.setMoney(inputM);
			service.deposit(inputM);
			
			break;
		case "3":
			break;
		case "4":
			break;
		case "5":
			break;
		case "6":
			break;
		case "7":
			break;
		case "8":
			break;
		case "9":
			break;
		default:
			break;
		}
	}
}
