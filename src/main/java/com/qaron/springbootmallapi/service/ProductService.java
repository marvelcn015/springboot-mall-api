package com.qaron.springbootmallapi.service;


import com.qaron.springbootmallapi.dto.ProductRequest;
import com.qaron.springbootmallapi.model.Product;

public interface ProductService {
    public Product getProductById(Integer productId);
    public Integer createProduct(ProductRequest productRequest);
}
