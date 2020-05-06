package com.hbhs.mtc.example.api.client;

import com.hbhs.mtc.example.api.endpoint.UserEndpoint;
import com.hbhs.mtc.example.api.fallback.UserClientFallback;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "mtc-example", fallback = UserClientFallback.class)
public interface UserClient extends UserEndpoint {

}
