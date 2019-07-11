package dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import vo.RegisterVO;

@Repository
public class RegisterDAO {
	@Autowired
	SqlSession session = null;

	public boolean register(RegisterVO vo) {
		boolean result = true;
		String statement = "resource.MemberMapper.register";
		if (session.insert(statement, vo) != 1)
			result = false;
		return result;
	}

}
