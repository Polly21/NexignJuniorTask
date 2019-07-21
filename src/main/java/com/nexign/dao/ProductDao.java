package com.nexign.dao;

import com.nexign.models.Product;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductDao {
    public List<Product>  findAll();
    public Product findById(int id);
    public void save(Product product);
    public void update(Product product);
    public void delete(Product product);

}
