package com.hbhs.mtc.example.repository.dao.impl;

import com.hbhs.mtc.example.repository.dao.IUserDao;
import com.hbhs.mtc.example.repository.dao.mapper.UserMapper;
import com.hbhs.mtc.example.domain.criteria.UserCriteria;
import com.hbhs.mtc.example.domain.entity.UserEntity;
import com.hbhs.common.datasource.route.ReadOnlyConnection;
import com.hbhs.common.domain.model.paging.Pagination;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository@Slf4j
public class UserDaoImpl implements IUserDao {

    @Autowired
    private UserMapper userMapper;

    @Override
    public Boolean createUser(UserEntity entity) {
        return userMapper.insertUser(entity);
    }

    @Override
    public Boolean batchCreateUser(List<UserEntity> entityList) {
        return userMapper.batchInsertUser(entityList);
    }

    @Override
    public Boolean updateUser(UserEntity entity) {
        return userMapper.updateUser(entity);
    }

    @Override
    public Boolean deletedUser(String id) {
        return userMapper.deleteUser(id);
    }

    @Override
    @ReadOnlyConnection
    public UserEntity findUserById(String id) {
        return userMapper.findUserById(id);
    }

    @Override
    public List<UserEntity> findUserByCriteria(UserCriteria criteria, Pagination pagination) {
        return userMapper.findUserByCriteria(criteria);
    }
}
