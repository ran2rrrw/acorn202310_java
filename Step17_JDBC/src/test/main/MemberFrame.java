package test.main;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import test.dao.MemberDao;
import test.dto.MemberDto;

public class MemberFrame extends JFrame implements ActionListener {

	JTextField inputName;
	JTextField inputAddr;
	JTable table;
	// 회원정보를 누적 시킬 ArrayList 객체
	List<MemberDto> list = new ArrayList<>();
	DefaultTableModel model;

	public MemberFrame(String title) {
		super(title);
		setLayout(new BorderLayout());

		JLabel label2 = new JLabel("이름");
		JLabel label3 = new JLabel("주소");

		inputName = new JTextField(10);
		inputAddr = new JTextField(10);
		// JButton
		JButton addBtn = new JButton("추가");
		JButton deleteBtn = new JButton("선택된 행 삭제");

		// 페널에 UI 배치
		JPanel panel = new JPanel();
		panel.add(label2);
		panel.add(inputName);
		panel.add(label3);
		panel.add(inputAddr);
		panel.add(addBtn);
		panel.add(deleteBtn);

		// 페널을 프레임의 위쪽에 배치
		add(panel, BorderLayout.NORTH);

		// 버튼에 리스너 등록
		addBtn.addActionListener(this);
		deleteBtn.addActionListener(this);
		// 버튼에 action command 설정
		addBtn.setActionCommand("add");
		deleteBtn.setActionCommand("delete");
		table = new JTable();
		String[] colNames = { "번호", "이름", "주소" };
		// 테이블에 연결할 모델
		model = new DefaultTableModel(colNames, 0) {
			@Override
			public boolean isCellEditable(int row, int column) {
				if (column == 0) {// 0번째 칼럼은 수정 불가 하도록
					return false;// false 를 리턴하고
				} else {// 그 이외의 모든 경우는 수정 가능하도록
					return true;// true 를 리턴한다
				}

			}
		};
		// 테이블의 값이 수정되었는지 감시할 리스너 등록
		table.addPropertyChangeListener((e) -> {
			System.out.println("리스너 동작!");
			System.out.println(e.getPropertyName());
			System.out.println(table.isEditing());

			// property name 이 'tableCellEditor'이고
			// table 이 수정중이 아닐때
			// 현재 포커스가 있는 곳의 정보를 모두 읽어와서 DB 에 수정반영하기

			if (e.getPropertyName().equals("tableCellEditor") && !table.isEditing()) {
				int selectedIndex = table.getSelectedRow();
				// 모델로부터 현재 인덱스에 있는 Table 출력값을 얻어낸다
				int num = (int) model.getValueAt(selectedIndex, 0);
				String name = (String) model.getValueAt(selectedIndex, 1);
				String addr = (String) model.getValueAt(selectedIndex, 2);
				// 수정할 회원의 정보를 MemberDto 객체에 담고
				MemberDto dto = new MemberDto(num, name, addr);
				// DB 에 수정 반영하기
				new MemberDao().update(dto);
				// 선택된 포커스 clear
				table.clearSelection();
			}
		});
		// 모델을 테이블에 연결
		table.setModel(model);
		// 스크롤이 가능 하도록 테이블을 JScrollPane 에 감싼다.
		JScrollPane scroll = new JScrollPane(table);
		// JScrollPane 을 프레임의 가운데에 배치하기
		add(scroll, BorderLayout.CENTER);
		refreshTable();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// 눌러진 버튼의 action command 값을 읽어온다.
		String command = e.getActionCommand();
		// action command 를 이용해서 분기 하기
		if (command.equals("add")) {
			String name = inputName.getText();
			String addr = inputAddr.getText();
			// MemberDto 객체에 회원 한명의 정보를 담는다.
			MemberDto dto = new MemberDto();
			dto.setName(name);
			dto.setAddr(addr);
			// 회원 한명의 정보를 DB 에 저장하기
			new MemberDao().insert(dto);
		} else if (command.equals("delete")) {
			// JTalbe 객체의 메소드를 이용해서 어떤 인덱스의 Row 가 선택되었는지 알아내서 작업하기
			int row = table.getSelectedRow();
			if (row == -1) {
				JOptionPane.showMessageDialog(this, "삭제할 row를 선택해 주세요");
				return; // 메소드를 여기서 끝내기
			}
			// 선택된 row 인덱스에 해당하는 MemberDto 객체는 어떻게 얻어오지?
			MemberDto dto = list.get(row);
			int num = dto.getNum();// 삭제할 회원의 번호
			new MemberDao().delete(num);

		}
		refreshTable();
	}

	// 테이블에 회원목록을 출력해주는 메소드
	public void refreshTable() {
		// DB 저장된 목록을 읽어온다.
		list = new MemberDao().getList();
		// 현재 테이블에 출력된 모든 내용을 삭제
		model.setRowCount(0);
		// 반복문 돌면서 테이블 row 추가하기
		for (MemberDto tmp : list) {
			// MemberDto 에 담긴 내용을 Object[] 에 담은 다음
			Object[] row = { tmp.getNum(), tmp.getName(), tmp.getAddr() };
			// row 를 추가한다.
			model.addRow(row);
		}
	}

	public static void main(String[] args) {
		JFrame f = new MemberFrame("회원관리");
		f.setDefaultCloseOperation(EXIT_ON_CLOSE);
		f.setBounds(100, 100, 800, 500);
		f.setVisible(true);
	}
}
