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
			String sql = "insert into orders" + " (id, pname, price, qtt)" + " values(od_seq.nextval, ?, ?, ?)";
			// 미완성의 sql 문을 전달하면서 PreparedStatement 객체의 참조값 얻어내기
			pstmt = conn.prepareStatement(sql);
			// PreparedStatement 객체의 메소드를 이용해서 미완성인 sql 문을 완성시키기(? 에 값 바인딩하기)
			pstmt.setString(1, dto.getPname());
			pstmt.setInt(2, dto.getPrice());
			pstmt.setInt(3, dto.getQtt());
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
			String sql = "update orders" + " set pname = ?, price = ?, qtt = ?" + " where id = ?";
			// 미완성의 sql 문을 전달하면서 PreparedStatement 객체의 참조값 얻어내기
			pstmt = conn.prepareStatement(sql);
			// PreparedStatement 객체의 메소드를 이용해서 미완성인 sql 문을 완성시키기(? 에 값 바인딩하기)
			pstmt.setString(1, dto.getPname());
			pstmt.setInt(2, dto.getPrice());
			pstmt.setInt(3, dto.getQtt());
			pstmt.setInt(4, dto.getId());
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

	public boolean delete(int id) {
		// 지역변수 미리 선언
		Connection conn = null;
		PreparedStatement pstmt = null;
		int rowCount = 0;
		try {
			// 미리 준비한 util 클래스를 이용해서 Connection 객체 얻어오기
			conn = new DBConnect().getConn();
			// 실행할 미완성의 sql 문
			String sql = "delete from orders" + " where id = ?";
			// 미완성의 sql 문을 전달하면서 PreparedStatement 객체의 참조값 얻어내기
			pstmt = conn.prepareStatement(sql);
			// PreparedStatement 객체의 메소드를 이용해서 미완성인 sql 문을 완성시키기(? 에 값 바인딩하기)
			pstmt.setInt(1, id);
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

	public OrderDto getdata(int id) {
		OrderDto dto = null;
		// DB 에서 SELECT 하기위해서 필요한 객체를 담을 지역변수 미리 만들기
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			// Connection 객체의 참조값 얻어오기
			conn = new DBConnect().getConn();
			// 실행할 sql문 미리 준비
			String sql = "select id, pname, price, qtt" + " from orders" + " where id = ?";
			// sql 문을 대신 실행해줄 PreparedStatement 객체의 참조값 얻어오기
			pstmt = conn.prepareStatement(sql);
			// 만일 sql 문이 미완성이라면( ? 가 있다면) 여기서 ? 에 값을 바인딩 해준다.
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();

			// 반복문 돌면서
			while (rs.next()) {// cursor 다음 line 에 select 된 row 가 있다면
				dto = new OrderDto();
				dto.setId(id);
				dto.setPname(rs.getString("pname"));
				dto.setPrice(rs.getInt("price"));
				dto.setQtt(rs.getInt("qtt"));
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
			String sql = "select id, pname, price, qtt" + " from orders" + " order by id";
			// sql 문을 대신 실행해줄 PreparedStatement 객체의 참조값 얻어오기
			pstmt = conn.prepareStatement(sql);
			// 만일 sql 문이 미완성이라면( ? 가 있다면) 여기서 ? 에 값을 바인딩 해준다.
			rs = pstmt.executeQuery();

			// 반복문 돌면서
			while (rs.next()) {// cursor 다음 line 에 select 된 row 가 있다면
				OrderDto dto = new OrderDto();
				dto.setId(rs.getInt("id"));
				dto.setPname(rs.getString("pname"));
				dto.setPrice(rs.getInt("price"));
				dto.setQtt(rs.getInt("qtt"));
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
