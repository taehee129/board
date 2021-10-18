package model.board;

import java.util.List;

public interface BoardService {
	public void insertBoard(BoardVO vo);
	public void updateBoard(BoardVO vo);
	public void deleteBoard(BoardVO vo);
	public List<BoardVO> selectAll(BoardVO vo);
	public BoardVO select(BoardVO vo);
	
}
