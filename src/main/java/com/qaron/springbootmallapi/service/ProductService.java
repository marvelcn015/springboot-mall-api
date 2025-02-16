package com.qaron.springbootmallapi.service;


import com.qaron.springbootmallapi.constant.ProductCategory;
import com.qaron.springbootmallapi.dto.ProductRequest;
import com.qaron.springbootmallapi.model.Product;

import java.util.List;

public interface ProductService {

    List<Product> getAllProducts(ProductCategory category, String search);

    Product getProductById(Integer productId);

    Integer createProduct(ProductRequest productRequest);

    void updateProduct(Integer productId, ProductRequest productRequest);

    void deleteProduct(Integer productId);
}
