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

import test.dao.OrderDao;
import test.dto.OrderDto;

public class OrderFrame extends JFrame implements ActionListener {
	// 필드
	List<OrderDto> list = new ArrayList<>();
	DefaultTableModel model;
	JTextField input_pname;
	JTextField input_p;
	JTextField input_q;
	JTable table;

	// 프레임
	public OrderFrame(String title) {
		super(title);
		setLayout(new BorderLayout());

		// ui
		JLabel label1 = new JLabel("상품명");
		JLabel label2 = new JLabel("가격");
		JLabel label3 = new JLabel("수량");

		input_pname = new JTextField(10);
		input_p = new JTextField(10);
		input_q = new JTextField(10);

		JButton addBtn = new JButton("추가");
		JButton delBtn = new JButton("삭제");

		// 배치
		JPanel panel = new JPanel();
		panel.add(label1);
		panel.add(input_pname);
		panel.add(label2);
		panel.add(input_p);
		panel.add(label3);
		panel.add(input_q);
		panel.add(addBtn);
		panel.add(delBtn);

		add(panel, BorderLayout.NORTH);

		// 버튼에 이벤트
		addBtn.addActionListener(this);
		delBtn.addActionListener(this);

		// action command 설정
		addBtn.setActionCommand("add");
		delBtn.setActionCommand("delete");

		// 테이블 생성
		table = new JTable();
		String[] colNames = { "주문번호", "상품명", "가격", "수량" };
		// 모델 연결
		model = new DefaultTableModel(colNames, 0);

		// 테이블 리스너
		table.addPropertyChangeListener((e) -> {
			System.out.println("리스너 동작!");
			System.out.println(e.getPropertyName());
			System.out.println(table.isEditing());
			if (e.getPropertyName().equals("tableCellEditor") && !table.isEditing()) {
				int selectedIndex = table.getSelectedRow();
				// 모델로부터 현재 인덱스에 있는 Table 출력값을 얻어낸다
				int id = (int) model.getValueAt(selectedIndex, 0);
				String pname = (String) model.getValueAt(selectedIndex, 1);
				int p = (int) model.getValueAt(selectedIndex, 2);
				int q = (int) model.getValueAt(selectedIndex, 3);

				// 수정할 회원의 정보를 MemberDto 객체에 담고
				OrderDto dto = new OrderDto(id, pname, p, q);
				// DB 에 수정 반영하기
				new OrderDao().update(dto);
				// 선택된 포커스 clear
				table.clearSelection();
			}
		});

		// 테이블에 연결
		table.setModel(model);
		// 스크롤
		JScrollPane scroll = new JScrollPane(table);
		// 가운데에 배치
		add(scroll, BorderLayout.CENTER);
		// 이자리로 메소드 refreshtalbe호출할 것
		refreshTable();
	}

	public void refreshTable() {
		// db 에 저장된 목록 읽기
		list = new OrderDao().getList();
		// 현재테이블에 출력된 모든 내용 삭제
		model.setRowCount(0);
		// 반복문 돌면서 모든 내용 추가하기
		for (OrderDto tmp : list) {
			Object[] row = { tmp.getId(), tmp.getPname(), tmp.getPrice(), tmp.getQtt() };
			// row 를 추가한다
			model.addRow(row);
		}

	}

	public static void main(String[] args) {
		JFrame f = new OrderFrame("주문관리");
		f.setDefaultCloseOperation(EXIT_ON_CLOSE);
		f.setBounds(100, 100, 1000, 500);
		f.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// 버튼의 command 값 구하기
		String command = e.getActionCommand();
		// 분기
		if (command.equals("add")) {
			String pname = input_pname.getText();
			int p = Integer.parseInt(input_p.getText());
			int q = Integer.parseInt(input_q.getText());
			OrderDto dto = new OrderDto();
			dto.setPname(pname);
			dto.setPrice(p);
			dto.setQtt(q);
			new OrderDao().insert(dto);
		} else if (command.equals("delete")) {
			int row = table.getSelectedRow();
			if (row == -1) {
				JOptionPane.showMessageDialog(this, "삭제할 row를 선택해 주세요,");
				return;
			}
			OrderDto dto = list.get(row);
			int id = dto.getId();
			new OrderDao().delete(id);
		}
		refreshTable();
	}
}
