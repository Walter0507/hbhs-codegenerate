package com.hbhs.mtc.example.convertor.user;

import com.hbhs.mtc.example.domain.criteria.UserCriteria;
import com.hbhs.mtc.example.domain.request.param.UserQueryParam;
import com.hbhs.common.domain.convertor.BaseDataConverter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class UserQueryParam2CriteriaConvertor extends BaseDataConverter<UserQueryParam, UserCriteria> {
    @Override
    public UserCriteria convert(UserQueryParam param) {
        UserCriteria criteria = new UserCriteria();
        BeanUtils.copyProperties(param, criteria);
        return criteria;
    }
}
