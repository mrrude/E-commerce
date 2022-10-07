package com.ecommerce.major.model;

import lombok.Data;

import javax.persistence.*;


@Data
@Entity
public class Products {
    @Id
    @GeneratedValue(strategy =GenerationType.AUTO)
    private int id;
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="category_id",referencedColumnName ="category_id")
    private Category category;
    private double price;
    private double weight;
    private String description;
    private String imageName;


}