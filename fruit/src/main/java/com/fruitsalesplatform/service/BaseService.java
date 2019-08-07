package com.fruitsalesplatform.service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by zhangshixin on 19/8/8.
 */
public interface BaseService<T> {

    T get(Serializable id);
    List<T> find(Map map);
    void insert(T t);
    void update(T t);
    void deleteById(Serializable id);

    /**
     * 批量删除
     * @param ids 支持整型和字符串型 id
     */
    void delete(Serializable[] ids);
}
