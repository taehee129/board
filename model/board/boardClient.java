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
//		vo.setTitle("����2");
//		vo.setWriter("����");
//		vo.setContent("����");
//		service.insertBoard(vo);
//		
		vo.setTitle("��");
		
		
		service.selectAll(vo);
		
		
		
		factory.close();
	}

}
