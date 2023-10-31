package test.main;

public class MainClass06 {
	//필드
	//static 메소드에서 사용하는 필드는 static 필드로 만들어야 사용할 수 있다.
	static int num = 999;
	//int num = 999;
			
	public static void main(String[] args) {
		//main() 메소드와 num 이라는 필드는 동일한 클래스의 멤버이기 때문에 MainClass06. 은 생략가능
		//int result = MainClass06.num + 1;
		int result = num + 1;
		
	}
	//메소드
	//static 메소드에서 사용하는 메소드는 static 메소드로 만들어야 사용할 수 있다.
	//main() 메소드와 num 이라는 필드는 동일한 클래스의 멤버이기 때문에 MainClass06. 은 생략가능
	//public static void MainClass.test(){}
	public static void test() {}
	//public void test() {}
}
