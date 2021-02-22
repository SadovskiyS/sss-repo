package com.sergsergio.pizza_test.repository;

import com.sergsergio.pizza_test.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<User, Long> {

}
