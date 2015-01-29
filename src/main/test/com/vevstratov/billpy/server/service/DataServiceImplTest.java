package com.vevstratov.billpy.server.service;

import com.vevstratov.billpy.client.DataService;
import com.vevstratov.billpy.shared.domain.Bill;
import com.vevstratov.billpy.shared.domain.BillEntry;
import com.vevstratov.billpy.shared.domain.Seller;
import com.vevstratov.billpy.shared.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:/applicationContext.xml")
@Transactional
@TransactionConfiguration(defaultRollback = true)
public class DataServiceImplTest {

    @Autowired
    DataService ds;

    @Test
    public void testSaveBill() throws Exception {
        User user = new User();
        user.setFirstname("John");
        user.setLastname("Smith");
        user.setName("john_smith");

        Seller seller = new Seller();
        seller.setName("ACME");

        ArrayList<BillEntry> billEntries = new ArrayList<BillEntry>() {{
            for (int i = 0; i < 10; ++i) {
                BillEntry e = new BillEntry();
                e.setText("Entry#" + i);
                e.setAmount(i);
                e.setPricePerUnit((double) (i * 100));
                add(e);
            }
        }};
        final Bill bill = new Bill();
        bill.setEntries(billEntries);
        bill.setSeller(seller);
        bill.setUser(user);
        seller.addBill(bill);
        user.addBill(bill);

        ds.saveBill(bill);
        user = ds.findUserByName(user.getName());
        System.out.println("user = " + user);
//        List<Bill> bills = ds.findBillsByUser(user);
    }
}