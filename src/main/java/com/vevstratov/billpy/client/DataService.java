package com.vevstratov.billpy.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import com.vevstratov.billpy.shared.domain.Bill;

/**
 * Created by Viktor Evstratov on 28.01.2015.
 */

@RemoteServiceRelativePath("springGwtServices/dataService")
public interface DataService extends RemoteService {

    void saveBill(Bill bill);
}
