package test.main;

import java.awt.FlowLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class MyFrame extends JFrame implements ActionListener{
	//필드
	JTextField inputMsg;
	
	//프레임의 제목을 전달 받는 생성자
	public MyFrame(String title) {
		super(title); // 부모 생성자에 프레임의 제목 전달하기
		setBounds(100,100,500,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		
		//문자열을 한줄 입력 받을 수 있는 JTextField 객체 생성
		inputMsg = new JTextField(20);
		JButton saveBtn = new JButton("저장");
		
		saveBtn.addActionListener(this);
	
		
		add(inputMsg);
		add(saveBtn);
		
		
	}
	
	public static void main(String[] args) {
		MyFrame f = new MyFrame("나의 프레임6");
		f.setVisible(true);
	}
	//ActionListener 인터페이스를 implements 했기 때문에 강제로 구현된 메소드
	@Override
	public void actionPerformed(ActionEvent e) {
		//JTextField 에 입력한 문자열 읽어오기
		String msg = inputMsg.getText();
		//파일을 만들거나 이미 만들어진 파일에 대해서 작업할 객체 생성
		File f = new File("c://acorn202310/myFolder/diary.txt");
		try {
		//만일 존재하지 않으면 
		if(!f.exists()) {
			f.createNewFile();
			System.out.println("diary.txt 파일을 만들었습니다!");
		}
		//파일에 문자열을 출력할 객체 생성
		FileWriter fw = new FileWriter(f, true);
		
		fw.write(msg);
		fw.write("\r\n");
		fw.flush();
		fw.close();//마무리를 해야 파일도 정상적으로 만들어지고 사용가능하고 자원 누수가 방지된다.
		System.out.println("diary.txt 파일에 문자열을 기록했습니다.");
	}catch(Exception e2){
		e2.printStackTrace();
	}
	
		
		
		
		
	}
		
	}

