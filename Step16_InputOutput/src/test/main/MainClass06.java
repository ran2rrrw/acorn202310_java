package test.main;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;

public class MainClass06 {
	public static void main(String[] args) {
		PrintStream ps = System.out;
		//학습을 위해서 PrintStream 객체를 부모 type OutputStream 으로 받아보기
		//OutputStream 도 1byte 처리 스트림이다
		OutputStream os = ps;
		//2byte 처리 스트림
		OutputStreamWriter osw = new OutputStreamWriter(os);
		
		BufferedWriter bw = new BufferedWriter(osw);
		try {
			bw.write("하나\r\n");
			bw.write("두울");
			bw.newLine();//운영체제에 맞는 개행기호를 자동으로 출력해주는 메소드
			bw.write("세엣");
			bw.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
