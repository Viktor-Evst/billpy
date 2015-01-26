package com.vevstratov.billpy.repository;

import com.vevstratov.billpy.domain.Bill;
import com.vevstratov.billpy.domain.Buyer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by viktor on 24.01.15.
 */
public interface BillRepository extends JpaRepository<Bill, Long> {
    List<Bill> findBillsByBuyer(Buyer buyer);
}
