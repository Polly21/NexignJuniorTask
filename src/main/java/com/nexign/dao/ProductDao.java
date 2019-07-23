package com.nexign.dao;

import com.nexign.models.Product;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ProductDao {
    public List<Product>  findAll();
    public List<Product> findById(int id);
    public List<Product> findByProductNameAndProducer(String productName, String producer);
    public Product save(Product product);
    public void update(Product product);
    public void delete(Product product);

}
