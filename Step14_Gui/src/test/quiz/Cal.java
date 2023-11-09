package test.quiz;

import java.awt.FlowLayout;
import java.security.DomainCombiner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Cal extends JFrame{
	//필드
	JTextField num1;
	JTextField num2;
	JLabel label2;
	public Cal(String title) {
		super(title); // 부모 생성자에 프레임의 제목 전달하기
		setBounds(100,100,500,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
	
			
		
	//버튼
		num1 = new JTextField(10);
		JButton Btn1 = new JButton("+");
		JButton Btn2 = new JButton("-");
		JButton Btn3 = new JButton("*");
		JButton Btn4 = new JButton("/");
		num2 = new JTextField(10);
		JLabel label1 = new JLabel("=");
		label2 = new JLabel("...");
		
		add(num1);
		add(Btn1);
		add(Btn2);
		add(Btn3);
		add(Btn4);
		add(num2);
		add(label1);
		add(label2);
		
		//버튼에 actionListener
		//+
		Btn1.addActionListener((e) -> {
			try {
				double num1 = Double.parseDouble(this.num1.getText());
				double num2 = Double.parseDouble(this.num2.getText());
				Double num = num1 + num2;
				String result = Double.toString(num);
				label2.setText(result);
			}catch(NumberFormatException nfe) {
				JOptionPane.showMessageDialog(this,"숫자 형식으로 입력해 주세요!" );
			}
		});
		
		//-
		Btn2.addActionListener((e) -> {
			try {
				double num1 = Double.parseDouble(this.num1.getText());
				double num2 = Double.parseDouble(this.num2.getText());
				Double num = num1 - num2;
				String result = Double.toString(num);
				label2.setText(result);
			}catch(NumberFormatException nfe) {
				JOptionPane.showMessageDialog(this,"숫자 형식으로 입력해 주세요!" );
			}
		});
		
		//*
		Btn3.addActionListener((e) -> {
			try {
				double num1 = Double.parseDouble(this.num1.getText());
				double num2 = Double.parseDouble(this.num2.getText());
				Double num = num1 * num2;
				String result = Double.toString(num);
				label2.setText(result);
			}catch(NumberFormatException nfe) {
				JOptionPane.showMessageDialog(this,"숫자 형식으로 입력해 주세요!" );
			}
		});
		
		
		///
		Btn4.addActionListener((e) -> {
			try {
				double num1 = Double.parseDouble(this.num1.getText());
				double num2 = Double.parseDouble(this.num2.getText());
				if(num2 == 0) {
					throw new ArithmeticException();
				}
				Double num = num1 / num2;
				String result = Double.toString(num);
				label2.setText(result);
			}catch(NumberFormatException nfe) {
				JOptionPane.showMessageDialog(this,"숫자 형식으로 입력해 주세요!" );
			}catch(ArithmeticException ae) {
				JOptionPane.showMessageDialog(this,"어떤수를 0으로 나눌 수는 없어요" );
			}
			
		});
		
}
	//메인
	public static void main(String[] args) {
		Cal c = new Cal("계산기");
		c.setVisible(true);
	}
}
