package com.fruitsalesplatform.test.dao.impl;

import com.fruitsalesplatform.test.dao.TestDao;
import com.fruitsalesplatform.test.entity.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by zhangshixin on 19/8/7.
 */
//为了包扫描的时候这个 dao 被扫描到
@Repository
public class TestDaoImpl implements TestDao{
    @Autowired
    private SqlSessionFactory sqlSessionFactory;
    private SqlSession sqlSession;

    public SqlSession getSqlSession() {
        if (sqlSession != null) {
            return sqlSession;
        }

        sqlSession = sqlSessionFactory.openSession();
        return sqlSession;
    }

    @Override
    public List<User> findUserByName(String name) {
        return sqlSession.selectList("test.findUserByName", name);
    }
}
