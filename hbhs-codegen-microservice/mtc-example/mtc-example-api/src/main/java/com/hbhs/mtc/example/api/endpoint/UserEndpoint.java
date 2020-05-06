package com.hbhs.mtc.example.api.endpoint;

import com.hbhs.mtc.example.domain.request.param.UserCreateParam;
import com.hbhs.mtc.example.domain.request.param.UserQueryParam;
import com.hbhs.mtc.example.domain.request.param.UserUpdateParam;
import com.hbhs.mtc.example.domain.response.info.UserInfo;
import com.hbhs.common.domain.model.request.GenericRequest;
import com.hbhs.common.domain.model.request.IdRequest;
import com.hbhs.common.domain.model.request.QueryRequest;
import com.hbhs.common.domain.model.response.TPageResult;
import com.hbhs.common.domain.model.response.TSingleResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public interface UserEndpoint {
    static final String API_NAME = "UserEndpoint";
    static final String VERSION = "/endpoint/v1";

    @RequestMapping(value = VERSION+"/user/create", method = RequestMethod.POST)
    TSingleResult<UserInfo> create(@RequestBody GenericRequest<UserCreateParam> request);

    @RequestMapping(value = VERSION+"/user/update", method = RequestMethod.POST)
    TSingleResult<Boolean> udpate(@RequestBody GenericRequest<UserUpdateParam> request);

    @RequestMapping(value = VERSION+"/user/find_by_id", method = RequestMethod.POST)
    TSingleResult<UserInfo> findById(@RequestBody IdRequest request);

    @RequestMapping(value = VERSION+"/user/delete_by_id", method = RequestMethod.POST)
    TSingleResult<Boolean> deleteById(@RequestBody IdRequest request);

    @RequestMapping(value = VERSION+"/user/query", method = RequestMethod.POST)
    TPageResult<UserInfo> queryUser(@RequestBody QueryRequest<UserQueryParam> request);
}
