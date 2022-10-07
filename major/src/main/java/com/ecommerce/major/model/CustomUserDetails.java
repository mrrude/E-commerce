package com.ecommerce.major.model;

import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

public class CustomUserDetails extends user implements UserDetails {
    public CustomUserDetails(user user1)
    {
        super(user1);
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority>authorityList= new ArrayList<>() ;
        super.getRole().forEach(role->{
            authorityList.add(new SimpleGrantedAuthority(role.getName()));
        } );
        return authorityList;
    }

    @Override
    public String getUsername() {
        return super.getEmail();
    }
    @Override
    public String getPassword() {
        return super.getPassword();
    }
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
