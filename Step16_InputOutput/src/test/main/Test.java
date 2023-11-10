package test.main;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class Test extends JFrame implements ActionListener {
	//필드
	JTextField txt;
	JButton sendBtn;
	//생성자
	public Test() {
		this.setTitle("frame");
		setBounds(100, 100, 500, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		setLayout(new FlowLayout());
		
		txt = new JTextField(20);
		sendBtn = new JButton("전송");
		
		 sendBtn.addActionListener(this);
		 
		add(txt);
		add(sendBtn);
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Test();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String msg = txt.getText();
		//파일을 만들거나 이미 만들어진 파일에 대해서 작업할 객체 생성
				File f = new File("c://acorn202310/myFolder/JTextField.txt");
				try {
				//만일 존재하지 않으면 
					if(!f.exists()) {
						f.createNewFile();
						System.out.println("JTextField.txt 파일을 만들었습니다!");
				}
				//파일에 문자열을 출력할 객체 생성
					FileWriter fw = new FileWriter(f, true);
				
					fw.write(msg);
					fw.write("\r\n");
					fw.flush();
					fw.close();//마무리를 해야 파일도 정상적으로 만들어지고 사용가능하고 자원 누수가 방지된다.
					System.out.println("JTextField.txt 파일에 문자열을 기록했습니다.");
				}catch(Exception ex){
					ex.printStackTrace();
			}
		
	}
}
