package test.frame02;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MyFrame extends JFrame{
	
	// 생성자
	public MyFrame() {
		//프레임의 제목 설정
		this.setTitle("나의 프레임 2");
		//setBounds(x, y, width, height) 창의 위치와 크기 설정
		setBounds(100, 100, 500, 500);
		//이 프레임(MyFrame)의 x 버튼(close 버튼) 을 눌렀을 때 프로세스도 같이 종료 되도록 설정
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//FlowLayour 매니저 사용해보기
		setLayout(new FlowLayout(FlowLayout.LEFT));
		
		//버튼 하나 만들어서
		JButton btn1 = new JButton("버튼1");
		//프레임에 추가하기
		this.add(btn1);
		
		JButton btn2 = new JButton("버튼2");
		add(btn2);
		
		JButton btn3 = new JButton("버튼3");
		add(btn3);
		
				
		//프레임을 화면상에 실제 보이게 하기
		setVisible(true);
	}
	
	public static void main(String[] args) {
		//myFrame 객체 생성
		new MyFrame();
		System.out.println("main 메소드가 종료 됩니다.");
	}
}
