package com.hihar.service1.client;

import com.hihar.service1.client.fallback.factory.Service0FallbackFactory;
import com.hihar.service1.controller.Service1Controller;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Description:
 */
@FeignClient(name = "service", fallbackFactory = Service0FallbackFactory.class)
public interface Service0Client {

    @RequestMapping(method = RequestMethod.GET, path = "user/{userId}/{sleepSec}")
    String test(
            @PathVariable("userId") String userId,
            @PathVariable("sleepSec") int sleepSec
    );

    @RequestMapping(
            method = RequestMethod.GET,
            path = "test"
    )
    String user(
            Service1Controller.User user
    );

}
