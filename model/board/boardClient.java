package model.board;

import java.util.ArrayList;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class boardClient {
	public static void main(String[] args) {
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");
		BoardService service = (BoardService) factory.getBean("boardService");
		BoardVO vo = new BoardVO();
//		vo.setId(3);
//		service.deleteBoard(vo);
//		vo.setTitle("제목2");
//		vo.setWriter("유씨");
//		vo.setContent("내용");
//		service.insertBoard(vo);
//		
		vo.setTitle("제");
		
		
		service.selectAll(vo);
		
		
		
		factory.close();
	}

}
