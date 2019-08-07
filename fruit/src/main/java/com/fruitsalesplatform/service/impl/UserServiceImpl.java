package com.fruitsalesplatform.service.impl;

import com.fruitsalesplatform.dao.UserDao;
import com.fruitsalesplatform.entity.User;
import com.fruitsalesplatform.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by zhangshixin on 19/8/8.
 */
//为了被扫到
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    //后期业务复杂时可能注入多个 dao

    @Override
    public User get(Serializable id) {
        return userDao.get(id);
    }

    @Override
    public List<User> find(Map map) {
        return userDao.find(map);
    }

    @Override
    public void insert(User user) {
        userDao.insert(user);
    }

    @Override
    public void update(User user) {
        userDao.update(user);
    }

    @Override
    public void deleteById(Serializable id) {
        userDao.deleteById(id);
    }

    @Override
    public void delete(Serializable[] ids) {
        userDao.delete(ids);
    }
}
