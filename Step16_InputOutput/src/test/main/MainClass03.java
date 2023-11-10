package test.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainClass03 {
	public static void main(String[] args) {
		//1byte 처리 스트림
		InputStream is = System.in;
		//2byte 처리 스트림(한글 처리 가능)
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br =new BufferedReader(isr);
		
		System.out.println("문자열 한줄 입력: ");
		
		try {
			//BufferedReader 객체의 readLine() 메소드를 이용해서 문자열 한줄을 읽어 들이기
			String line = br.readLine();
			System.out.println("line: " + line);
		} catch (IOException e) {
			e.printStackTrace();
		}
}
}
