package spms.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import spms.annotation.Component;
import spms.vo.Board;

@Component("boardDao")
public class BoardDaoImpl implements BoardDao{
	SqlSessionFactory sqlSessionFactory;
	
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
	    this.sqlSessionFactory = sqlSessionFactory;
	}

	@Override
	public List<Board> selectList() throws Exception {
		SqlSession sqlSession = sqlSessionFactory.openSession();
	    try {
	        return sqlSession.selectList("spms.dao.BoardDao.selectList");
	    } finally {
	        sqlSession.close();
	    }
	}
}
