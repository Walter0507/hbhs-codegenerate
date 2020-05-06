package com.hbhs.mtc.example.api.proxy;

import com.hbhs.mtc.example.api.client.UserClient;
import com.hbhs.mtc.example.api.endpoint.UserEndpoint;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserProxy {
    @Autowired(required = false)
    @Qualifier(value = UserEndpoint.API_NAME)
    private UserEndpoint userEndpoint;

    @Autowired(required = false)
    private UserClient userClient;

    public UserEndpoint getUserEndpoint(){
        return userEndpoint!=null?userEndpoint:userClient;
    }

}
