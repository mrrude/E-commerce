package com.ecommerce.major.dto;

//import com.sheryians.major.model.Category;
import lombok.Data;


@Data
public class ProductDTO {
    private int id;
    private String name;
    private int categoryId;
    private double price;
    private double weight;
    private String description;
    private String imageName;
}
