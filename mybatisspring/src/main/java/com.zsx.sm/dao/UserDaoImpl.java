package com.zsx.sm.dao;

import com.zsx.sm.po.User;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import java.util.List;

/**
 * Created by zhangshixin on 19/8/7.
 */
public class UserDaoImpl extends SqlSessionDaoSupport implements UserDao {
    @Override
    public User findUserByName(String name) throws Exception {
        SqlSession sqlSession = getSqlSession();
        User user = sqlSession.selectOne("test.findUserByName", name);
        return user;
    }

    @Override
    public List<User> all() throws Exception {
        SqlSession sqlSession = getSqlSession();
        return sqlSession.selectList("test.all");
    }

    @Override
    public User findUserById(int id) throws Exception {
        SqlSession sqlSession = getSqlSession();
        return sqlSession.selectOne("test.findUserById", id);
    }
}
