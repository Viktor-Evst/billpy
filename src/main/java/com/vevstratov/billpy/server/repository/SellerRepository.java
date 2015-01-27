package com.vevstratov.billpy.server.repository;

import com.vevstratov.billpy.shared.domain.Bill;
import com.vevstratov.billpy.shared.domain.Seller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Created by Viktor Evstratov on 24.01.15.
 */
public interface SellerRepository extends JpaRepository<Seller, Long> {

    @Query("select s from Seller s where s.id = :#{#bill.seller.id}")
    Seller getSellerByBill(@Param("bill") Bill bill);
}
