package com.zsx.sm.test;

import com.zsx.sm.mapper.UserQueryMapper;
import com.zsx.sm.po.User;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by zhangshixin on 19/8/7.
 */
public class UserMapperTest {
    private ApplicationContext context;

    @Before
    public void setup() {
        context = new ClassPathXmlApplicationContext("classpath:spring.xml");
    }

    @Test
    public void testMapper() throws Exception {
        UserQueryMapper queryMapper = (UserQueryMapper) context.getBean("userQueryMapper");
//        List<User> all = queryMapper.all();
//        System.out.println("all:" + all);

        User userById = queryMapper.findUserById(1);
        System.out.println("userById: " + userById);

    }
}
