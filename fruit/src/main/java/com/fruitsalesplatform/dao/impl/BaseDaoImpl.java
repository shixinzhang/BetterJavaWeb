package com.fruitsalesplatform.dao.impl;

import com.fruitsalesplatform.dao.BaseDao;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by zhangshixin on 19/8/7.
 */
public class BaseDaoImpl<T> extends SqlSessionDaoSupport implements BaseDao<T> {
    @Autowired
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        super.setSqlSessionFactory(sqlSessionFactory);
    }

    /**
     * 命名空间
     */
    private String ns;

    public String getNs() {
        return ns;
    }

    public void setNs(String ns) {
        this.ns = ns;
    }

    @Override
    public T get(Serializable id) {
        return getSqlSession().selectOne(ns + ".get", id);
    }

    @Override
    public List<T> find(Map map) {
        return getSqlSession().selectList(ns + ".find", map);
    }

    @Override
    public void insert(T t) {
        getSqlSession().insert(ns + ".insert", t);
    }

    @Override
    public void update(T t) {
        getSqlSession().update(ns + ".update", t);
    }

    @Override
    public void deleteById(Serializable id) {
        getSqlSession().delete(ns + ".deleteById", id);
    }

    @Override
    public void delete(Serializable[] ids) {
        getSqlSession().delete(ns + ".delete", ids);
    }
}
