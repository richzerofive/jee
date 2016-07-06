/**
 * 
 */
package bank2;

import javax.swing.JOptionPane;

import global.Constants;

/**
 * @date : 2016. 6. 20.
 * @author : 박승주
 * @file : AccountService.java
 * @story :
 */
public class AccountService2 {
	AccountBean account;
	// 1.개설 2.입금 3.조회 4.출금 5.통장내역 6.해지

	// 1.개설
	public void openAccount(String name, String id , String pw) {
		account = new AccountBean(name,id,pw);
	}

	// 2.입금
	public void deposit(int inputMoney) {
		int money = account.getMoney();
		money += inputMoney;
		account.setMoney(money);
	}

	// 3.조회
	public void findAccount() {

	}

	// 4.출금
	public String withdraw(int output){
		String result = "잔액부족";
		int money=account.getMoney();
		if (output <= money) {
			money -= output;
			account.setMoney(money);
			result = String.valueOf(account.getMoney());
		}
		return result;
	}
	// 5.통장내역

	public String showAccount(){
		String result = "";
		result = Constants.BANK_NAME+"계좌정보 [계좌번호=" + account.getAccountNo() + ", 이름=" + account.getName() + ", 잔액=" + account.getMoney()+ ", 비번=" + account.getPw() + ", 아이디=" + account.getId()+ "]";
		return result;
}
	// 6. 해지
	public void deleteAccount(){
		account = null;
	}
}
