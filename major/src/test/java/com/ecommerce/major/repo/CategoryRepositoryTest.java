package com.ecommerce.major.repo;

import com.ecommerce.major.model.Category;
import com.ecommerce.major.repository.CategoryRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class CategoryRepositoryTest {

    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    public void isCategoryexist()
    {
        Category category=new Category("soap");
        categoryRepository.save(category);
        assertThat(categoryRepository.existsById(category.getId())).isTrue();
    }
    @AfterEach
    void tearDown()
    {
        categoryRepository.deleteAll();
    }
    @BeforeEach
    void setUp()
    {

    }
}
