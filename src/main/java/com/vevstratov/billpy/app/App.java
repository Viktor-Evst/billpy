package com.vevstratov.billpy.app;

import com.vevstratov.billpy.domain.Bill;
import com.vevstratov.billpy.domain.BillEntry;
import com.vevstratov.billpy.domain.Buyer;
import com.vevstratov.billpy.domain.Seller;
import com.vevstratov.billpy.repository.BillRepository;
import com.vevstratov.billpy.repository.BuyerRepository;
import com.vevstratov.billpy.repository.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

/**
 * Created by Viktor Evstratov on 23.01.2015.
 */
@Component
public class App {

    @Autowired
    BuyerRepository br;

    @Autowired
    SellerRepository sr;

    @Autowired
    BillRepository billr;

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("META-INF/spring/config.xml");
        App app = context.getBean(App.class);

        Buyer buyer = new Buyer();
        buyer.setName("John");
        buyer.setSurname("Smith");
        System.out.println("buyer = " + buyer);
        app.br.save(buyer);

        Seller seller = new Seller();
        seller.setName("Hasbro");
        System.out.println("seller = " + seller);
        app.sr.save(seller);

        ArrayList<BillEntry> billEntries = new ArrayList<BillEntry>() {{
            for (int i = 0; i < 10; ++i) {
                BillEntry e = new BillEntry();
                e.setText("Entry#" + i);
                e.setAmount(i);
                e.setPricePerUnit((float) (i * 100));
                add(e);
            }
        }};

        Bill bill = new Bill();
        bill.setEntries(billEntries);
        System.out.println("bill = " + bill);
        app.billr.save(bill);

        seller.addBill(bill);
        buyer.addBill(bill);
        app.sr.save(seller);
        app.br.save(buyer);
    }
}
