package test.main;

import java.io.File;
import java.io.FileWriter;

public class MainClass07 {
	public static void main(String[] args) {
		//콘솔창으로부터 입력받은 문자열이라고 가정하자
		String msg = "안녕하세요2";
		
		//파일을 만들거나 이미 만들어진 파일에 대해서 작업할 객체 생성
		File f = new File("c://acorn202310/myFolder/diary.txt");
		try {
		//만일 존재하지 않으면 
		if(!f.exists()) {
			f.createNewFile();
			System.out.println("diary.txt 파일을 만들었습니다!");
		}
		//파일에 문자열을 출력할 객체 생성
		FileWriter fw = new FileWriter(f, true);
		
		fw.write(msg);
		fw.write("\r\n");
		fw.flush();
		fw.close();//마무리를 해야 파일도 정상적으로 만들어지고 사용가능하고 자원 누수가 방지된다.
		System.out.println("diary.txt 파일에 문자열을 기록했습니다.");
	}catch(Exception e){
		e.printStackTrace();
	}
	}		
}
