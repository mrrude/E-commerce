package com.ecommerce.major.service;

import com.ecommerce.major.repository.ProductRepository;
import com.ecommerce.major.model.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductService {
       @Autowired
       private ProductRepository productRepository;

       public List<Products> getproduct()
       {
           return productRepository.findAll();
       }
       public void addproduct(Products products)
       {
              productRepository.save(products);
       }
       public void deleteproduct(int id){
              //System.out.println("neet");
              productRepository.deleteById(id); }
       public Optional<Products> getproductbyid(int id){ return productRepository.findById(id);}

       public List<Products> getproductsbyCatid(int id){
              return productRepository.findALlByCategory_id(id);
       }
}
