package test.main;

public class MainClass03 {
	public static void main(String[] args) {
		//1. String type 을 담을 수 있는 방 3개 짜리 배열객체를 만들어서 참조값을 지역 변수 names 에 담기
		String[] names = new String[3];
		//2. 3개의 방에 순서대로 친구의 이름을 담아 보세요.
		names[0] = "해골";
		names[1] = "원숭이";
		names[2] = "주뎅이";
		//3. 배열에 들어 있는 친구의 이름을 for 문을 이용해서 하나씩 순서대로 콘솔창에 출력해 보세요.
		for(int i = 0; i<names.length; i++) {
			System.out.println(names[i]);
		}
		
	}
}
