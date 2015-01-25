package com.vevstratov.billpy.repository;

import com.vevstratov.billpy.domain.Bill;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by viktor on 24.01.15.
 */
public interface BillRepository extends JpaRepository<Bill, Long> {
}
