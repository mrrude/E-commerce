package com.ecommerce.major.Service;

import com.ecommerce.major.model.Category;
import com.ecommerce.major.repository.CategoryRepository;
import com.ecommerce.major.service.CategoryService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class CateogoryServiceTest {
    @MockBean
    private CategoryRepository categoryRepository;


    private CategoryService categoryService;

    @BeforeEach
    public void  setUp()
    {
        this.categoryService=new CategoryService(this.categoryRepository);
    }

    @Test
    public void getallcategoryTest()
    {
        categoryService.getALlCategory();
        verify(categoryRepository).findAll();
    }

    @Test
    public void getAllCategoryTest()
    {
        when(categoryRepository.findAll()).thenReturn(Stream.of(new Category("chips"),new Category("biscuit")).collect(Collectors.toList()));
        assertEquals(2,categoryService.getALlCategory().size());
    }
    @Test
    public void addCategoryTest()
    {
        Category category=new Category("Bluberry");
        when(categoryRepository.save(category)).thenReturn(category);
        assertEquals(category,categoryService.addCategory(category));
    }
    @Test
    public void sendCatTest()
    {
        Optional<Category> category= Optional.of(new Category("Bluberry"));
        when(categoryRepository.findById(1)).thenReturn(category);
        assertEquals(category.get(),categoryService.sendCat(1).get());
    }
    @Test
    public void deletedCategoryTest(int id)
    {
        Category category=new Category("pineapple");
        categoryService.deletedCategory(1);
        verify(categoryRepository).deleteById(1);

    }
}
