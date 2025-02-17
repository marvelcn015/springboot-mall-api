package com.qaron.springbootmallapi.controller;

import com.qaron.springbootmallapi.constant.ProductCategory;
import com.qaron.springbootmallapi.dto.ProductQueryParams;
import com.qaron.springbootmallapi.dto.ProductRequest;
import com.qaron.springbootmallapi.model.Product;
import com.qaron.springbootmallapi.service.ProductService;
import com.qaron.springbootmallapi.utils.Page;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public ResponseEntity<Page<Product>> getAllProducts(
            // Filtering
            @RequestParam(required = false) ProductCategory category,
            @RequestParam(required = false) String search,
            // Sorting
            @RequestParam(defaultValue = "created_date") String orderBy,
            @RequestParam(defaultValue = "desc") String sort,
            // Pagination
            @RequestParam(defaultValue = "5") @Max(100) @Min(0) Integer limit,
            @RequestParam(defaultValue = "0") @Min(0) Integer offset) {

        ProductQueryParams params = new ProductQueryParams();
        params.setCategory(category);
        params.setSearch(search);
        params.setOrderBy(orderBy);
        params.setSort(sort);
        params.setLimit(limit);
        params.setOffset(offset);

        List<Product> productList = productService.getAllProducts(params);
        Integer total = productService.countProduct(params);

        Page<Product> page = new Page<>();
        page.setLimit(limit);
        page.setOffset(offset);
        page.setTotal(total);
        page.setResults(productList);

        return ResponseEntity.ok(page);
    }

    @GetMapping("/products/{productId}")
    public ResponseEntity<Product> getProduct(@PathVariable Integer productId) {

        Product product = productService.getProductById(productId);

        if (product != null) {
            return ResponseEntity.ok(product);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/products")
    public ResponseEntity<Product> createProduct(@RequestBody @Valid ProductRequest productRequest) {
        Integer productId = productService.createProduct(productRequest);

        Product product = productService.getProductById(productId);

        return ResponseEntity.status(201).body(product);
    }

    @PutMapping("/products/{productId}")
    public ResponseEntity<Product> updateProduct(@PathVariable Integer productId, @RequestBody @Valid ProductRequest productRequest) {
        Product product = productService.getProductById(productId);
        if (product != null) {
            productService.updateProduct(productId, productRequest);
            product = productService.getProductById(productId);
            return ResponseEntity.ok(product);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/products/{productId}")
    public ResponseEntity<?> deleteProduct(@PathVariable Integer productId) {
        productService.deleteProduct(productId);
        return ResponseEntity.noContent().build();
    }
}
