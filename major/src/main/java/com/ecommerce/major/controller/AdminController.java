package com.ecommerce.major.controller;

import com.ecommerce.major.dto.ProductDTO;
import com.ecommerce.major.model.Category;
import com.ecommerce.major.model.Products;
import com.ecommerce.major.service.CategoryService;
import com.ecommerce.major.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

@Controller
public class AdminController {
    public static String UploadDir=System.getProperty("user.dir")+"/src/main/resources/static/productImages";
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private ProductService productService;
    @GetMapping("/admin")
    public String adminHome()
    {
        return "adminHome";
    }
    // Category Section......
    @GetMapping("/admin/categories")
    public String getcategories(Model model)
    {
        model.addAttribute("categories",categoryService.getALlCategory());
        return "categories";
    }
    @GetMapping("/admin/categories/add")
    public String getCat(Model model)
    {
        model.addAttribute("category",new Category());
        return "categoriesAdd";
    }
    @PostMapping("/admin/categories/add")
    public String postCat(@ModelAttribute("category") Category category) {
        categoryService.addCategory(category);
        return "redirect:/admin/categories";
    }
    @GetMapping("/admin/categories/delete/{id}")
    public String deletecat(@PathVariable int id)
    {
        categoryService.deletedCategory(id);
        return "redirect:/admin/categories";
    }
    @GetMapping("/admin/categories/update/{id}")
    public String updateCat(@PathVariable int id,Model model)
    {
        Optional<Category> op=categoryService.sendCat(id);
        if(op.isPresent())
        {
            model.addAttribute("category",op.get());
            return "categoriesAdd";
        }
        else {
            return "404";
        }
    }
    // products section.....
    @GetMapping("/admin/products")
    public String product(Model model)
    {
        model.addAttribute("products",productService.getproduct());
        return "products";
    }
    @GetMapping("/admin/products/add")
    public String productadd(Model model)
    {
        //return "productsAdd";
        model.addAttribute("productDTO",new ProductDTO());
        model.addAttribute("categories",categoryService.getALlCategory());
        return "productsAdd";
    }
    @PostMapping("/admin/products/add")
    public String postproduct(@ModelAttribute("productDTO") ProductDTO products, @RequestParam("productImage")MultipartFile file, @RequestParam("imgName")String imgname) throws IOException
    {
        Products product=new Products();
        product.setCategory(categoryService.sendCat(products.getCategoryId()).get());
        product.setId(products.getId());
        product.setName(products.getName());
        product.setPrice(products.getPrice());
        product.setWeight(products.getWeight());
        product.setDescription(products.getDescription());
        String imgnme;
        if(!file.isEmpty())
        {
            imgnme=file.getOriginalFilename();
            Path filenamespacepath= Paths.get(UploadDir,imgnme);
            Files.write(filenamespacepath,file.getBytes());
            System.out.println("now"+imgnme);
        }
        else {
            imgnme=imgname;
            System.out.println("wow"+imgnme);
        }
        product.setImageName(imgnme);
        productService.addproduct(product);
        return "redirect:/admin/products";
    }
    @GetMapping("/admin/product/update/{id}")
    public String  updateProduct(@PathVariable int id,Model model)
    {
         Optional<Products> p=productService.getproductbyid(id);

         ProductDTO productDTO=new ProductDTO();
         if(p.isPresent())
         {
             //System.out.println("wow");
             Products pp=p.get();
             productDTO.setId(pp.getId());
             productDTO.setCategoryId(pp.getCategory().getId());
             productDTO.setPrice(pp.getPrice());
             productDTO.setDescription(pp.getDescription());
             productDTO.setWeight(pp.getWeight());
             productDTO.setImageName(pp.getImageName());
             model.addAttribute("productDTO",productDTO);
             model.addAttribute("categories",categoryService.getALlCategory());
             //System.out.println("pow");
             return "productsAdd";
         }
         else {
             return "404";
         }
    }
    @GetMapping("/admin/product/delete/{id}")
    public String deleteproductcont(@PathVariable int id)
    {
        productService.deleteproduct(id);
        //System.out.println(id);
        //System.out.println("now");
        return "redirect:/admin/products";
    }
}
