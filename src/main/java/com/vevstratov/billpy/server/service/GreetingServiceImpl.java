package com.vevstratov.billpy.server.service;

import com.vevstratov.billpy.client.GreetingService;
import org.springframework.stereotype.Service;

/**
 * Created by Viktor Evstratov on 27.01.2015.
 */
@Service("greetingService")
public class GreetingServiceImpl implements GreetingService {

    @Override
    public String greet(String name) {
        return "Hello, " + name + "!";
    }
}
