package test;

/**
 * @date : 2016. 7. 1.
 * @author :박승주
 * @file : StaticInit.java
 * @story: 스테틱 초기화 블록
 */
public class StaticInit {
	
	
	public static void main(String[] args) {
		StaticInitClass a1 = new StaticInitClass();
		System.out.println("------------------------");
		StaticInitClass a2 = new StaticInitClass();
		System.out.println("------------------------");
		StaticInitClass a3 = new StaticInitClass();
	}
}
