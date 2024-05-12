package com.dev.Splitwise.Splitwise.repository;

import com.dev.Splitwise.Splitwise.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
    User findByEmail(String email);
}
