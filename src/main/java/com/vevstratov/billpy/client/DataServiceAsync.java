package com.vevstratov.billpy.client;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.vevstratov.billpy.shared.domain.Bill;

public interface DataServiceAsync {
    void saveBill(Bill bill, AsyncCallback<Void> async);
}
