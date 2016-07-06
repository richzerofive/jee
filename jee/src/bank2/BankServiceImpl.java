package bank2;

import java.util.ArrayList;
import java.util.List;

import member.MemberBean;

public class BankServiceImpl implements BankService {

	List<AccountBean> list;
	String result = "";

	public BankServiceImpl() {
		list = new ArrayList<AccountBean>();
	}

	@Override
	public void openAccount(AccountBean bean) {
		// 11개설(은행창구개설)
		list.add(bean);
	}

	@Override
	public List<AccountBean> findAccount() {
		return list;
	}

	@Override
	public AccountBean findByAccountNo(String accNo) {
		int i = 0;
		AccountBean acc = new AccountBean();
		for (; i < list.size(); i++) {
			if ((list.get(i).getAccountNo()).equals(accNo)) {
				acc = list.get(i);
				break;
			}
		}
		return acc;
	}

	@Override
	public List<AccountBean> findByName(String name) {
		List<AccountBean> tempList = new ArrayList<AccountBean>();
		int i = 0;
		for (; i < list.size(); i++) {
			if ((name.equals(list.get(i).getName()))) {
				tempList.add(list.get(i));
				break;
			}
		}
		return tempList;
	}

	@Override
	public int count() {
		return list.size();
	}

	@Override
	public String updateAccount(AccountBean bean) {
		AccountBean temp = this.findByAccountNo(bean.getAccountNo());
		if (temp.getId() == null) {
			result = "계좌번호가 존재하지 않습니다";
		} else {
			temp.setPw(bean.getPw());
			result = "비밀번호가 변경되었습니다";
		}
		return result;
	}

	@Override
	public String deleteAccount(String findAcc) {
		AccountBean a = this.findByAccountNo(findAcc);
		if (a.getAccountNo() == null) {
			result = findAcc + "는 없는 계좌입니다";
		} else {
			list.remove(findAcc);
			result = "해지가 완료되었습니다";
		}
		return result;
	}
}
