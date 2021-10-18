package model.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("boardService")
public class BoardServiceImpl implements BoardService {
	@Autowired
	SpringBoardDAO boardDAO;
	@Override
	public void insertBoard(BoardVO vo) {
		
		boardDAO.insertBoard(vo);
		
	}

	@Override
	public void updateBoard(BoardVO vo) {
		// TODO Auto-generated method stub
		boardDAO.updateBoard(vo);
		
	}

	@Override
	public void deleteBoard(BoardVO vo) {
		// TODO Auto-generated method stub
		boardDAO.deleteBoard(vo);
		
	}

	@Override
	public List<BoardVO> selectAll(BoardVO vo) {
		// TODO Auto-generated method stub
		
		return boardDAO.selectAll(vo);
	}

	@Override
	public BoardVO select(BoardVO vo) {
		// TODO Auto-generated method stub
		return boardDAO.select(vo);
	}

}
