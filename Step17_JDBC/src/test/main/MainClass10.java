package test.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import test.dto.MemberDto;
import test.util.DBConnect;

public class MainClass10 {
		//매개변수에 전달된 회원번호에 해당되는 회원정보를 db에서 select 한 다음 MemberDto 객체에 담아서 
		//리턴하는 메소드를 완성 시켜 보세요.
		//num 에 해당하는 회원정보가 만일 없으며 null 을 리턴하도록 하세요
		
		public static MemberDto getData(int num) {
		MemberDto dto = null;
			
		//DB 에서 Select 하기 위해서 필요한 객체를 담을 지역변수 미리 만들기
		Connection conn =null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			//Connection 객체의 참조값 얻어오기
			conn = new DBConnect().getConn();
			//실행할 sql 을 미리 준비
			String sql = "select num,name, addr"
					+ " from member"
					+ " where num = ? ";
			//sql 문을 대신 실행해줄 PreparedStatement 객체의 참조값 얻어오기
			pstmt = conn.prepareStatement(sql);
			//만일 sql 문이 미완성이라면( ? 가 있다면) 여기서 ? 에 값을 바인딩 해준다
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {// next 가 있음 수행(여긴 없음), while 대신 if 사용(row 1개)
				//rs.next 는 while 이나 if 필요(row 가 없을 수 있어서)
			
			dto = new MemberDto();
			dto.setNum(num);
			dto.setName(rs.getString("name"));
			dto.setAddr(rs.getString("addr"));
			
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			}catch(Exception e) {}
		}
		return dto;
		}
	
	
	public static void main(String[] args) {
		int num = 2;
		//1 번 회원의 정보를 얻어와서
		MemberDto dto = getData(num);
		//사용하기
		if(dto!=null) {
		System.out.println(num + "번 회원의 이름은 " + dto.getName() + "이고 주소는 " + dto.getAddr());
		}else {
			System.out.println(num + "번 회원은 존재하지 않습니다.");
		}

	}
}
