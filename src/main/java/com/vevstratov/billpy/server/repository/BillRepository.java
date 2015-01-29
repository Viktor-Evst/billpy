package com.vevstratov.billpy.server.repository;

import com.vevstratov.billpy.shared.domain.Bill;
import com.vevstratov.billpy.shared.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by viktor on 24.01.15.
 */
public interface BillRepository extends JpaRepository<Bill, Long> {

    List<Bill> findBillsByUser(User user);
}
