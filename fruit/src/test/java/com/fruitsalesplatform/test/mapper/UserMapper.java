package com.fruitsalesplatform.test.mapper;

import com.fruitsalesplatform.test.entity.User;

/**
 * Created by zhangshixin on 19/8/7.
 */
public interface UserMapper {
    public User findUserByName(String name) throws Exception;
}
