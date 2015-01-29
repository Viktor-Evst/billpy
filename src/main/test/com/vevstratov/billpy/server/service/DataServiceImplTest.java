package com.vevstratov.billpy.server.service;

import com.vevstratov.billpy.client.DataService;
import com.vevstratov.billpy.shared.domain.Bill;
import com.vevstratov.billpy.shared.domain.BillEntry;
import com.vevstratov.billpy.shared.domain.Seller;
import com.vevstratov.billpy.shared.domain.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:/applicationContext.xml")
@Transactional
@TransactionConfiguration(defaultRollback = true)
public class DataServiceImplTest {

    @Autowired
    DataService ds;
    private final User user = new User();
    private final Seller seller = new Seller();
    private final Bill bill = new Bill();
    private ArrayList<BillEntry> billEntries;

    @Before
    public void setUp() throws Exception {
        user.setFirstname("John");
        user.setLastname("Smith");
        user.setName("john_smith");

        seller.setName("ACME");

        billEntries = new ArrayList<BillEntry>() {{
            for (int i = 0; i < 10; ++i) {
                BillEntry e = new BillEntry();
                e.setText("Entry#" + i);
                e.setAmount(i);
                e.setPricePerUnit((double) (i * 100));
                add(e);
            }
        }};
    }

    @Test
    public void testSaveBill() throws Exception {
        bill.setEntries(billEntries);
        bill.setSeller(seller);
        bill.setUser(user);

        ds.saveBill(bill);
        User userByName = ds.findUserByName(user.getName());
        System.out.println("user = " + userByName);
        System.out.println("user.getBills() = " + userByName.getBills());
        List<Bill> bills = ds.findBillsByUser(userByName);
        System.out.println("bills = " + bills);
    }
}