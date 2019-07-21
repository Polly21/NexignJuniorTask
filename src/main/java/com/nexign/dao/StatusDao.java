package com.nexign.dao;

import com.nexign.models.ProductStatus;

public interface StatusDao {

    public ProductStatus findById(int id);
    public void save(ProductStatus productStatus);
    public void update(ProductStatus productStatus);
    public void delete(ProductStatus productStatus);

}
