/**
 * 
 */
package bank;

import java.util.List;

/**
 * @date : 2016. 6. 20.
 * @author : 박승주
 * @file : AccountServiceImpl.java
 * @story :계좌 인터페이스
 */
public class AccountServiceImpl implements AccountService {
	private static AccountServiceImpl instance = new AccountServiceImpl();
	AccountDAO dao = AccountDAO.getInstance();
	private AccountServiceImpl() {
	}
	public static AccountServiceImpl getInstance() {
		return instance;
	}
	@Override
	public String openAccount(String[] create) {
			return dao.create(create);
	}

	@Override
	public void deposit(int inputMoney) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String withdraw(int output) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateAccount(AccountBean bean) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteAccount(String findAcc) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AccountBean> findAccount() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AccountBean findByAccountNo(String accNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AccountBean> findByName(String findName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return 0;
	}
}
