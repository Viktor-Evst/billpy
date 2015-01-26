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
import java.util.List;

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

        Buyer buyer2 = new Buyer();
        buyer2.setName("John");
        buyer2.setSurname("Smith II");

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
        bill.setBuyer(buyer);
        seller.addBill(bill);
        buyer.addBill(bill);
        buyer2 = app.br.save(buyer2);
        buyer = app.br.save(buyer);
        buyer = app.br.findOne(buyer.getId());

        Buyer buyerByBill = app.br.findBuyerByBill(bill);
        System.out.println("buyerByBill = " + buyerByBill);
        List<Bill> billsByBuyer = app.billr.findBillsByBuyer(buyerByBill);
        System.out.println("billsByBuyer = " + billsByBuyer);
        System.out.println("bill.getTotal() = " + bill.getTotal());
    }
}
