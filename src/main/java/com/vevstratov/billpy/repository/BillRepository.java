package com.vevstratov.billpy.repository;

import com.vevstratov.billpy.domain.Bill;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by viktor on 24.01.15.
 */
public interface BillRepository extends CrudRepository<Bill, Long> {
}
