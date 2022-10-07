package com.ecommerce.major.repository;

import com.ecommerce.major.model.user;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*;

public interface UserRepository extends JpaRepository<user,Integer> {
    Optional<user> findUserByEmail(String email);
}
