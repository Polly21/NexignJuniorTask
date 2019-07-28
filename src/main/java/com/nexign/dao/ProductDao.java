package com.nexign.dao;

import com.nexign.models.Product;
import com.nexign.models.ProductHistories;
import com.nexign.models.dto.ProductInfoDto;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface ProductDao {
    public List  findAll();
    public Object findById(int id);
    public Object findByProductNameAndProducer(String productName, String producer);
    public Object save(Product product, ProductHistories productHistories);
    public ProductHistories update(Integer id, ProductHistories productHistories);
//    public void delete(Product product);

}
