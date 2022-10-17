package com.ecommerce.major.Service;

import com.ecommerce.major.model.Category;
import com.ecommerce.major.model.Products;
import com.ecommerce.major.repository.ProductRepository;
import com.ecommerce.major.service.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
public class PrioductServiceTest {

    @MockBean
    private ProductRepository productRepository;

    private ProductService productService;

    @Test
    public void getproductTest()
    {
        when(productRepository.findAll()).thenReturn(Stream.of(new Products("chocolate cake",new Category("blueberry"),10,100,"made with love","12223_img1"),new Products("simple cake",new Category("marshmellow"),15,100,"made with love","12223_img1")).collect(Collectors.toList()));
        assertEquals(2,productService.getproduct().size());
    }
    @Test
    public void addProductTest()
    {
        Products products=new Products("chocolate cake",new Category("blueberry"),10,100,"made with love","12223_img1");
        when(productRepository.save(products)).thenReturn(products);
        assertEquals(products,productService.addproduct(products));
    }
    @Test
    public void deleteproductTest()
    {
        Products products=new Products("chocolate cake",new Category("blueberry"),10,100,"made with love","12223_img1");
        productService.deleteproduct(1);
        verify(productRepository).deleteById(1);
    }
    @Test
    public void getproductbyidTest()
    {
        Optional<Products> products= Optional.of(new Products("chocolate cake",new Category("blueberry"),10,100,"made with love","12223_img1"));
        //Products products=new Products("chocolate cake",new Category("blueberry"),10,100,"made with love","12223_img1");
        when(productRepository.findById(1)).thenReturn(products);
        assertEquals(products.get(),productService.getproductbyid(1).get());
    }
    @Test
    public void getproductsbyCatidTest()
    {
        when(productRepository.findAll()).thenReturn(Stream.of(new Products("chocolate cake",new Category("blueberry"),10,100,"made with love","12223_img1"),new Products("simple cake",new Category("marshmellow"),15,100,"made with love","12223_img1")).collect(Collectors.toList()));
        assertEquals(2,productService.getproduct().size());
    }
}
