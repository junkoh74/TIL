package dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import vo.LoginVO;

@Repository
public class LoginDAO {
	@Autowired
	SqlSession session = null;
	
	public boolean login(String user_id) {
		boolean result = true;
		LoginVO vo = new LoginVO();
		String statement = "resource.NewsMapper.login";
		System.out.println("디비 아이디" + vo.getUser_id());
		if (session.selectOne(statement, user_id) != vo.getUser_id())
			result = false;
		return result;
	}
}
