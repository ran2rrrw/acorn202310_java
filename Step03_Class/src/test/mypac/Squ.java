package test.mypac;
 
public class Squ {

		public int width;
		public int height;
		
		public void showSqu() {
			String square = "사각형 넓이는 " + (width * height) + " 입니다." ;
			System.out.println(square);
		}
	}

/*
 * 높이, 폭을 필드 / 사각형의 넓이를 콘솔창에 출력하는 메소드 / non static / 
 * public void printArea(){
 * 	int area = width * height;
 * 	System.out.println("면적은 :" + area);
 * }
 */