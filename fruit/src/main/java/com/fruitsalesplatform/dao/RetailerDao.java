package com.fruitsalesplatform.dao;

import com.fruitsalesplatform.entity.Retailer;

import java.util.Map;

/**
 * Created by zhangshixin on 19/8/15.
 */
public interface RetailerDao extends BaseDao<Retailer> {
    /**
     * 根据条件统计数量
     * @param map
     * @return
     */
    int count(Map map);
}
