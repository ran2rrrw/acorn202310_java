package test.main;

import java.util.Random;

public class QuizMain {
	public static void main(String[] args) {
		/*
		 * 1. run 했을 때
		 * 	cherry, apple, banana, melon, 7
		 *  5개의 문자열 중에서 1개가 랜덤하게 출력되게 해 보세요.
		 *  
		 *  hint) 
		 *  random 객체와 String[]객체를 활용
		 */
		String[] str = {"cherry", "apple", "banana", "melon", "7"};
		//랜덤한 숫자를 얻어낼 수 있는 객체 생성
		Random ran = new Random();
		int ranNum2 = ran.nextInt(str.length);
		System.out.println(str[ranNum2]);
		
		/*
		 * Random ran = new Random();
		//정수 범위 내에서 랜덤한 정수 하나 얻어내기
		int ranNum = ran.nextInt();
		System.out.println(ranNum);
		//0 이상 10 미만 행위내에서 랜덤한 정수 하나 얻어내기 (0~9) 사이의 랜덤한 정수 얻어내기
		int ranNum2 = ran.nextInt(10);
		System.out.println(ranNum2);
		 */
		
	}
}
