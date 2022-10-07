package com.ecommerce.major.repository;

import com.ecommerce.major.model.Products;
import org.hibernate.secure.internal.JaccSecurityListener;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*;
public interface ProductRepository extends JpaRepository<Products,Integer> {
         List<Products> findALlByCategory_id(int id);
}
