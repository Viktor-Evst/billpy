package com.vevstratov.billpy.client;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.vevstratov.billpy.shared.domain.Bill;
import com.vevstratov.billpy.shared.domain.User;

import java.util.List;

public interface DataServiceAsync {
    void saveBill(Bill bill, AsyncCallback<Void> async);

    void findBillsByUser(User user, AsyncCallback<List<Bill>> async);

    void findUserByName(String login, AsyncCallback<User> async);
}
