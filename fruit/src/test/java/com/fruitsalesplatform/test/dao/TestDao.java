package com.fruitsalesplatform.test.dao;


import com.fruitsalesplatform.test.entity.User;

import java.util.List;

/**
 * Created by zhangshixin on 19/8/7.
 */
public interface TestDao {
    List<User> findUserByName(String name);
}
