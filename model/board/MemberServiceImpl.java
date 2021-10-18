package model.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("memberService")
public class MemberServiceImpl implements MemberService {
	@Autowired
	private SpringMemberDAO memberDAO;
	@Override
	public void insertMember(MemberVO vo) {
		// TODO Auto-generated method stub
		memberDAO.insertMember(vo);
		
	}

	@Override
	public void updateMember(MemberVO vo) {
		memberDAO.updateMember(vo);
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteMember(MemberVO vo) {
		memberDAO.deleteMember(vo);
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<MemberVO> selectAllMember(MemberVO vo) {
		
		return memberDAO.selectAllMember(vo);
	}

	@Override
	public MemberVO selectMember(MemberVO vo) {
		// TODO Auto-generated method stub
		return
		memberDAO.selectMember(vo);
	}
	

}
