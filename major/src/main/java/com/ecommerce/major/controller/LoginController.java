package com.ecommerce.major.controller;

import com.ecommerce.major.repository.RoleRepository;
import com.ecommerce.major.repository.UserRepository;
import com.ecommerce.major.model.Role;
import com.ecommerce.major.model.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class LoginController {
        @Autowired
        private UserRepository userRepository;
        @Autowired
        private RoleRepository roleRepository;
        @Autowired
        private BCryptPasswordEncoder bCryptPasswordEncoder;
        @GetMapping("/login")
        public String Login()
        {
            return "login";
        }
        @GetMapping("/register")
        public String Register()
        {
            return "register";
        }
        @PostMapping("/register")
        public String PostRegister(@ModelAttribute("user") user user1, HttpServletRequest httpRequest)throws ServletException
        {
             //System.out.println(user1.getFirstname());
             user1.setPassword(bCryptPasswordEncoder.encode(user1.getPassword()));
             List<Role> roles=new ArrayList<>();
             roles.add(roleRepository.findById(2).get());
             user1.setRole(roles);
             userRepository.save(user1);
             //System.out.println("cow");
             httpRequest.login(user1.getEmail(),user1.getPassword());
             //System.out.println("wow");
             return "redirect:/home";
        }
}
