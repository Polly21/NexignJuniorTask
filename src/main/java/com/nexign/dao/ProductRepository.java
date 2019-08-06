package com.nexign.dao;


import com.nexign.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    List<Product> findAll();

    Optional<Product> findById(Long id);

    Optional<Product> findByProductNameAndProducer(@Param("name") String nameProduct, @Param("producer") String producer);

}
