package com.fruitsalesplatform.dao;

import com.fruitsalesplatform.entity.User;

/**
 * Created by zhangshixin on 19/8/8.
 */
public interface UserDao extends BaseDao<User> {
    boolean checkUser(String username, String password);
}
