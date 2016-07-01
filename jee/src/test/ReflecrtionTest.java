package test;

import member.MemberBean;

public class ReflecrtionTest {
	public static void main(String[] args) {
		// MemberBean mem= new MemberBean();
		try {
			MemberBean mem = (MemberBean) Class.forName("member.MemberBean").newInstance();
			mem.setName("hong");
			mem.setName("홍길동");
			mem.setName("1");
			System.out.println(mem.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
