package com.nt.repositary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nt.entity.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

}
