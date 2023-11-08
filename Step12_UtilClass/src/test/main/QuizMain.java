package test.main;

import java.util.ArrayList;
import java.util.Scanner;

public class QuizMain {
	public static void main(String[] args) {
		/*
		 * Scanner 객체를 이용해서 반복문 돌면서 3명의 이름을 입력받아서 
		 * 
		 * ArrayList 객체에 순서대로 저장하고 
		 * 
		 * 다 저장된 이후에 
		 * 
		 * 반복문 돌면서 ArrayList 에 저장된 3명의 이름을 순서대로 콘솔창에 출력해 보세요.
		 */
		
		Scanner scan = new Scanner(System.in);
		ArrayList<String> nameList = new ArrayList<>();
		//반복문 돌면서 3명의 이름을 입력 받아서 ArrayList 객체에 누적 시키기
		for (int i = 0;i<3;i++) {
			System.out.print("이름 입력: ");
			String name = scan.nextLine();
			nameList.add(name);
			//nameList.add(scan.nextLine());
		}
		//출력
		for(String tmp:nameList) {
			System.out.println(tmp);
		}
		
	}
	
}
