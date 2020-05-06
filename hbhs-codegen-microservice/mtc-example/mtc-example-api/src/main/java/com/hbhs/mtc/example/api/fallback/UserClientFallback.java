package com.hbhs.mtc.example.api.fallback;

import com.hbhs.mtc.example.api.client.UserClient;
import com.hbhs.mtc.example.domain.request.param.UserCreateParam;
import com.hbhs.mtc.example.domain.request.param.UserQueryParam;
import com.hbhs.mtc.example.domain.request.param.UserUpdateParam;
import com.hbhs.mtc.example.domain.response.info.UserInfo;
import com.hbhs.common.domain.consts.ErrorCodeConsts;
import com.hbhs.common.domain.model.request.GenericRequest;
import com.hbhs.common.domain.model.request.IdRequest;
import com.hbhs.common.domain.model.request.QueryRequest;
import com.hbhs.common.domain.model.response.TPageResult;
import com.hbhs.common.domain.model.response.TResultBuilder;
import com.hbhs.common.domain.model.response.TSingleResult;
import org.springframework.stereotype.Component;

@Component
public class UserClientFallback implements UserClient {
    @Override
    public TSingleResult<UserInfo> create(GenericRequest<UserCreateParam> request) {
        return TResultBuilder.failTSingle(ErrorCodeConsts.RPC_CODE,ErrorCodeConsts.RPC_MESSAGE);
    }

    @Override
    public TSingleResult<Boolean> udpate(GenericRequest<UserUpdateParam> request) {
        return TResultBuilder.failTSingle(ErrorCodeConsts.RPC_CODE,ErrorCodeConsts.RPC_MESSAGE);
    }

    @Override
    public TSingleResult<UserInfo> findById(IdRequest request) {
        return TResultBuilder.failTSingle(ErrorCodeConsts.RPC_CODE,ErrorCodeConsts.RPC_MESSAGE);
    }

    @Override
    public TSingleResult<Boolean> deleteById(IdRequest request) {
        return TResultBuilder.failTSingle(ErrorCodeConsts.RPC_CODE,ErrorCodeConsts.RPC_MESSAGE);
    }

    @Override
    public TPageResult<UserInfo> queryUser(QueryRequest<UserQueryParam> request) {
        return TResultBuilder.failTPage(ErrorCodeConsts.RPC_CODE,ErrorCodeConsts.RPC_MESSAGE);
    }
}
