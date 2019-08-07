package com.fruitsalesplatform.test.service.impl;

import com.fruitsalesplatform.test.dao.TestDao;
import com.fruitsalesplatform.test.entity.User;
import com.fruitsalesplatform.test.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zhangshixin on 19/8/7.
 */
//为了包扫描的时候这个 dao 被扫描到
@Service
public class TestServiceImpl implements TestService{
    @Autowired
    private TestDao testDao;

    @Override
    public List<User> findUserByName(String name) {
        return testDao.findUserByName(name);
    }
}
