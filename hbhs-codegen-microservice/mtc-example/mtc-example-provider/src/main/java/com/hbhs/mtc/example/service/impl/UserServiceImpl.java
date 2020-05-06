package com.hbhs.mtc.example.service.impl;

import com.hbhs.mtc.example.convertor.user.UserCommonDataConvertor;
import com.hbhs.mtc.example.convertor.user.UserQueryParam2CriteriaConvertor;
import com.hbhs.mtc.example.repository.dao.IUserDao;
import com.hbhs.mtc.example.domain.criteria.UserCriteria;
import com.hbhs.mtc.example.domain.entity.UserEntity;
import com.hbhs.mtc.example.domain.request.param.UserCreateParam;
import com.hbhs.mtc.example.domain.request.param.UserQueryParam;
import com.hbhs.mtc.example.domain.request.param.UserUpdateParam;
import com.hbhs.mtc.example.domain.response.info.UserInfo;
import com.hbhs.mtc.example.service.IUserService;
import com.hbhs.common.domain.model.paging.Pagination;
import com.hbhs.common.domain.model.response.TPageResult;
import com.hbhs.common.domain.model.response.TResultBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class UserServiceImpl implements IUserService {
    @Autowired
    private IUserDao userDao;
    @Autowired
    private UserCommonDataConvertor commonDataConvertor;
    @Autowired
    private UserQueryParam2CriteriaConvertor criteriaConvertor;

    @Override
    public UserInfo createUser(UserCreateParam param) {
        UserEntity entity = commonDataConvertor.createParam2Entity(param);
        entity.setId(System.currentTimeMillis()+"");
        Boolean result = userDao.createUser(entity);
        return result!=null&&result?commonDataConvertor.entity2Info(entity):null;
    }

    @Override
    public Boolean updateUser(UserUpdateParam param) {
        UserEntity entity = commonDataConvertor.updateParam2Entity(param);
        return userDao.updateUser(entity);
    }

    @Override
    public Boolean deleteUser(String id) {
        return userDao.deletedUser(id);
    }

    @Override
    public UserInfo findUserById(String id) {
        UserEntity entity = userDao.findUserById(id);
        return commonDataConvertor.entity2Info(entity);
    }

    @Override
    public TPageResult<UserInfo> queryUser(UserQueryParam param, Pagination pagination) {
        UserCriteria criteria = criteriaConvertor.convert(param);

        List<UserEntity> entityList = userDao.findUserByCriteria(criteria, pagination);

        List<UserInfo> infoList = commonDataConvertor.entityList2Info(entityList);
        TPageResult<UserInfo> result = TResultBuilder.succPageResult(UserInfo.class, pagination);
        result.setData(infoList);
        return result;
    }
}
