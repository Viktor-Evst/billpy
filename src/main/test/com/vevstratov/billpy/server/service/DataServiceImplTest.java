package com.vevstratov.billpy.server.service;

import com.vevstratov.billpy.client.DataService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath*:../webapp/WEB-INF/applicationContext.xml"})
@Transactional
@TransactionConfiguration(defaultRollback = true)
public class DataServiceImplTest {

    @Autowired
    DataService ds;

    @Test
    public void testSaveBill() throws Exception {

    }
}