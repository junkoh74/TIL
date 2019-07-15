package dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import vo.MemberVO;

@Repository
public class MemberDAO {
	@Autowired
	SqlSession session = null;

	public boolean register(MemberVO vo) throws Exception {
		boolean result = true;
		try {
			String statement = "resource.MemberMapper.register";
			int regVo = session.insert(statement, vo);
			if (regVo != 1) {
				result = false;
			}
		} catch (Exception e) {
			System.out.println(e + " 중복된 아이디 혹은 이메일 입니다.");
			result = false;
		}
		return result;
	}

	public boolean login(MemberVO vo) {
		boolean result = true;
		String statement = "resource.MemberMapper.login";
		System.out.println("디비 아이디 : " + vo.getUser_id() + "디비 비밀번호 : " + vo.getPasswd());
		vo = session.selectOne(statement, vo);
		System.out.println(vo);
		if (vo == null) {
			result = false;
		} else {
			result = true;
		}
		return result;
	}
}
