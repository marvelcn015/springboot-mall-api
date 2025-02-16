package com.qaron.springbootmallapi.service;


import com.qaron.springbootmallapi.dto.ProductQueryParams;
import com.qaron.springbootmallapi.dto.ProductRequest;
import com.qaron.springbootmallapi.model.Product;

import java.util.List;

public interface ProductService {

    List<Product> getAllProducts(ProductQueryParams params);

    Product getProductById(Integer productId);

    Integer createProduct(ProductRequest productRequest);

    void updateProduct(Integer productId, ProductRequest productRequest);

    void deleteProduct(Integer productId);
}
