package com.cmaccusco.tallerjava.demogradle.business.services.impl;

import com.cmaccusco.tallerjava.demogradle.business.services.ProductService;
import com.cmaccusco.tallerjava.demogradle.data.entities.Product;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service //@Component
public class ProductServiceImpl implements ProductService {

    @Override
    public List<Product> findAll() {
        List<Product> products = new ArrayList<>();
        products.add(new Product(1,"Sofa", 1500.0 ));
        products.add(new Product(2,"Mesa", 1200.0 ));

        return products;
    }
}
