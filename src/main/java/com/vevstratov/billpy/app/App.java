package com.vevstratov.billpy.app;

import com.vevstratov.billpy.shared.domain.Bill;
import com.vevstratov.billpy.shared.domain.BillEntry;
import com.vevstratov.billpy.shared.domain.User;
import com.vevstratov.billpy.shared.domain.Seller;
import com.vevstratov.billpy.server.repository.BillRepository;
import com.vevstratov.billpy.server.repository.UserRepository;
import com.vevstratov.billpy.server.repository.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Viktor Evstratov on 23.01.2015.
 */
@Component("mainApplication")
public class App {

    @Autowired
    UserRepository br;

    @Autowired
    SellerRepository sr;

    @Autowired
    BillRepository billr;

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:*applicationContext.xml");
        System.out.println("context.getBeanDefinitionNames() = " + Arrays.toString(context.getBeanDefinitionNames()));
        App app = (App) context.getBean("mainApplication");

        User user = new User();
        user.setFirstname("John");
        user.setLastname("Smith");

        User user2 = new User();
        user2.setFirstname("John");
        user2.setLastname("Smith II");

        Seller seller = new Seller();
        seller.setName("Hasbro");

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
        user2 = app.br.save(user2);
        user = app.br.save(user);
        user = app.br.findOne(user.getId());

        User userByBill = app.br.findUserByBill(bill);
        System.out.println("buyerByBill = " + userByBill);
        List<Bill> billsByBuyer = app.billr.findBillsByUser(userByBill);
        System.out.println("billsByBuyer = " + billsByBuyer);
        System.out.println("bill.getTotal() = " + bill.getTotal());
        System.out.println("app.sr.getSellerByBill(bill) = " + app.sr.getSellerByBill(bill));
    }
}
