package com.vevstratov.billpy.app;

import com.vevstratov.billpy.domain.Buyer;
import com.vevstratov.billpy.repository.BuyerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

/**
 * Created by Viktor Evstratov on 23.01.2015.
 */
@Component
public class App {

    @Autowired
    BuyerRepository br;

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("META-INF/spring/config.xml");
        App app = context.getBean(App.class);

        Buyer buyer = new Buyer();
        buyer.setName("John");
        buyer.setSurname("Smith");
        System.out.println("buyer = " + buyer);
        app.br.save(buyer);
    }
}
