package com.ecommerce.major.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.*;
@Entity
@Data
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotEmpty
    @Column(nullable = false,unique = true)
    private String name;

    @ManyToMany(mappedBy = "role")
    List<user> user2;

    public Role(int id,String name,List<user> u)
    {
        this.id=id;
        this.name=name;
        this.user2=u;
    }
    public Role ()
    {

    }
}
