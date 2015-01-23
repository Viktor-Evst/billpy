package com.vevstratov.billpy.repository;

import com.vevstratov.billpy.domain.Buyer;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Viktor Evstratov on 23.01.2015.
 */
public interface BuyerRepository extends CrudRepository<Buyer, Long> {
}