package com.ecommerce.major.repo;

import com.ecommerce.major.model.Role;
import com.ecommerce.major.model.user;
import com.ecommerce.major.repository.RoleRepository;
import com.ecommerce.major.repository.UserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Test
    void isuserexistbyid()
    {
        List<Role> r=new ArrayList<>();
        r.add(roleRepository.findById(2).get());
        user user1=new user("vaibhav","test@gmail.com",r);
        userRepository.save(user1);
        assertThat(userRepository.existsById(user1.getId())).isTrue();
    }
    @AfterEach
    void tearDown()
    {

    }
    @BeforeEach
    void setUp()
    {

    }
}
