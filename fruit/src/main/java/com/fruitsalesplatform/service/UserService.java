package com.fruitsalesplatform.service;

import com.fruitsalesplatform.entity.User;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by zhangshixin on 19/8/8.
 */
public interface UserService {

    User get(Serializable id);
    List<User> find(Map map);
    void insert(User user);
    void update(User user);
    void deleteById(Serializable id);

    /**
     * 批量删除
     * @param ids 支持整型和字符串型 id
     */
    void delete(Serializable[] ids);
}
