package com.nexign.dao;

import com.nexign.models.Product;
import com.nexign.models.ProductHistories;

import java.util.List;

public interface ProductDao {
    public List findAll();

    public Object findById(int id);

    public Object findByProductNameAndProducer(String productName, String producer);

    public Object save(Product product, ProductHistories productHistories);

    public ProductHistories update(Integer id, ProductHistories productHistories);
}
