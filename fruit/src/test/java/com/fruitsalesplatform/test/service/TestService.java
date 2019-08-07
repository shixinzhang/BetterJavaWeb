package com.fruitsalesplatform.test.service;


import com.fruitsalesplatform.test.entity.User;

import java.util.List;

/**
 * Created by zhangshixin on 19/8/7.
 */
public interface TestService {
    List<User> findUserByName(String name);
}
