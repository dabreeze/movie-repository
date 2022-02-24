package com.groupone.movierepobackend.data.repositories;

import com.groupone.movierepobackend.data.models.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserAccountRepository extends JpaRepository<UserAccount, Long> {
//    Optional <UserAccount> findByEmail(String email);
}
