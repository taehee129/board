package model.board;

import java.util.List;

public interface MemberService {
	void insertMember(MemberVO vo);
	void updateMember(MemberVO vo);
	void deleteMember(MemberVO vo);
	List<MemberVO> selectAllMember(MemberVO vo);
	MemberVO selectMember(MemberVO vo);
}
