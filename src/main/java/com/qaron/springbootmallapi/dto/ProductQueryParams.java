package com.qaron.springbootmallapi.dto;

import com.qaron.springbootmallapi.constant.ProductCategory;
import lombok.Data;

@Data
public class ProductQueryParams {
   private ProductCategory category;
   private String search;
}
