package test.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainClass10 {
	public static void main(String[] args) {
		/*
		 * 세명의 회원정보(번호, 이름, 주소) 를 HashMap 객체에 각각 담아서
		 * 
		 * ArrayLsit 객체에 누적 시켜 보세요.
		 * 
		 * 반복문 돌면서 ArrayList 객체에 누적된 회원정보를 콘솔창에 순서대로 출력해 보세요.
		 * 
		 * (HashMap 객체 3개, ArrayList 객체 1개가 생성 되야 함)
		 * 
		 * ArrayList 객체 안에 HashMap 을 담을 예정이니
		 * 
		 *  List<HashMap<String, Object>> type 이 필요합니다
		 */
		
		Map<String, Object> map1 = new HashMap<String, Object>();
		map1.put("num", 1);
		map1.put("name", "김구라");
		map1.put("addr", "노량진");
		
		Map<String, Object> map2 = new HashMap<String, Object>();
		map2.put("num", 2);
		map2.put("name", "해골");
		map2.put("addr", "행신동");
		
		Map<String, Object> map3 = new HashMap<String, Object>();
		map3.put("num", 3);
		map3.put("name", "원숭이");
		map3.put("addr", "동물원");
		
		List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
		
		list.add(map1);
		list.add(map2);
		list.add(map3);
		
		for(Map<String, Object> tmp : list  ) {
			String result = String.format("번호 : %d, 이름: %s, 주소: %s", 
					(int)tmp.get("num"), (String)tmp.get("name"), (String)tmp.get("addr"));
			System.out.println(result);
		}
		
		
	}
}



