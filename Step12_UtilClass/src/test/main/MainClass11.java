package test.main;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MainClass11 {
	public static void main(String[] args) {
		//sample 데이터(영어사전 역할)
		Map<String, String> dic = new HashMap<String, String>();
		dic.put("house", "집");
		dic.put("phone", "전화기");
		dic.put("car", "자동차");
		dic.put("pencil", "연필");
		dic.put("eraser", "지우개");
		
		/*
		 * [콘솔창 실행 결과]
		 * 
		 * 검색할 단어를 입력하세요:house
		 * 
		 * house 의 뜻은 집입니다.
		 * 
		 * [콘솔창 실행 결과 2] 
		 * 
		 * 검색할 단어를 입력하세요:gura
		 * 
		 * gura 는 목록에 없습니다.
		 * 
		 */
		Scanner scan = new Scanner(System.in);
		System.out.println("검색할 단어를 입력하세요:");
		//문자열 입력 받기
		String word = scan.nextLine();
		//입력한 key 값을 이용해서 단어의 뜻을 찾는다(없으면 null 이 리턴된다)
		String mean = dic.get(word);
		
		if(mean != null) {
			System.out.println(word + "의 뜻은" + mean + "입니다.");
		}else {//null 이면
			System.out.println(word + "는 목록에 없습니다");
		}
		//만일 입력한 key 값이 존재하면
		if(dic.containsKey(word)) {
			System.out.printf("%s 의 뜻은 %s입니다", word, dic.get(word));
		} else {
			System.out.printf("%s 는 목록에 없습니다", word);
		}
	}
}

 
 
