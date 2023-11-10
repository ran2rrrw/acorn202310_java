package test.main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MyFrame2 extends JFrame implements ActionListener{
	//필드
	JTextField inputMsg;
	
	//프레임의 제목을 전달 받는 생성자
	public MyFrame2(String title) {
		super(title); // 부모 생성자에 프레임의 제목 전달하기
		setBounds(100,100,500,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		
		//문자열을 한줄 입력 받을 수 있는 JTextField 객체 생성
		inputMsg = new JTextField(20);
		JButton saveBtn = new JButton("저장");
		//프레임을 액션리스너로 등록
		saveBtn.addActionListener(this);
	
		//UI를 감쌀 패널
		JPanel p1 = new JPanel();
		//패널에 UI를 배치하고
		p1.add(inputMsg);
		p1.add(saveBtn);
		//패널을 프레임에 남쪽에 추가
		add(p1, BorderLayout.SOUTH);
		p1.setBackground(Color.yellow);
		//여러줄의 문자열을 출력하거나 입력할 수 있는 JTextArea
		JTextArea ta = new JTextArea();
		add(ta,BorderLayout.CENTER);
		
		JButton readBtn = new JButton("읽어오기");
		p1.add(readBtn);
		readBtn.addActionListener((e) -> {
			//JtextArea 에 출력된 내용을 빈문자열로 덮어쓰기(삭제) 한다음
			ta.setText("");
			
			FileReader fr = null;
			BufferedReader br = null;
			try {
				// 파일에서 문자열을 읽어들일 객체
				fr = new FileReader("c:/acorn202310/myFolder/diary.txt");
				//문자열을 좀더 편하게 읽어들이기 위해 FileReader 를 Buffered Reader 로 포장하기
				br = new BufferedReader(fr);
				while(true) {
					//문자열을 한줄씩 읽어낸다.
					String line = br.readLine();
					//만일 더이상 읽을 문자열이 없다면
					if(line == null)break;//반복문 탈출
					ta.append(line);
					ta.append("\r\n");
				}
				
			}catch(Exception e2) {
				e2.printStackTrace();
			}
		});
		
		JButton deleteBtn = new JButton("파일삭제");
		p1.add(deleteBtn);
		deleteBtn.addActionListener((e)->{
			
			int result = JOptionPane.showConfirmDialog(this, "진짜 삭제 할거임?");
			//만일 "예"를 누르면 삭제 한다.
			if(result == JOptionPane.OK_OPTION) {
				//diary.txt 파일을 제어할 수 있는 file 객체 생성
				File f = new File("c:/acorn202310/myFolder/diary.txt");
				f.delete();
			}
			
			
			
		});
	}
	
	public static void main(String[] args) {
		MyFrame2 f = new MyFrame2("나의 프레임6");
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

