package test;

public class StaticInitClass {
	static{
		System.out.println("스태틱 초기화블록 실행중");
	}//클래스 초기화블록
	{
		System.out.println("인스턴스 초기화블록 실행중");
	}//인스턴스 초기화블록
	public StaticInitClass() {} //생성자(초기화)
}
