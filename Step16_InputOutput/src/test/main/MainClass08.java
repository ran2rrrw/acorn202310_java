package test.main;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class MainClass08 {
	public static void main(String[] args) {
		//파일에서 byte 를 읽어들을때 사용하는 객체
		try {
			FileInputStream fis = new FileInputStream("c:/acorn202310/myFolder/1.jpg");
			//byte 를 파일에 출력할 때 사용하는 객체
			FileOutputStream fos = new FileOutputStream("c:\\acorn202310\\myFolder\\copied.jpg");
			while(true) {
				//1 byte 읽어 들여서
				int readedByte = fis.read();
				System.out.println(readedByte);
				//만일 더 이상 읽을 byte 가 없다면 반복문 탈출
				if(readedByte == -1)break;
				//읽어 들인 1 byte 를 출력
				fos.write(readedByte);
				fos.flush();
			}
			System.out.println("파일을 copy 했습니다.");
			//마무리 작업
			fos.close();
			fis.close();
		
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
