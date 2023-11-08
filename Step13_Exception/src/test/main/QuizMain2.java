package test.main;
/*
 *  run 했을 때 콘솔창에 경과 시간이 출력되는 프로그래밍을 해 보세요.
 *  
 *  0분 1초
 *  0분 2초
 *  0분 4초
 *  .
 *  .
 *  0분 59초
 *  1분 0초
 *  1분 1초
 *  .
 *  .
 */
public class QuizMain2 {
	public static void main(String[] args) {
		//분과 초를 저장할 변수 2개가 필요하다
		int min = 0;
		int sec = 0;
		//시간이 계속 진행이 되어야 하기 때문에 루프가 필요하다
		while(true) {
			//sec = sec +1;
			//sec += 1 ;
			//스레드를 1초 지연 시키기
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
			//1초 증가
			sec++;
			//sec 이 만일 60이면 0으로 바꿔야 한다.
			if(sec == 60) {
				sec = 0;
				min++;
			}
			System.out.println(min + "분" + sec + "초");
			
		}
	}
			
				

}
