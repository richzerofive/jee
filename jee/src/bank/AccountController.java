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
public class AccountController {
	public static void main(String[] args) {
		AccountService service = AccountServiceImpl.getInstance();
		// 1.개설 2.입금 3.출금4.수정5.해지6.조회(전체)7.조회(계좌번호)8.조회(이름)9.조회(전체통장수)
		switch (JOptionPane.showInputDialog("1.개설 2.입금 3.출금4.수정5.해지6.조회(전체)7.조회(계좌번호)8.조회(이름)9.조회(전체통장수)")) {
		case "1":
			String[] create= JOptionPane.showInputDialog("NAME,ID,PW").split(",");
				service.openAccount(create);
			break;
		case "2":break;
		case "3":break;
		case "4":break;
		case "5":break;
		case "6":break;
		case "7":break;
		case "8":break;
		case "9":break;
		default:
			break;
		}
	}
}
