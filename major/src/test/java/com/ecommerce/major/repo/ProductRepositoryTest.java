package com.ecommerce.major.repo;

import com.ecommerce.major.model.Category;
import com.ecommerce.major.model.Products;
import com.ecommerce.major.repository.CategoryRepository;
import com.ecommerce.major.repository.ProductRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class ProductRepositoryTest {

    @Autowired
    ProductRepository productRepository;
    @Autowired
    CategoryRepository categoryRepository;
    @Test
    public void isproductexist()
    {
        Category category=new Category("soap");
        categoryRepository.save(category);
        Products products =new Products("bar",category,8.8,10.0,"this is type of soap","img_123");
        //System.out.println(products.getId()+"wow"+ category.getId());
        //System.out.println(categoryRepository.findById(1).get().getId());
        //System.out.println("cow");
        productRepository.save(products);
        //System.out.println(products.getId());
        assertThat(productRepository.existsById(products.getId())).isTrue();
    }
    @AfterEach
    public void tearDown()
    {
        productRepository.deleteAll();
        categoryRepository.deleteAll();
    }
    @BeforeEach
    public void setUp()
    {
        //System.out.println("how");
    }
}
