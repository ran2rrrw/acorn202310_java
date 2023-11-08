package test.main;

import java.util.ArrayList;
import java.util.List;

import test.mypac.ContentDto;

/*
 * 글 목록을 ArrayList에 담아 보세요
 * 
 * 글 하나는 
 * 글번호, 작성자, 제목 으로 이루어져 있다고 가정합니다.
 * 
 * 글 3개의 정보를 ArrayList 에 담고, 반복문 돌면서 담긴 내용을 출력해 보세요.
 * 
 * 글 하나를 담을 dto 클래스를 알아서 만들어 보세요(클래스명, 필드명 등등)
 */
public class QuizMain2 {
	public static void main(String[] args) {
		List<ContentDto> list = new ArrayList<>();
		
		ContentDto dto1 = new ContentDto();
		dto1.setNum(1);
		dto1.setName("김구라");
		dto1.setTitle("제목1");
		
		ContentDto dto2 = new ContentDto(2, "해골", "제목2");
		ContentDto dto3 = new ContentDto(3, "원숭이", "제목3");
		
		list.add(dto1);
		list.add(dto2);
		list.add(dto3);
		
		for(ContentDto tmp:list) {
			String result = String.format("글번호: %d, 작성자: %s, 제목: %s", tmp.getNum(), tmp.getName(), tmp.getTitle());
			System.out.println(result);
		}
		
	}
}
