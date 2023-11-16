package test.main;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import test.dao.OrderDao;
import test.dto.OrderDto;

public class OrderFrame extends JFrame {
	// 필드
	List<OrderDto> list = new ArrayList<OrderDto>();
	DefaultTableModel model = new DefaultTableModel();

	// 프레임
	public OrderFrame(String title) {
		super(title);
		setLayout(new BorderLayout());

		// ui
		JLabel label1 = new JLabel("상품번호");
		JLabel label2 = new JLabel("수량");
		JLabel label3 = new JLabel("주문일자");

		JTextField input_id = new JTextField(10);
		JTextField input_q = new JTextField(10);
		JTextField input_d = new JTextField(10);

		JButton addBtn = new JButton("추가");
		JButton delBtn = new JButton("삭제");

		// 배치
		JPanel panel = new JPanel();
		panel.add(label1);
		panel.add(input_id);
		panel.add(label2);
		panel.add(input_q);
		panel.add(label3);
		panel.add(input_d);
		panel.add(addBtn);
		panel.add(delBtn);

		add(panel, BorderLayout.NORTH);

		// 테이블 생성
		JTable table = new JTable();
		String[] colNames = { "주문번호", "상품번호", "수량", "주문일자" };
		// 모델 연결
		DefaultTableModel model = new DefaultTableModel(colNames, 0);
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
			Object[] row = { tmp.getO_id(), tmp.getP_id(), tmp.getQuantity(), tmp.getO_date() };
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
}
