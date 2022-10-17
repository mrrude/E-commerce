package com.ecommerce.major.model;

import lombok.Data;
import javax.persistence.*;

@Entity
@Data
public class Category {
      @Id
      @GeneratedValue(strategy = GenerationType.AUTO)
      @Column(name= "category_id")
      private int id;

      private String name;

      public Category()
      {

      }
      public Category(String name)
      {
            this.name=name;
      }
}
