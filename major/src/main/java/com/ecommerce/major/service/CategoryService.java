package com.ecommerce.major.service;

import com.ecommerce.major.model.Category;
import com.ecommerce.major.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
     @Autowired
     CategoryRepository categoryRepository;

     public CategoryService(CategoryRepository categoryRepository) {
          this.categoryRepository=categoryRepository;
     }

     public List<Category> getALlCategory()
     {
          return categoryRepository.findAll();
     }
     public Category addCategory (Category category)
     {
         categoryRepository.save(category);
         return category;
     }
     public void deletedCategory(int id){ categoryRepository.deleteById(id); }
     public Optional<Category> sendCat(int id){ return categoryRepository.findById(id); }
}
