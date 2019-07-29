package com.nexign.dao;

import com.nexign.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MyRepos extends JpaRepository <Product,Integer>{

}
