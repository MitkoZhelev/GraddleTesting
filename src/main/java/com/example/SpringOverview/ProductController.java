package com.example.SpringOverview;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {
    @RequestMapping("/products")
    public List <Product>  getProducts(){
    List <Product> products = new ArrayList<Product>();
    products.add(new Product("Beer"));
    products.add(new Product("Eggs"));
    products.add(new Product("Milk"));
    return products;
    }
}
