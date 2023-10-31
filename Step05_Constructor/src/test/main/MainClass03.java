package test.main;


import test.mypac.Cpu;
import test.mypac.HardDisk;
import test.mypac.MacBook;
import test.mypac.Memory;

public class MainClass03 {
	public static void main(String[] args) {
		/*
		 * macbook 객체를 생성해서 참조값을 mac1 이라는 지역변수에 담아보세요.
		 * 
		 * 주의!
		 * -macbook 클래스를 절대 수정하지 마세요
		 * -MainClass03 은 test.main 패키지에 있고 Cpu, Memory, hardDisk, MacBook 클래스는
		 * test/mypac 패키지에 있기 때문에 4개 클래스 모두 import 되어야 한다. 
		 */
	
		//생성자의 매개변수에 전달할 값을 직접 생성해서 전달한다.
		 MacBook mac1 =new MacBook(new Cpu(), new Memory(), new HardDisk());
		 
		 //or
		 Cpu c1 = new Cpu();
		 Memory m1 = new Memory();
		 HardDisk h1 = new HardDisk();
		 //생성자의 매개변수에 전달할 값이 지역변수에 저장되어 있으면 지역변수 명으로 전달도 가능하다.
		 new MacBook(c1, m1, h1);
		 
	}
}
