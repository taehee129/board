package model.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.you.app.common.LogPlusAdvice;

import model.common.JDBC;


public class BoardDAO {
	private Connection conn;
	private PreparedStatement pstmt;
	
	
	private final String insertSQL = "insert into board2(id,title,writer,content) values((select nvl(max(id),0)+1 from board2),?,?,?)";
	private final String updateSQL = "update board2 set title=?, content=? where id=?";
	private final String deleteSQL = "delete board2 where id=?";
	private final String selectAllSQL = "select b.* from  (select rownum as rnum, a.*  from (select * from BOARD2 order by wdate desc) a where rownum<=?) b where rnum >?";
	private final String selectSQL = "select * from board2 where id=?";
	
	
	
	public void insertBoard(BoardVO vo) {
		
		conn = JDBC.getConnection();
		try {
			pstmt = conn.prepareStatement(insertSQL);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getWriter());
			pstmt.setString(3, vo.getContent());
			
			
			pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBC.disconnect(pstmt, conn);
		}
	}
	public boolean updateBoard(BoardVO vo) {
		boolean result = false;
		conn = JDBC.getConnection();
		try {
			pstmt = conn.prepareStatement(updateSQL);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContent());
			pstmt.setInt(3, vo.getId());
			
			pstmt.executeUpdate();
			result = true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result = false;
		} finally {
			JDBC.disconnect(pstmt, conn);
		}
		
		return result;
	}
	public void deleteBoard(BoardVO vo) {
		
		conn = JDBC.getConnection();
		try {
			pstmt = conn.prepareStatement(deleteSQL);
			pstmt.setInt(1, vo.getId());

			
			pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBC.disconnect(pstmt, conn);
		}
		
	}
	public ArrayList<BoardVO> selectAll(int paging) {
	
		conn = JDBC.getConnection();
		ArrayList<BoardVO> boards = new ArrayList<BoardVO>();
		try {
			pstmt = conn.prepareStatement(selectAllSQL);
			pstmt.setInt(1, paging*10+10);
			pstmt.setInt(2, paging*10);
			
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
			
				BoardVO board = new BoardVO();
				board.setContent(rs.getString("content"));
				board.setTitle(rs.getString("title"));
				board.setId(rs.getInt("id"));
				board.setWdate(rs.getDate("wdate"));
				board.setWriter(rs.getString("writer"));
				boards.add(board);
				
				
			}
			
			rs.close();

			
			pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBC.disconnect(pstmt, conn);
		}
		return boards;
		
	}
	public BoardVO select(BoardVO vo) {
	
		conn = JDBC.getConnection();
		BoardVO board =null;
		try {
			pstmt = conn.prepareStatement(selectSQL);
			pstmt.setInt(1, vo.getId());

			
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				 board = new BoardVO();
				board.setContent(rs.getString("content"));
				board.setTitle(rs.getString("title"));
				board.setId(rs.getInt("id"));
				board.setWdate(rs.getDate("wdate"));
				board.setWriter(rs.getString("writer"));
			}
			rs.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBC.disconnect(pstmt, conn);
		}
		
		return board;
		
	}
	
	public int countBoard() {
		
		conn = JDBC.getConnection();
		int boardLen =0;
		
		try {
			String sql = "select count(*) from board2";
			pstmt = conn.prepareStatement(sql);
		

			
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				boardLen = rs.getInt(1);
		
			}
			rs.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBC.disconnect(pstmt, conn);
		}
		
		return boardLen;
		
	}
	
	
	
	

}
