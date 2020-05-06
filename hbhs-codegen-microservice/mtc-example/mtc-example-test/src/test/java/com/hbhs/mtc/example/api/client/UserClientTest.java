package com.hbhs.mtc.example.api.client;

import com.hbhs.mtc.example.api.BaseClientTest;
import com.hbhs.mtc.example.domain.request.param.UserCreateParam;
import com.hbhs.mtc.example.domain.request.param.UserUpdateParam;
import com.hbhs.mtc.example.domain.response.info.UserInfo;
import com.hbhs.common.domain.model.request.GenericRequest;
import com.hbhs.common.domain.model.request.IdRequest;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class UserClientTest extends BaseClientTest {

    @Autowired
    private UserClient userClient;

    @Test
    public void testBasicFlow() {
        UserCreateParam param = UserCreateParam.builder()
                // TODO
                .build();
        GenericRequest<UserCreateParam> createRequest = new GenericRequest<>();
        createRequest.setParam(param);
        UserInfo info = userClient.create(createRequest).getData();
        Assert.assertNotNull(info);

        UserUpdateParam updateParam = UserUpdateParam.builder()
                .id(info.getId())
                // TODO
                .build();
        GenericRequest<UserUpdateParam> updateRequest = new GenericRequest<>();
        updateRequest.setParam(updateParam);
        Boolean result = userClient.udpate(updateRequest).getData();
        Assert.assertTrue(result);

        info = userClient.findById(IdRequest.builder().id(info.getId()).build())
                .getData();
        Assert.assertNotNull(info);

        IdRequest deleteRequest = new IdRequest();
        deleteRequest.setId(info.getId());
        result = userClient.deleteById(deleteRequest).getData();
        Assert.assertTrue(result);

        info = userClient.findById(IdRequest.builder().id(info.getId()).build())
                .getData();
        Assert.assertNull(info);
    }
}
