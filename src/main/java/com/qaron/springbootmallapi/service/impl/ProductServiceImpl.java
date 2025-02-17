package com.qaron.springbootmallapi.service.impl;

import com.qaron.springbootmallapi.dao.ProductDao;
import com.qaron.springbootmallapi.dto.ProductQueryParams;
import com.qaron.springbootmallapi.dto.ProductRequest;
import com.qaron.springbootmallapi.model.Product;
import com.qaron.springbootmallapi.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    public Integer countProduct(ProductQueryParams params) {
        return productDao.countProduct(params);
    }

    @Override
    public List<Product> getAllProducts(ProductQueryParams params) {
        return productDao.getAllProducts(params);
    }

    @Override
    public Product getProductById(Integer productId) {
        return productDao.getProductById(productId);
    }

    @Override
    public Integer createProduct(ProductRequest productRequest) {
        return productDao.createProduct(productRequest);
    }

    @Override
    public void updateProduct(Integer productId, ProductRequest productRequest) {
        productDao.updateProduct(productId, productRequest);
    }

    @Override
    public void deleteProduct(Integer productId) {
        productDao.deleteProduct(productId);
    }
}
