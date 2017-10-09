package com.mailMis.base.dao;

import com.mailMis.bean.User;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by ArnoldLee on 17/10/1.
 */
public class BaseDaoImpl {

    @PersistenceContext
    EntityManager manager;

    @Resource
    BaseDao baseDao;


    public boolean updateUser(User user){
        manager.merge(user);
        return true;
    }
}
