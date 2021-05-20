package com.cmaccusco.tallerjava.demogradle.presentation.controllers;

import com.cmaccusco.tallerjava.demogradle.business.services.ProductService;
import com.cmaccusco.tallerjava.demogradle.data.entities.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("product")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService){
        this.productService=productService;
    }

    @GetMapping
    public List<Product> findAll(){
        return this.productService.findAll();
    }

}
