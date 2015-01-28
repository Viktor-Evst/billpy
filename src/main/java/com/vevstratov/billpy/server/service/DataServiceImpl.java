package com.vevstratov.billpy.server.service;

import com.vevstratov.billpy.client.DataService;
import com.vevstratov.billpy.server.repository.BillRepository;
import com.vevstratov.billpy.server.repository.BuyerRepository;
import com.vevstratov.billpy.server.repository.SellerRepository;
import com.vevstratov.billpy.shared.domain.Bill;
import com.vevstratov.billpy.shared.domain.Buyer;
import com.vevstratov.billpy.shared.domain.Seller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Viktor Evstratov on 28.01.2015.
 */
@Transactional
@Service("dataService")
public class DataServiceImpl implements DataService {

    @Autowired
    BuyerRepository br;

    @Autowired
    SellerRepository sr;

    @Autowired
    BillRepository billr;

    @Override
    public void saveBill(Bill bill) {
//        Seller seller = bill.getSeller();
//        Buyer buyer = bill.getBuyer();
//        seller = saveIfNotExistsSeller(seller);
//        buyer = saveIfNotExistsBuyer(buyer);
    }

}
