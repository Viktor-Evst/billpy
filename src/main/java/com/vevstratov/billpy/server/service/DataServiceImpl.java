package com.vevstratov.billpy.server.service;

import com.vevstratov.billpy.client.DataService;
import com.vevstratov.billpy.server.repository.BillRepository;
import com.vevstratov.billpy.server.repository.SellerRepository;
import com.vevstratov.billpy.server.repository.UserRepository;
import com.vevstratov.billpy.shared.domain.Bill;
import com.vevstratov.billpy.shared.domain.Seller;
import com.vevstratov.billpy.shared.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Viktor Evstratov on 28.01.2015.
 */
@Transactional
@Service("dataService")
public class DataServiceImpl implements DataService {

    @Autowired
    UserRepository ur;

    @Autowired
    SellerRepository sr;

    @Autowired
    BillRepository br;

    @Override
    public void saveBill(Bill bill) {
        Seller seller = bill.getSeller();
        User user = bill.getUser();
        seller.addBill(bill);
        user.addBill(bill);
        ur.save(user);
    }

    @Override
    public List<Bill> findBillsByUser(User user) {
        return br.findBillsByUser(user);
    }

    @Override
    public User findUserByName(String name) {
        return ur.findUserByName(name);
    }
}
