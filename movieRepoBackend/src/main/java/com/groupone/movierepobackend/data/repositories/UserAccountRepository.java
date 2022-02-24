package com.groupone.movierepobackend.data.repositories;

import com.groupone.movierepobackend.data.models.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAccountRepository extends JpaRepository<UserAccount, Long> {
}
