package com.qaron.springbootmallapi.service.impl;

import com.qaron.springbootmallapi.dao.ProductDao;
import com.qaron.springbootmallapi.dto.ProductRequest;
import com.qaron.springbootmallapi.model.Product;
import com.qaron.springbootmallapi.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    public Product getProductById(Integer productId) {
        return productDao.getProductById(productId);
    }

    @Override
    public Integer createProduct(ProductRequest productRequest) {
        return productDao.createProduct(productRequest);
    }
}
