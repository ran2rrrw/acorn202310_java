package test.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import test.dto.OrderDto;
import test.util.DBConnect;

public class OrderDao {
	public boolean insert(OrderDto dto) {
		// 지역변수 미리 선언
		Connection conn = null;
		PreparedStatement pstmt = null;
		int rowCount = 0;
		try {
			// 미리 준비한 util 클래스를 이용해서 Connection 객체 얻어오기
			conn = new DBConnect().getConn();
			// 실행할 미완성의 sql 문
			String sql = "insert into" + " (o_id, p_id, quantity, o_date)" + " values(o_seq.nextval, ?, ?, ?";
			// 미완성의 sql 문을 전달하면서 PreparedStatement 객체의 참조값 얻어내기
			pstmt = conn.prepareStatement(sql);
			// PreparedStatement 객체의 메소드를 이용해서 미완성인 sql 문을 완성시키기(? 에 값 바인딩하기)
			pstmt.setInt(1, dto.getP_id());
			pstmt.setInt(2, dto.getQuantity());
			pstmt.setInt(3, dto.getQuantity());
			// sql 문 실행하기
			rowCount = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
			}
		}
		if (rowCount > 0) {
			return true;
		} else {
			return false;
		}

	}

	public boolean update(OrderDto dto) {
		// 지역변수 미리 선언
		Connection conn = null;
		PreparedStatement pstmt = null;
		int rowCount = 0;
		try {
			// 미리 준비한 util 클래스를 이용해서 Connection 객체 얻어오기
			conn = new DBConnect().getConn();
			// 실행할 미완성의 sql 문
			String sql = "update orders" + " set p_id = ?, quantity = ?, o_date = ?" + " where o_id = ?";
			// 미완성의 sql 문을 전달하면서 PreparedStatement 객체의 참조값 얻어내기
			pstmt = conn.prepareStatement(sql);
			// PreparedStatement 객체의 메소드를 이용해서 미완성인 sql 문을 완성시키기(? 에 값 바인딩하기)
			pstmt.setInt(1, dto.getP_id());
			pstmt.setInt(2, dto.getQuantity());
			pstmt.setString(3, dto.getO_date());
			pstmt.setInt(4, dto.getO_id());
			// sql 문 실행하기
			rowCount = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
			}
		}
		if (rowCount > 0) {
			return true;
		} else {
			return false;
		}

	}

	public boolean delete(OrderDto dto) {
		// 지역변수 미리 선언
		Connection conn = null;
		PreparedStatement pstmt = null;
		int rowCount = 0;
		try {
			// 미리 준비한 util 클래스를 이용해서 Connection 객체 얻어오기
			conn = new DBConnect().getConn();
			// 실행할 미완성의 sql 문
			String sql = "delete from orders" + " where o_id = ?";
			// 미완성의 sql 문을 전달하면서 PreparedStatement 객체의 참조값 얻어내기
			pstmt = conn.prepareStatement(sql);
			// PreparedStatement 객체의 메소드를 이용해서 미완성인 sql 문을 완성시키기(? 에 값 바인딩하기)
			pstmt.setInt(1, dto.getO_id());
			// sql 문 실행하기
			rowCount = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
			}
		}
		if (rowCount > 0) {
			return true;
		} else {
			return false;
		}

	}

	public OrderDto getdata(int o_id) {
		OrderDto dto = null;
		// DB 에서 SELECT 하기위해서 필요한 객체를 담을 지역변수 미리 만들기
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			// Connection 객체의 참조값 얻어오기
			conn = new DBConnect().getConn();
			// 실행할 sql문 미리 준비
			String sql = "select o_id, p_id, quantity, o_date" + " from orders" + " where o_id = ?";
			// sql 문을 대신 실행해줄 PreparedStatement 객체의 참조값 얻어오기
			pstmt = conn.prepareStatement(sql);
			// 만일 sql 문이 미완성이라면( ? 가 있다면) 여기서 ? 에 값을 바인딩 해준다.
			pstmt.setInt(1, o_id);
			rs = pstmt.executeQuery();

			// 반복문 돌면서
			while (rs.next()) {// cursor 다음 line 에 select 된 row 가 있다면
				dto = new OrderDto();
				dto.setO_id(o_id);
				dto.setP_id(rs.getInt("p_id"));
				dto.setQuantity(rs.getInt("quantity"));
				dto.setO_date("o_date");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
			}
		}
		return dto;
	}

	public List<OrderDto> getList() {
		List<OrderDto> list = new ArrayList<OrderDto>();
		// DB 에서 SELECT 하기위해서 필요한 객체를 담을 지역변수 미리 만들기
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			// Connection 객체의 참조값 얻어오기
			conn = new DBConnect().getConn();
			// 실행할 sql문 미리 준비
			String sql = "select o_id, p_id, quantity, o_date" + " from orders" + " order by o_id";
			// sql 문을 대신 실행해줄 PreparedStatement 객체의 참조값 얻어오기
			pstmt = conn.prepareStatement(sql);
			// 만일 sql 문이 미완성이라면( ? 가 있다면) 여기서 ? 에 값을 바인딩 해준다.
			rs = pstmt.executeQuery();

			// 반복문 돌면서
			while (rs.next()) {// cursor 다음 line 에 select 된 row 가 있다면
				OrderDto dto = new OrderDto();
				dto.setO_id(rs.getInt("o_id"));
				dto.setP_id(rs.getInt("p_id"));
				dto.setQuantity(rs.getInt("quantity"));
				dto.setO_date(rs.getString("o_date"));
				list.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
			}
		}
		return list;
	}

}
