package com.ecommerce.major.global;

import com.ecommerce.major.model.Products;

import java.util.ArrayList;
import java.util.List;

public class GlobalData {
    public static List<Products> cart;
    static {
        cart= new ArrayList<>();
    }
}
