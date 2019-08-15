package com.fruitsalesplatform.dao.impl;

import com.fruitsalesplatform.dao.RetailerDao;
import com.fruitsalesplatform.entity.Retailer;
import org.springframework.stereotype.Repository;

import java.util.Map;

/**
 * Created by zhangshixin on 19/8/15.
 */
@Repository
public class RetailerDaoImpl extends BaseDaoImpl<Retailer> implements RetailerDao {
    public RetailerDaoImpl() {
        setNs("com.fruitsalesplatform.mapper.RetailerMapper");
    }

    @Override
    public int count(Map map) {
        return getSqlSession().selectOne(getNs() + ".count", map);
    }
}
