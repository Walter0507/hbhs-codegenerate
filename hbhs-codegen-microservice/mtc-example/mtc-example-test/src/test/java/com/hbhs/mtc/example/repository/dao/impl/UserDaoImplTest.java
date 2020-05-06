package com.hbhs.mtc.example.repository.dao.impl;

import com.hbhs.mtc.example.repository.BaseDaoTest;
import com.hbhs.mtc.example.repository.dao.IUserDao;
import com.hbhs.mtc.example.domain.entity.UserEntity;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class UserDaoImplTest extends BaseDaoTest {

    @Autowired
    private IUserDao userDao;

    @Test
    public void testBasicFlow(){
        UserEntity entity = buildObject(System.currentTimeMillis());

        Boolean result = userDao.createUser(entity);
        Assert.assertTrue(result);

        entity = userDao.findUserById(entity.getId());
        Assert.assertNotNull(entity);

        // TODO update
        result = userDao.updateUser(entity);
        Assert.assertTrue(result);

        result = userDao.deletedUser(entity.getId());
        Assert.assertTrue(result);

        entity = userDao.findUserById(entity.getId());
        Assert.assertNull(entity);

        List<UserEntity> entityList = new ArrayList<>();
        long timestamp = System.currentTimeMillis();
        entityList.add(buildObject(timestamp++));
        entityList.add(buildObject(timestamp++));
        result = userDao.batchCreateUser(entityList);
        Assert.assertTrue(result);
    }

    private UserEntity buildObject(long timestamp){
        return UserEntity.builder()
                .id(timestamp+"")
                // TODO
                .build();
    }

}
