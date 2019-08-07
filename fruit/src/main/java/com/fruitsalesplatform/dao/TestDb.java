package com.fruitsalesplatform.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by zhangshixin on 19/8/6.
 */
public class TestDb {

    private static String resource = "spring.xml";
    private static SqlSessionFactory sqlSessionFactory;
    private static SqlSession sqlSession;

    public static void main(String[] args) {
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
