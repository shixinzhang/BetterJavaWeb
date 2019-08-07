package com.zsx.sm.dao;

import com.zsx.sm.po.User;

import java.util.List;

/**
 * Created by zhangshixin on 19/8/7.
 */
public interface UserDao {
    User findUserByName(String name) throws Exception;

    List<User> all() throws Exception;

    User findUserById(int id) throws Exception;
}
