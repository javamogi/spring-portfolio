package com.springportfolio.dao;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.springportfolio.domain.boards.Board;

public class MyBatisBoardTest {
	private static final Logger log = LoggerFactory.getLogger(MyBatisBoardTest.class);

	private SqlSessionFactory sqlSessionFactory;

	@Before
	public void setup() throws Exception {
		String resource = "mybatis-config-test.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}

	@Test
	public void gettingStarted() {
		try (SqlSession session = sqlSessionFactory.openSession()) {
			List<Board> list = session.selectList("BoardMapper.select");
			log.debug("Boards : {}", list);
		}
	}

	@Test
	public void create() throws Exception {
		try (SqlSession session = sqlSessionFactory.openSession()) {
			Board board = new Board("�ѱ�", "userId", "�����ٶ�");
			session.insert("BoardMapper.createBoard", board);
			Board actual = session.selectOne("BoardMapper.selectOne", board.getNum());
			log.debug("actual : {}", actual);
			assertThat(actual, is(board));
		}
	}

	@Test
	public void update() throws Exception {
		try (SqlSession session = sqlSessionFactory.openSession()) {
			Board board = new Board("�ѱ�", "userId", "�����ٶ�");
			session.insert("BoardMapper.createBoard", board);
			Board updateBoard = new Board(board.getNum(), "�ѱ�2", "userId", "���ٻ��");
			log.debug("updateBoard : {}", updateBoard);
			session.update("BoardMapper.updateBoard", updateBoard);
			Board updatedBoard = session.selectOne("BoardMapper.selectOne", board.getNum());
			log.debug("updatedBoard : {}", updatedBoard);
			assertThat(updateBoard, is(updatedBoard));
		}
	}

	@Test
	public void delete() throws Exception {
		try (SqlSession session = sqlSessionFactory.openSession()) {
			session.delete("BoardMapper.deleteBoard", 1);
			assertNull(session.selectOne("BoardMapper.selectOne", 1));
		}
	}

	@Test
	public void updateCount() throws Exception {
		try (SqlSession session = sqlSessionFactory.openSession()) {
			Board board = session.selectOne("BoardMapper.selectOne", 1);
			int count = board.getCount();
			count += 1;
			session.update("BoardMapper.updateCount", new Board(1, count));
			Board updateBoard = session.selectOne("BoardMapper.selectOne", 1);
			log.debug("db : {}", updateBoard);
		}
	}

	@Test
	public void selectCount() throws Exception {
		try (SqlSession session = sqlSessionFactory.openSession()) {
			int total = session.selectOne("BoardMapper.selectCount");
			log.debug("total : {}", ""+total);
		}
	}

}
