package com.nexign.dao;

import com.nexign.models.Product;
import com.nexign.models.dto.ProductInfoDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRespository extends JpaRepository <Product,Integer>{

     Optional<Product> findByIdAndIsVisible(Integer id, Boolean isVisible);
     Optional<Product> findById(Integer id);

}
