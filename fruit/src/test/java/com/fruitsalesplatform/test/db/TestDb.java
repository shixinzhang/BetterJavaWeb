package com.fruitsalesplatform.test.db;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by zhangshixin on 19/8/6.
 */
public class TestDb {

    private String resource = "beans.xml";
    private SqlSessionFactory sqlSessionFactory;
    private SqlSession sqlSession;

    @Test
    public void testConnection() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(resource);
        sqlSessionFactory = (SqlSessionFactory) applicationContext.getBean("sessionFactory");
        sqlSession = sqlSessionFactory.openSession();

        if (sqlSession != null) {
            System.out.println("MyBatis 数据库连接成功，目前 SQL 配置数目：");
            System.out.println(sqlSession.getConfiguration().getMappedStatements().size());
        } else {
            System.out.println("SqlSession 获取失败");
        }

    }
}
