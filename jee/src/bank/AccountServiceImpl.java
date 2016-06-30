/**
 * 
 */
package bank;

/**
 * @date : 2016. 6. 20.
 * @author : 박승주
 * @file : AccountServiceImpl.java
 * @story :계좌 인터페이스
 */
public class AccountServiceImpl implements AccountService {
	// 1.개설 2.입금 3.조회 4.출금 5.통장내역 6.해지
	AccountBean account;

	@Override
	public void openAccount(String name, String id, String pw) {
		// 1.개설
		account = new AccountBean(name, id, pw);
	}

	@Override
	public void deposit(int inputMoney) {
		// 2.입금

		int money = account.getMoney();
		money += inputMoney;
		account.setMoney(money);
	}
	@Override
	public void findAccount() {
		// 3.조회
	}
	@Override
	public String withdraw(int output) {
		// 4출금
		String result = "잔액부족";
		int money = account.getMoney();
		if (output <= money) {
			money -= output;
			account.setMoney(money);
			result = String.valueOf(account.getMoney());
		}
		return null;
	}
	@Override
	public String showAccount() {
		// 5.통장내역
		return account.toString();
	}
	@Override
	public void deleteAccount() {
		// 6해지
		account = null;
	}

}
