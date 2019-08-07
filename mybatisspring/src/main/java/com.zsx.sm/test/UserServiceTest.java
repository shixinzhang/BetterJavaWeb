package com.zsx.sm.test;

import com.zsx.sm.dao.UserDao;
import com.zsx.sm.po.User;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by zhangshixin on 19/8/7.
 */
public class UserServiceTest {
    private ApplicationContext context;

    @Before
    public void setup() {
        context = new ClassPathXmlApplicationContext("classpath:spring.xml");
    }

    @Test
    public void testFindUserByName() throws Exception {
        UserDao userDao = (UserDao) context.getBean("userDao");
        User user = userDao.findUserByName("shixinzhang");
        System.out.println("查询到的信息：" + user);

        List<User> all = userDao.all();
        System.out.println("all：" + all);

        User userById = userDao.findUserById(1);
        System.out.println("根据 id 查询到的信息：" + userById);
    }
}
