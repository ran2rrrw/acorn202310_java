package test.main;

import java.awt.BorderLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import test.dto.MemberDto;

/*
 * 과제)mainclass 10, 11 참고
 * JTable에 회원정보 추가, 목록보기 2가지 기능을 구현해 보세요
 * 회원 한명의 정보는 번호, 이름, 주소로 구성되어 있으므로 MemberDto 객체에 담으면 됩니다.
 * 회원 여러명의 정보는 List<MemberDto> 객체에 누적되게 해서
 * ObjectOutputStream 객체를 이용해서 my_members.dat 파일에 영구 저장되게 해 보세요.
 * 
 * 프레임을 새로 시작할 때 마다 ObjectInputStream 을 이용해서
 * my_members.dat 파일에 저장된 내용이 JTable에 모두 출력되도록 하세요.
 * 
 * (다 구현하신 분은 원하신다면 연구해서 수정, 삭제 기능도 해보세요)
 */
public class task extends JFrame implements ActionListener{
	MemberDto dto = null;
	JTable table;
	DefaultTableModel model;
	//JTable
	public task(String title) {
		super(title);
		//레이아웃 매니저 설정
			setLayout(new BorderLayout());
			
			//표 형식으로 출력할 JTable
			table = new JTable();
			//테이블의 컬럼명을 미리 배열로 준비한다.
			String[] colNames = {"번호", "이름", "주소"};
			//테이블에 연결할 모델객체 생성(테이블에 출력할 데이터를 여기에 추가하면 테이블에 출력된다.)
			model = new DefaultTableModel(colNames, 0);
			//모델을 테이블에 연결한다.
			table.setModel(model);
			//테이블을 스크롤 패널로 감싸고 
			JScrollPane scroll = new JScrollPane(table);
			
			
			
			//회원정보 추가(memberdto, list<memberdto>)
			
			//텍스트 필드, 버튼 추가
			JTextField txt1 = new JTextField(15);
			JTextField txt2 = new JTextField(15);
			JTextField txt3 = new JTextField(15);
			JButton addBtn = new JButton("추가");
			
			
			
			//스크롤 패널을 프레임의 가운데에 배치하기
			add(scroll, BorderLayout.CENTER);
			
			//패널 
			Panel pn = new Panel();
			add(pn, BorderLayout.SOUTH);
			pn.add(txt1);
			pn.add(txt2);
			pn.add(txt3);
			pn.add(addBtn);
			
			
			
			List<MemberDto> list = new ArrayList<MemberDto>();
			
			
			//정보담기
			addBtn.addActionListener((e)->{
				dto = new MemberDto();
				dto.setNum(Integer.parseInt(txt1.getText()));
				dto.setName(txt2.getText());
				dto.setAddr(txt3.getText());
				list.add(dto);
				txt1.setText(null);
				txt2.setText(null);
				txt3.setText(null);
//				System.out.printf("번호 : %d, 이름: %s, 주소: %s %n", dto.getNum(), dto.getName(), dto.getAddr());
			});
			
			//파일
			//참조값을 담을 지역변수
			FileOutputStream fos = null;
			ObjectOutputStream oos = null;
			
			try {
				fos = new FileOutputStream("c://acorn202310/myFolder/my_members.dat");
				oos = new ObjectOutputStream(fos);
				oos.writeObject(dto);
				System.out.println("MemberDto 객체를 members.dat 파일에 저장했습니다.");
				dto = null;
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				try {
					if(oos!=null)oos.close();
					if(fos!=null)fos.close();
				}catch(Exception e) {}
				}
			}
			
	
	
	
	
	
	public static void main(String[] args) {
		task f = new task ("테이블 테스트");
		f.setDefaultCloseOperation(EXIT_ON_CLOSE);
		f.setBounds(100, 100, 800, 500);
		f.setVisible(true);
	}






	@Override
	public void actionPerformed(ActionEvent e) {
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		try {
			fis = new FileInputStream("c://acorn202310/myFolder/my_members.dat");
			ois = new ObjectInputStream(fis);
			MemberDto rdto = (MemberDto)ois.readObject();
			Vector<MemberDto> row = new Vector<MemberDto>();
			row.add(rdto);
			
			model.addRow(row);
			System.out.println(row);
		}catch(Exception e1) {
			e1.printStackTrace();
		}finally {
			try {
				if(ois!=null)ois.close();
				if(fis!=null)fis.close();
			}catch(Exception e1) {}
		}
		
	}
}
