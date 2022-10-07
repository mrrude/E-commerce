package com.ecommerce.major.controller;

import com.ecommerce.major.global.GlobalData;
import com.ecommerce.major.service.CategoryService;
import com.ecommerce.major.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class HomeController {
    @Autowired
    ProductService productService;
    @Autowired
    CategoryService categoryService;
    @GetMapping({"/","/home"})
    public String  shop(Model model)
    {
        //System.out.println("pp");
        return "index";
    }
    @GetMapping("/shop")
    public String shopCategoryandproduct(Model model)
    {
        //System.out.println("nn");
        model.addAttribute("categories",categoryService.getALlCategory());
        model.addAttribute("products",productService.getproduct());
        model.addAttribute("cartCount", GlobalData.cart.size());
        return "shop";
    }
    @GetMapping("/shop/category/{id}")
    public String productbyCategory(Model model, @PathVariable("id") int id)
    {
        model.addAttribute("categories",categoryService.getALlCategory());
        model.addAttribute("cartCount",GlobalData.cart.size());
        model.addAttribute("products",productService.getproductsbyCatid(id));
        return "shop";
    }
    @GetMapping("/shop/viewproduct/{id}")
    public String viewproduct(Model model, @PathVariable("id") int id)
    {
        if(productService.getproductbyid(id).isPresent())
        {
            //System.out.println("now");
            //System.out.println(productService.getproductbyid(id).get().getImageName());
            model.addAttribute("product",productService.getproductbyid(id).get());
        }
        else
        {
            System.out.println("pow");
        }
        return "viewProduct";
    }
}
