package test.dao;

import java.lang.reflect.Member;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import test.dto.MemberDto;
import test.util.DBConnect;

public class MemberDao {
	//회원 한명의 정보를 DB 에 저장하는 메소드
	public boolean insert(MemberDto dto) {
		//지역변수 미리 선언
	Connection conn=null;
	PreparedStatement pstmt=null;
	int rowCount = 0;
	try {
		//미리 준비한 util 클래스를 이용해서 Connection 객체 얻어오기 
		conn=new DBConnect().getConn();
		//실행할 미완성의 sql 문
		String sql="insert into member"
				+ " (num, name, addr)"
				+ " values(member_seq.nextval,?,?)";
		//미완성의 sql 문을 전달하면서 PreparedStatement 객체의 참조값 얻어내기
		pstmt=conn.prepareStatement(sql);
		//PreparedStatement 객체의 메소드를 이용해서 미완성인 sql 문을 완성시키기(? 에 값 바인딩하기)
		pstmt.setString(1, dto.getName());
		pstmt.setString(2, dto.getAddr());
		//sql 문 실행하기
		rowCount = pstmt.executeUpdate();
		
		
	}catch(Exception e) {
		e.printStackTrace();
	}finally {
		try {
			if(pstmt!=null)pstmt.close();
			if(conn!=null)conn.close();
		}catch(Exception e) {}
	}
	if(rowCount >0) {
		return true;
	}else {
		return false;
	}
	}
	
	
	//회원 한명의 정보를 수정하는 메소드
	public boolean update(MemberDto dto) {
		//지역변수 미리 선언
		Connection conn=null;
		PreparedStatement pstmt=null;
		int rowCount = 0;
		try {
			//미리 준비한 util 클래스를 이용해서 Connection 객체 얻어오기 
			conn=new DBConnect().getConn();
			//실행할 미완성의 sql 문
			String sql="update member"
					+ " set name=?, addr=?"
					+ " where num = ?";
			//미완성의 sql 문을 전달하면서 PreparedStatement 객체의 참조값 얻어내기
			pstmt=conn.prepareStatement(sql);
			//PreparedStatement 객체의 메소드를 이용해서 미완성인 sql 문을 완성시키기(? 에 값 바인딩하기)
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getAddr());
			pstmt.setInt(3, dto.getNum());
			//sql 문 실행하기
			rowCount = pstmt.executeUpdate();
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			}catch(Exception e) {}
		}
		if(rowCount >0) {
			return true;
		}else {
			return false;
		}
	}
	
	//회원 한명의 정보를 삭제하고 작업의 성공 여부를 리턴하는 메소드
	public boolean delete(int num) {
		//지역변수 미리 선언
	Connection conn=null;
	PreparedStatement pstmt=null;
	int rowCount = 0;
	try {
		//미리 준비한 util 클래스를 이용해서 Connection 객체 얻어오기 
		conn=new DBConnect().getConn();
		//실행할 미완성의 sql 문
		String sql="delete from member"
				+ " where num = ?";
		//미완성의 sql 문을 전달하면서 PreparedStatement 객체의 참조값 얻어내기
		pstmt=conn.prepareStatement(sql);
		//PreparedStatement 객체의 메소드를 이용해서 미완성인 sql 문을 완성시키기(? 에 값 바인딩하기)
		pstmt.setInt(1, num);
		//sql 문 실행하기
		rowCount = pstmt.executeUpdate();	
	}catch(Exception e) {
		e.printStackTrace();
	}finally {
		try {
			if(pstmt!=null)pstmt.close();
			if(conn!=null)conn.close();
			}catch(Exception e) {}
		}
		if(rowCount > 0) {
			return true;//삭제 성공
		
		}else {
			return false;//삭제실패
		}
	}
		
	
	//매개변수에 전달된 번호에 해당하는 회원 한명의 정보를 리턴하는 메소드
	public MemberDto getData(int num) {
		MemberDto dto = null;
		//DB 에서 SELECT 하기위해서 필요한 객체를 담을 지역변수 미리 만들기 
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			//Connection 객체의 참조값 얻어오기 
			conn = new DBConnect().getConn();
			//실행할 sql문 미리 준비
			String sql = "select num, name, addr"
					+ " from member"
					+ " where num = ?";
			//sql 문을 대신 실행해줄 PreparedStatement 객체의 참조값 얻어오기
			pstmt = conn.prepareStatement(sql);
			//만일 sql 문이 미완성이라면( ? 가 있다면) 여기서 ? 에 값을 바인딩 해준다.
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();

			if(rs.next()) {
				dto = new MemberDto();
				dto.setNum(num);
				dto.setName(rs.getString("name"));
				dto.setAddr(rs.getString("addr"));
			}
			//반복문 돌면서 
			while (rs.next()) {// cursor 다음 line 에 select 된 row 가 있다면

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
	
	//회원 전체의 목록을 번호에 대해서 내림차순 정렬해서 리턴하는 메소드
	public List<MemberDto> getList(){
		//회원목록을 담을 ArryaList 객체를 미리 생성해서 참조값 얻어내기
		List<MemberDto> list = new ArrayList<MemberDto>();
		//DB 에서 SELECT 하기위해서 필요한 객체를 담을 지역변수 미리 만들기 
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			//Connection 객체의 참조값 얻어오기 
			conn = new DBConnect().getConn();
			//실행할 sql문 미리 준비
			String sql = "select num, name, addr"
					+ " from member"
					+ " order by num desc";
			//sql 문을 대신 실행해줄 PreparedStatement 객체의 참조값 얻어오기
			pstmt = conn.prepareStatement(sql);
			//만일 sql 문이 미완성이라면( ? 가 있다면) 여기서 ? 에 값을 바인딩 해준다.
			rs = pstmt.executeQuery();

			//반복문 돌면서 
			while (rs.next()) {// cursor 다음 line 에 select 된 row 가 있다면
				MemberDto dto = new MemberDto();
				dto.setNum(rs.getInt("num"));
				dto.setName(rs.getString("name"));
				dto.setAddr(rs.getString("addr"));
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

