package com.ecommerce.major.controller;

import com.ecommerce.major.global.GlobalData;
import com.ecommerce.major.model.Products;
import com.ecommerce.major.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class CartController {
     @Autowired
    ProductService productService;
     @GetMapping("/addToCart/{id}")
     public String addtoCart(@PathVariable int id)
     {
         GlobalData.cart.add(productService.getproductbyid(id).get());
         return "redirect:/shop";
     }
     @GetMapping("/cart")
     public String  getCart(Model model)
     {
         model.addAttribute("cartCount",GlobalData.cart.size());
         model.addAttribute("total",GlobalData.cart.stream().mapToDouble(Products::getPrice).sum());
         model.addAttribute("cart",GlobalData.cart);
         return "cart";
     }
    @GetMapping("cart/removeItem/{index}")
    public String removeItem(@PathVariable int index)
    {
        GlobalData.cart.remove(index);
        return "redirect:/cart";
    }
    @GetMapping("/checkout")
    public String Checkout(Model model)
    {
        model.addAttribute("total",GlobalData.cart.stream().mapToDouble(Products::getPrice).sum());
        return "checkout";
    }
}
