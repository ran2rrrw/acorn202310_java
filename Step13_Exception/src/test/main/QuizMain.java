package test.main;

public class QuizMain {
	/*
	 * run 했을 때 콘솔창에
	 * 1초 
	 * 2초
	 * 3초
	 * .
	 * .
	 * 경과 시간이 출력 되다가 
	 * .
	 * .
	 * 10초
	 * 까지만 출력하고 종료 되는 프로그래밍을 해 보세요.
	 */
	public static void main(String[] args) {
		for(int i=0; i<10;i++) {
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			
				e.printStackTrace();
			}
			int sec = i + 1;
			System.out.println(sec + "초");
		}
	}
}
