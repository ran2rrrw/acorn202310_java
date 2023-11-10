package test.main;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class MainClass09 {
	public static void main(String[] args) {
		
		//필요한 객체의 참조값을 담을 변수를 미리 만들기
		FileInputStream fis = null;
		FileOutputStream fos = null;
		
		//파일에서 byte 를 읽어들을때 사용하는 객체
		try {
			fis = new FileInputStream("c:/acorn202310/myFolder/1.jpg");
			//byte 를 파일에 출력할 때 사용하는 객체
			fos = new FileOutputStream("c:\\acorn202310\\myFolder\\copied.jpg");
			
			//byte 알갱이를 읽어낼 배열을 미리 준비하기
			byte[] buffer = new byte[1024];
		
			while(true) {
				//byte[] 배열을 전달해서 byte 알갱이를 한번에 1024 개씩 읽어들인다. 
				int readedCount = fis.read(buffer);//읽어들인 개수가 리턴된다.
				System.out.println(readedCount + " byte 를 읽었습니다");
				if(readedCount == -1)break; // 더이상 읽을 데이터가 없다면 반복문 탈출
				//byte[] 배열에 저장된 byte 알갱이를 0번 인덱스로 부터 읽은 개수만큼 출력하기
				fos.write(buffer, 0, readedCount);
				fos.flush();
			}
			System.out.println("파일을 copy 했습니다.");
			//마무리 작업 : exception 시 실행안됨/자원회수 x /  finally 
			
		
		}catch(Exception e) {
			e.printStackTrace();
		}finally {//try 블록 안의 지역변수 fos, fis 사용 x -> 변수생성, 값 대입 분리
			try {
				//null 체크를 하면서 close 하기
				if(fos!=null)fos.close();
				if(fis!=null)fis.close();
			}catch(Exception e) {}
			
		}
	}
}
