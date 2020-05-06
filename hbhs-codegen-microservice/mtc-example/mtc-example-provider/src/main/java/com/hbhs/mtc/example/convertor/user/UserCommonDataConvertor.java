package com.hbhs.mtc.example.convertor.user;

import com.hbhs.mtc.example.domain.entity.UserEntity;
import com.hbhs.mtc.example.domain.request.param.UserCreateParam;
import com.hbhs.mtc.example.domain.request.param.UserUpdateParam;
import com.hbhs.mtc.example.domain.response.info.UserInfo;
import com.hbhs.common.domain.convertor.BaseCommonDataConvertor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class UserCommonDataConvertor extends BaseCommonDataConvertor<UserCreateParam , UserUpdateParam, UserInfo, UserEntity> {

    @Override
    public UserEntity createParam2Entity(UserCreateParam param){
        if (param == null){
            return null;
        }
        UserEntity entity = new UserEntity();
        BeanUtils.copyProperties(param, entity);

        return entity;
    }

    @Override
    public UserEntity updateParam2Entity(UserUpdateParam param) {
        if (param == null){
            return null;
        }
        UserEntity entity = new UserEntity();
        BeanUtils.copyProperties(param, entity);
        return entity;
    }

    @Override
    public UserInfo entity2Info(UserEntity entity) {
        if (entity == null){
            return null;
        }
        UserInfo info = new UserInfo();
        BeanUtils.copyProperties(entity, info);
        return info;
    }
}
