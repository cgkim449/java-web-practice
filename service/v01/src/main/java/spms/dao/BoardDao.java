package spms.dao;

import java.util.List;

import spms.vo.Board;

public interface BoardDao {
  List<Board> selectList() throws Exception;
}