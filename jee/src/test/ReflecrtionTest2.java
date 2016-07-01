package test;

import bank.AccountBean;

public class ReflecrtionTest2 {
	public static void main(String[] args) {
		try {
			AccountBean Bean = (AccountBean) Class.forName("bank.AccountBean").newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}