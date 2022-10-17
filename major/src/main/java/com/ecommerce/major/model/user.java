package com.ecommerce.major.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.*;

@Data
@Entity
public class user {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;

    @NotEmpty
    @Column(nullable = false)
    private String firstname;
    private String lastname;

    @Column(nullable = false,unique = true)
    @NotEmpty
    @Email(message="{error.invalid.email}")
    private String email;

    private String password;

    @ManyToMany(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
    @JoinTable(
            name="user_role",
            joinColumns={@JoinColumn(name="USER_ID",referencedColumnName = "ID")},
            inverseJoinColumns ={@JoinColumn(name="ROLE_ID",referencedColumnName = "ID")}
    )
    private List<Role> role;

    public user(user user1)
    {
         this.firstname=user1.getFirstname();
         this.lastname=user1.getLastname();
         this.email=user1.getEmail();
         this.password=user1.getPassword();
         this.role=user1.getRole();
    }
    public user(String firstname,String email,List<Role>role)
    {
        this.firstname=firstname;
        this.email=email;
        this.role=role;
    }
    public user()
    {

    }
}
