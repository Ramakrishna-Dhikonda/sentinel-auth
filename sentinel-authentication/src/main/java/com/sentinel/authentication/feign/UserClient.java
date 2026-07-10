package com.sentinel.authentication.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
        name = "sentinel-identity",
        url = "${sentinel.identity.service.url}"
)
public interface UserClient {

    @GetMapping("/internal/users/{userId}/exists")
    boolean checkUserExistence(@PathVariable String userId);

    @GetMapping("/internal/email/{email}/exists")
    boolean isEmailAlreadyUsed(@PathVariable String email);

}