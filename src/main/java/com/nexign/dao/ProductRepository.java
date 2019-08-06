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

    Optional<Product> findByIdAndIsVisible(Integer id, Boolean isVisible);
//
    @Query("SELECT p FROM Product p JOIN FETCH p.productHistories ph " +
            "WHERE p.id = ?1 " +
            "AND p.isVisible = true " +
            "AND ph.id IN (select MAX(id) from ProductHistories WHERE isVisible = true group by productId)")
    Optional<Product> findById(Integer id);

   @Query("SELECT p FROM Product p JOIN FETCH p.productHistories ph " +
            "WHERE p.isVisible = true " +
            "AND ph.id IN (select MAX(id) from ProductHistories WHERE isVisible = true group by productId)")
    List<Product> findAll();

    @Query("SELECT p FROM Product p JOIN FETCH p.productHistories ph " +
            "WHERE p.isVisible = true " +
            "AND p.productName = :name " +
            "AND p.producer = :producer " +
            "AND ph.id IN (select MAX(id) from ProductHistories WHERE isVisible = true group by productId)")
    Optional<Product> findByProductNameAndProducer(@Param("name") String nameProduct, @Param("producer") String producer);

}
