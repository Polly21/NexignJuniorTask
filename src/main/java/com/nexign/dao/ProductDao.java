package com.nexign.dao;

import com.nexign.models.Product;
import com.nexign.models.ProductHistories;
import com.nexign.models.dto.ProductDto;

import java.util.List;

public interface ProductDao {
    public List findAll();

    public Object findById(int id);

    public Object findByProductNameAndProducer(String productName, String producer);

    public Product save(Product product, ProductHistories productHistories);

    public ProductHistories update(Integer id, ProductHistories productHistories);
}
