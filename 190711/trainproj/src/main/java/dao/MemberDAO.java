package dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import vo.MemberVO;

@Repository
public class MemberDAO {
	@Autowired
	SqlSession session = null;

	public boolean register(MemberVO vo) {
		boolean result = true;
		String statement = "resource.MemberMapper.register";
		if (session.insert(statement, vo) != 1)
			result = false;
		return result;
	}
	
	public boolean login(String user_id) {
		boolean result = true;
		String statement = "resource.NewsMapper.login";
//		System.out.println("디비 아이디" + vo.getUser_id());
		if (session.selectOne(statement, user_id) != user_id)
			result = false;
		return result;
	}

}
