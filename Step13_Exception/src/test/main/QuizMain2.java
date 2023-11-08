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
		for(int i=0; i<10;i++) {
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			
				e.printStackTrace();
			}
			int sec = i + 1;
			int min;
			System.out.println(min + "분" + sec + "초");
	}
}
}
