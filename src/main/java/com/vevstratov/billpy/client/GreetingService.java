package com.vevstratov.billpy.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * Created by Viktor Evstratov on 27.01.2015.
 */
@RemoteServiceRelativePath("springGwtServices/greetingService")
public interface GreetingService extends RemoteService {
    String greet(String name);
}
