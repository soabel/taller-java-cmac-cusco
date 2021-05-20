package com.cmaccusco.tallerjava.demogradle.business.services;

import com.cmaccusco.tallerjava.demogradle.data.entities.Product;

import java.util.List;

public interface ProductService {
    List<Product> findAll();
}
