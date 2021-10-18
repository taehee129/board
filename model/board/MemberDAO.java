package model.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.common.JDBC;

public class MemberDAO {
	
	public MemberVO getDBDate(MemberVO vo) {
		
		Connection conn = JDBC.getConnection();
		PreparedStatement pstmt = null;
		MemberVO data =null;
		
		try {
			String sql = "select * from member2 where id=? and password=?";
			pstmt  = conn.prepareStatement(sql);
			pstmt.setString(1,vo.getId());
			pstmt.setString(2, vo.getPasswoard());
			
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				data = new MemberVO();
				data.setId(rs.getString("id"));
				data.setName(rs.getString("name"));
				data.setRole(rs.getString("role"));
				data.setPasswoard(rs.getString("password"));
				
				
			}
			rs.close();
		}catch(Exception e ) {
			e.printStackTrace();
		}finally {
			JDBC.disconnect(pstmt, conn);
		}
		
		return data;
	}
	
@SuppressWarnings("resource")
public boolean insertMember(MemberVO vo) {
		
		Connection conn = JDBC.getConnection();
		PreparedStatement pstmt = null;
		boolean result=true;
	
		
		try {
			String sql ="select id from member2";
			pstmt = conn.prepareStatement(sql);
			
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				if(rs.getString(1).equals(vo.getId())) {
					result = false;
					return result;
				}
			}
			
			 sql = "insert into member2(id, password, name, role) values(?,?,?, 'user')";
			pstmt  = conn.prepareStatement(sql);
			pstmt.setString(1,vo.getId());
			pstmt.setString(2, vo.getPasswoard());
			pstmt.setString(3, vo.getName());
			pstmt.executeQuery();

		}catch(Exception e ) {
			e.printStackTrace();
		}finally {
			JDBC.disconnect(pstmt, conn);
		}
		return result;
	
	}
	
	

	

}
