package com.vevstratov.billpy.repository;

import com.vevstratov.billpy.domain.Seller;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Viktor Evstratov on 24.01.15.
 */
public interface SellerRepository extends JpaRepository<Seller, Long> {
}
