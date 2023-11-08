package test.main;

import java.util.ArrayList;
import java.util.List;

import test.mypac.Member;

public class MainClass05 {
	public static void main(String[] args) {
		//1. Member 객체를 담을 수 있는 ArrayList 객체를 생성해 members 라는 지역변수에 담기
		List<Member> members = new ArrayList<>();
		//2. 3명의 회원정보를 Member 객체에 각각 담아보세요.(객체 3개 생성)
		Member m1 = new Member(1, "김구라", "노량진");
		Member m2 = new Member(2, "해골", "행신동");
		Member m3 = new Member(3, "원숭이", "동물원");
		
		
		
		//3. 위에서 생성된 Member 객체의 참조값을 ArrayList 객체에 모두 담기
		members.add(m1);
		members.add(m2);
		members.add(m3);
		
		
		
		/*
		 * 4. members List 객체에 담긴 내용을 이용해서 회원목록을 아래와 같은 형식으로
		 * 반복문 돌면서 출력해 보세요.
		 * 
		 * 번호: 1, 이름: 김구라, 주소: 노량진
		 * 번호: 2, 이름: 해골, 주소: 행신동
		 * .
		 * .
		 * 		 */
		for (Member tmp : members) {
			//출력할 문자열의 format을 맞추기
			//System.out.println("번호: " + tmp.num + ", 이름: " + tmp.name + ", 주소: " + tmp.addr);
		
			System.out.printf("번호 : %d, 이름: %s, 주소: %s %n", tmp.num, tmp.name, tmp.addr);
		}
		/*
		 * 숫자: %d
		 * 문자: %s
		 * String.format( "format 문자열", 전달할값1, 전달할값2....)
		 */
		
		members.forEach((tmp)->{
			String result = String.format("번호: %d, 이름: %s, 주소: %s", tmp.num, tmp.name, tmp.addr);
			System.out.println(result);
		});
	}
}
