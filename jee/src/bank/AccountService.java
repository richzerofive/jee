/**
 * 
 */
package bank;

import java.util.List;

import global.Constants;

/**
 *@date   : 2016. 6. 20.
 *@author : 박승주
 *@file   : AccountService.java
 *@story  : 
*/
public interface AccountService {
	
	
	// 1.개설 2.입금 3.출금4.수정5.해지6.조회(전체)7.조회(계좌번호)8.조회(이름)9.조회(전체통장수)
	//accountBean <-> view
	// 1.개설
	public String openAccount(String[] create); 
	// 2.입금
	public void deposit(int inputMoney); 
	// 3.출금
	public String withdraw(int output);
	//4. 수정..사용자의 요청에 의해 비번만 전환가능
	public String updateAccount(AccountBean bean);
	//5. 해지
	public String deleteAccount(String findAcc);
	//6. 조회(전체)
	public List<AccountBean> findAccount();
	//7. 조회(계좌번호)
	public AccountBean findByAccountNo(String accNo);
	//8. 조회(이름)
	public List<AccountBean> findByName(String findName);
	//9. 조회(전체통장수)
	public int count();
	
	
}

