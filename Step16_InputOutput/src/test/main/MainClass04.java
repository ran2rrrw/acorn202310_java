package test.main;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

public class MainClass04 {
	public static void main(String[] args) {
		//콘솔창과 연결된 객체의 참조값
		PrintStream ps = System.out;
		//OutputStream 도 1byte 처리 스트림이다.(한글처리 불가)
		OutputStream os = ps;
		try {
			os.write(97);
			os.write(105);
			os.write(114);
			//os.write(44032); 한글처리 불가
			os.flush();//방출
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	}
}