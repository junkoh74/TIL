package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import vo.NewsVO;

@Repository
public class NewsDAO {
//	public class NewsMyBatisDAO implements NewsDAO{
	@Autowired
	SqlSession session = null;

	public boolean insert(NewsVO vo) {
		boolean result = true;
		String statement = "resource.NewsMapper.insertNews";
		if (session.insert(statement, vo) != 1)
			result = false;
		return result;
	}

	public boolean update(NewsVO vo) {
		boolean result = true;
		String statement = "resource.NewsMapper.updateNews";
		if (session.update(statement, vo) != 1)
			result = false;
		return result;
	}

//	public boolean viewCount(NewsVO vo) {
//		boolean result = true;
//		String statement = "resource.NewsMapper.viewCount";
//		if (session.update(statement, vo) != 1)
//			result = false;
//		return result;
//	}

	public boolean delete(int id) {
		boolean result = true;
		String statement = "resource.NewsMapper.deleteNews";
		if (session.delete(statement, id) != 1)
			result = false;
		return result;
	}

	public List<NewsVO> search(String keyword) {
		List<NewsVO> list = null;
		String statement = "resource.NewsMapper.searchTitle";
		list = session.selectList(statement, keyword);
		return list;
	}

	public List<NewsVO> listAll() {
		List<NewsVO> list = null;
		String statement = "resource.NewsMapper.selectNews";
		list = session.selectList(statement);
		return list;
	}

//	public NewsVO listOne() {
//		NewsVO list=null;
//		String statement = "resource.NewsMapper.selectOne";
//		list = (NewsVO) session.selectList(statement);
//		return list;
//	}

	public List<NewsVO> listOne(NewsVO vo) {
		List<NewsVO> list = null;
		System.out.println(vo.toString());
		String statement = "resource.NewsMapper.selectOne";
		String statementCount = "resource.NewsMapper.viewCount";
		session.selectOne(statementCount, vo);
		list = session.selectList(statement, vo);
		return list;
	}

	public List<NewsVO> listWriter(String writer) {
		List<NewsVO> list = null;
		String statement = "resource.NewsMapper.selectWriter";
		list = session.selectList(statement, writer);
		return list;
	}
}
