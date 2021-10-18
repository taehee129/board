package model.board;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MemberClient {
	public static void main(String[] args) {
		
		AbstractApplicationContext factory = new GenericXmlApplicationContext("applicationContext.xml");
		MemberService service = (MemberService) factory.getBean("memberService");
		
		
				
		MemberVO member = new MemberVO();
//		
//		member.setId("taehee");
//		service.deleteMember(member);
//		
//		
		member.setId("taehee");
		member.setName("taehee");
		member.setPasswoard("1234");
		member.setRole("user");
		service.insertMember(member);

//		
//		member.setId("taehee");
//		member.setPasswoard("1234");
//		if(service.selectMember(member) ==null) {
//			System.out.println("로그인 실패!");
//		}
//	
//		
		
		factory.close();
	}
}

