package com.ecommerce.major.configuration;

import com.ecommerce.major.repository.RoleRepository;
import com.ecommerce.major.model.Role;
import com.ecommerce.major.model.user;
import com.ecommerce.major.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import org.springframework.security.oauth2.client.authentication.*;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class GoogleOAuthSuccessHandler implements AuthenticationSuccessHandler {
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    UserRepository userRepository;

    private RedirectStrategy redirectStrategy=new DefaultRedirectStrategy();
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authentication) throws IOException, ServletException {

    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        OAuth2AuthenticationToken token= (OAuth2AuthenticationToken) authentication;
        String email=token.getPrincipal().getAttributes().get("email").toString();
        if(!userRepository.findUserByEmail(email).isPresent())
        {
            user user1=new user();
            user1.setFirstname(token.getPrincipal().getAttributes().get("given_name").toString());
            user1.setLastname(token.getPrincipal().getAttributes().get("family_name").toString());
            user1.setEmail(email);
            List<Role> roles=new ArrayList<>();
            roles.add(roleRepository.findById(2).get());
            user1.setRole(roles);
            userRepository.save(user1);
        }
        redirectStrategy.sendRedirect(httpServletRequest,httpServletResponse,"/");
    }

}
