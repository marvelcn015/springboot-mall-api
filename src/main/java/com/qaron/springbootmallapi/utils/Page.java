package com.qaron.springbootmallapi.utils;

import lombok.Data;

import java.util.List;

@Data
public class Page<T> {
        private Integer limit;
        private Integer offset;
        private Integer total;
        private List<T> results;
}
