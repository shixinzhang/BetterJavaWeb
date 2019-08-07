package com.fruitsalesplatform.dao.impl;

import com.fruitsalesplatform.dao.UserDao;
import com.fruitsalesplatform.entity.User;
import org.springframework.stereotype.Repository;

/**
 * Created by zhangshixin on 19/8/8.
 */
@Repository
public class UserDaoImpl extends BaseDaoImpl<User> implements UserDao {
    public UserDaoImpl() {
        setNs("com.fruitsalesplatform.mapper.UserMapper");
    }

    @Override
    public boolean checkUser(String username, String password) {

        return false;
    }
}
