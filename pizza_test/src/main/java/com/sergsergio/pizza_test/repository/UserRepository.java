package com.sergsergio.pizza_test.repository;

import com.sergsergio.pizza_test.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String name);
}
