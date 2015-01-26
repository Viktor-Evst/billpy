package com.vevstratov.billpy.repository;

import com.vevstratov.billpy.domain.Bill;
import com.vevstratov.billpy.domain.Buyer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Viktor Evstratov on 23.01.2015.
 */
@Transactional
public interface BuyerRepository extends JpaRepository<Buyer, Long> {

    @Query("select b from Buyer b where b.id = :#{#bill.buyer.id}")
    Buyer findBuyerByBill(@Param("bill") Bill bill);
}