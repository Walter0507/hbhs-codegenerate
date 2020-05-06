package com.hbhs.mtc.example.endpoint;

import com.hbhs.mtc.example.api.endpoint.UserEndpoint;
import com.hbhs.mtc.example.api.proxy.UserProxy;
import com.hbhs.mtc.example.domain.request.param.UserCreateParam;
import com.hbhs.mtc.example.domain.request.param.UserQueryParam;
import com.hbhs.mtc.example.domain.request.param.UserUpdateParam;
import com.hbhs.mtc.example.domain.response.info.UserInfo;
import com.hbhs.mtc.example.service.IUserService;
import com.hbhs.common.domain.model.request.GenericRequest;
import com.hbhs.common.domain.model.request.IdRequest;
import com.hbhs.common.domain.model.request.QueryRequest;
import com.hbhs.common.domain.model.response.TPageResult;
import com.hbhs.common.domain.model.response.TResultBuilder;
import com.hbhs.common.domain.model.response.TSingleResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Service(value = UserEndpoint.API_NAME)
@Slf4j
public class UserController implements UserEndpoint {
    @Autowired
    private IUserService userService;
    @Override
    public TSingleResult<UserInfo> create(GenericRequest<UserCreateParam> request) {
        return TResultBuilder.succSingle(userService.createUser(request.getParam()));
    }

    @Override
    public TSingleResult<Boolean> udpate(GenericRequest<UserUpdateParam> request) {
        return TResultBuilder.succSingle(userService.updateUser(request.getParam()));
    }

    @Override
    public TSingleResult<UserInfo> findById(IdRequest request) {
        return TResultBuilder.succSingle(userService.findUserById(request.getId()));
    }

    @Override
    public TSingleResult<Boolean> deleteById(IdRequest request) {
        return TResultBuilder.succSingle(userService.deleteUser(request.getId()));
    }

    @Override
    public TPageResult<UserInfo> queryUser(QueryRequest<UserQueryParam> request) {
        return userService.queryUser(request.getParam(), request.getPagination());
    }
}
