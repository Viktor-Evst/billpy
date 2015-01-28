package com.vevstratov.billpy.server.repository;

import com.vevstratov.billpy.shared.domain.Bill;
import com.vevstratov.billpy.shared.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Viktor Evstratov on 23.01.2015.
 */
@Transactional
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("select u from User u where u.id = :#{#bill.user.id}")
    User findUserByBill(@Param("bill") Bill bill);
}