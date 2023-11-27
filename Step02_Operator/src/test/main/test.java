package test.main;

import java.util.Scanner;

public class test {
	public static void main(String[] args) {
		int num = 0;
		Scanner scan = new Scanner(System.in);
		System.out.print("출력할 구구단 단수 입력: ");
		String str = scan.next();
		num = Integer.parseInt(str);
		for (int i = 1; i < 10; i++) {
			int num2 = num * i;
			System.out.printf("%d x %d = %d \r\n", num, i, num2);
		}

	}

}
