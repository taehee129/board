package model.board;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;


class MemberRowMapper implements RowMapper<MemberVO>  {

	@Override
	public MemberVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		MemberVO member = new MemberVO();
		member.setId(rs.getString("id")); 
		member.setName(rs.getString("name"));
		member.setPasswoard(rs.getString("password"));
		member.setRole(rs.getString("role"));
		
		return member;
	}
	
}


@Repository
public class SpringMemberDAO {
	
	private final String insertSQL ="insert into member2 (id,password,name,role) values(?,?,?,?)";
	private final String deleteSQL ="delete from member2 where id=?";
	private final String updateSQL = "update member2 set id=?, password=?, name=?, role=? where id=?";
	private final String selectSQL= "select * from member2 where id=? and password=?";
	private final String selectAllSQL = "select * from member2";
	
	
	private JdbcTemplate jdbcTemplate;
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public void insertMember(MemberVO vo) {
		System.out.println("jdbcTemplate 으로 insert");
		jdbcTemplate.update(insertSQL, vo.getId(),vo.getPasswoard(),vo.getName(),vo.getRole());
	}
	
	public void deleteMember(MemberVO vo) {
		System.out.println("jdbcTemplate 으로 delete");
		jdbcTemplate.update(deleteSQL, vo.getId());
	}
	public void updateMember(MemberVO vo) {
		System.out.println("jdbcTemplate 으로 upate");
		Object[] args = {vo.getId(), vo.getPasswoard(), vo.getName(), vo.getRole(),vo.getId()};
		jdbcTemplate.update(updateSQL,args);
		
	}
	public MemberVO selectMember(MemberVO vo) {
		System.out.println("jdbcTemplate 으로 select");
		Object[] args = {vo.getId(), vo.getPasswoard()};
		MemberVO member =null;
		try {
		member = jdbcTemplate.queryForObject(selectSQL, args, new MemberRowMapper());
		} catch(EmptyResultDataAccessException e) {
			member =null;
			
		}
				return member;
	}
	public List<MemberVO> selectAllMember(MemberVO vo){
		System.out.println("jdbcTemplate 으로 selectAll");
		return jdbcTemplate.query(selectAllSQL, new MemberRowMapper());
	}
	
			
}
