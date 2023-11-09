package test.frame01;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MyFrame extends JFrame{
	
	// 생성자
	public MyFrame() {
		//프레임의 제목 설정
		this.setTitle("나의 프레임");
		//setBounds(x, y, width, height) 창의 위치와 크기 설정
		setBounds(100, 100, 500, 500);
		//이 프레임(MyFrame)의 x 버튼(close 버튼) 을 눌렀을 때 프로세스도 같이 종료 되도록 설정
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//레이아웃 매니저는 아직 사용하지 않겠다. (모든 UI 를 절대 좌표에 배치 하겠다)
		setLayout(null);
		//버튼 하나 만들어서
		JButton btn1 = new JButton("버튼1");
		//위치를 설정하고(x,y)
		btn1.setLocation(10, 10);
		//크기도 설정하고(width, height)
		btn1.setSize(100, 30);
		//프레임에 추가하기
		this.add(btn1);
		
		
		
		//버튼에 등록할 액션리스너 객체의 참조값을 얻어내서 listener 지역변수에 참조값을 담기
		ActionListener listener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("버튼을 눌렀네?");
				//알림창 띄우기 .ShowMessageDialog(띄울 프레임의 참조값, 띄울 문자열)
				JOptionPane.showMessageDialog(MyFrame.this, "버튼을 눌렀네요?");
				
			}
		};
		//버튼에 액션리스너 등록하기
		btn1.addActionListener(listener);
		
		//btn2
		
		JButton btn2 = new JButton("버튼2");
		btn2.setLocation(120, 10);
		btn2.setSize(100, 30);
		this.add(btn2);
		
//		ActionListener listener2 = new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				System.out.println("버튼2를 눌렀네?");
//				JOptionPane.showMessageDialog(MyFrame.this, "버튼을 눌렀네요?");
//				
//			}
//		};
		
		btn2.addActionListener((e)->{
			JOptionPane.showMessageDialog(this, "두번째 버튼을 눌렀네요?");
		});
		
		
		//프레임을 화면상에 실제 보이게 하기(false 하면 안보임)
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		//myFrame 객체 생성
		new MyFrame();
		System.out.println("main 메소드가 종료 됩니다.");
	}
}
