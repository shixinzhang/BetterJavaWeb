package com.fruitsalesplatform.test.db;

import com.fruitsalesplatform.test.entity.User;
import com.fruitsalesplatform.test.mapper.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;
import java.util.Properties;

/**
 * Created by zhangshixin on 19/8/6.
 */
public class TestDb {

    private String resource = "spring.xml";
    private SqlSessionFactory sqlSessionFactory;
    private SqlSession sqlSession;

    @Test
    public void testConnection() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(resource);
        sqlSessionFactory = (SqlSessionFactory) applicationContext.getBean("sessionFactory");
        sqlSession = sqlSessionFactory.openSession();

        if (sqlSession != null) {
            System.out.println("MyBatis 数据库连接成功，目前 SQL 配置数目：");
//            try {
//                Properties clientInfo = sqlSession.getConnection().getClientInfo();
//                System.out.println("clientInfo" + clientInfo);
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
            System.out.println(sqlSession.getConfiguration().getMappedStatements().size());
        } else {
            System.out.println("SqlSession 获取失败");
        }
    }

    public SqlSession getSqlSession() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(resource);
        sqlSessionFactory = (SqlSessionFactory) context.getBean("sessionFactory");
        sqlSession = sqlSessionFactory.openSession();
        return sqlSession;
    }

    @Test
    public void testSelect() {
        sqlSession = getSqlSession();
        User user = sqlSession.selectOne("test.findUserByName", "zsx");
        System.out.println("查询到的信息：" + user);
    }

    @Test
    public void testMapperInterface() throws Exception {
        System.out.println(  this.getClass().getResource("UserMapper.xml"));
        System.out.println(this.getClass().getResource("."));
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(resource);
        UserMapper userMapper = (UserMapper) context.getBean("userMapper");
        User user = userMapper.findUserByName("zsx");
        System.out.println("查询到的信息：" + user);
    }
}
