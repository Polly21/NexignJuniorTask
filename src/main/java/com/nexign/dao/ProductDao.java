package com.nexign.dao;

import com.nexign.models.Product;
import com.nexign.models.ProductHistories;
import com.nexign.models.dto.ProductDto;

import java.util.List;

public interface ProductDao {
    List findAll();

    Object findById(int id);

    Object findByProductNameAndProducer(String productName, String producer);

    Product save(Product product, ProductHistories productHistories);

    ProductHistories update(Integer id, ProductHistories productHistories);
}
