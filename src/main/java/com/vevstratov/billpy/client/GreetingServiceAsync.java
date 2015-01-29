package com.vevstratov.billpy.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface GreetingServiceAsync {
    void greet(String name, AsyncCallback<String> async);
}
