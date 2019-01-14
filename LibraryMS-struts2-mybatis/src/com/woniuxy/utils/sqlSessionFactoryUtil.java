package com.woniuxy.utils;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class sqlSessionFactoryUtil {
	private static InputStream inputStream = null;
	private static SqlSessionFactory sessionFactory = null;
	private static ThreadLocal<SqlSession> threadLocal = new ThreadLocal<>();

	static {
		try {
			inputStream = Resources.getResourceAsStream("mybatis-main.xml");
			sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static SqlSession getSqlsession() {
		SqlSession sqlSession = threadLocal.get();
		if (sqlSession == null) {
			sqlSession = sessionFactory.openSession();
			threadLocal.set(sqlSession);
		}
		return sqlSession;
	}

	public static void closeSqlsession() {
		SqlSession sqlSession = threadLocal.get();
		if (sqlSession != null) {
			sqlSession.commit();
			sqlSession.close();
			threadLocal.remove();
		}

	}

}
