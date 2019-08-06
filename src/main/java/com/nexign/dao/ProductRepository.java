package com.nexign.dao;


import com.nexign.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    List<Product> findAll();

    @Query("SELECT p FROM Product p JOIN FETCH p.productHistories ph " +
            "WHERE p.id = ?1")
    Optional<Product> findById(Integer id);

    @Query("SELECT p FROM Product p JOIN FETCH p.productHistories ph " +
            "WHERE p.productName = :name " +
            "AND p.producer = :producer ")
    Optional<Product> findByProductNameAndProducer(@Param("name") String nameProduct, @Param("producer") String producer);

}
