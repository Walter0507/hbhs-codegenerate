package com.hbhs.mtc.example.service;

import com.hbhs.mtc.example.domain.request.param.UserCreateParam;
import com.hbhs.mtc.example.domain.request.param.UserQueryParam;
import com.hbhs.mtc.example.domain.request.param.UserUpdateParam;
import com.hbhs.mtc.example.domain.response.info.UserInfo;
import com.hbhs.common.domain.model.paging.Pagination;
import com.hbhs.common.domain.model.response.TPageResult;

public interface IUserService {

    UserInfo createUser(UserCreateParam param);

    Boolean updateUser(UserUpdateParam param);

    Boolean deleteUser(String id);

    UserInfo findUserById(String id);

    TPageResult<UserInfo> queryUser(UserQueryParam param, Pagination pagination);
}
