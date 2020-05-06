package com.hbhs.mtc.example.repository.dao;

import com.hbhs.mtc.example.domain.criteria.UserCriteria;
import com.hbhs.mtc.example.domain.entity.UserEntity;
import com.hbhs.common.domain.model.paging.Pagination;

import java.util.List;

public interface IUserDao {

    Boolean createUser(UserEntity entity);

    Boolean batchCreateUser(List<UserEntity> entityList);

    Boolean updateUser(UserEntity entity);

    Boolean deletedUser(String id);

    UserEntity findUserById(String id);

    List<UserEntity> findUserByCriteria(UserCriteria criteria, Pagination pagination);
}
