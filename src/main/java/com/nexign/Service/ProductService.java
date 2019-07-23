package com.nexign.Service;

import com.nexign.dao.ProductDao;
import com.nexign.dao.impl.ProductDaoImpl;
import com.nexign.dao.impl.StatusDaoImpl;
import com.nexign.models.Product;
import com.nexign.models.ProductStatus;
import com.nexign.models.dto.ProductDto;
import info.debatty.java.stringsimilarity.Levenshtein;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class ProductService implements ProductDao {

    @Autowired
    ProductDaoImpl productDaoImpl;

    public List findProductsByName(String nameProduct) {

        Levenshtein l = new Levenshtein();

        List<Product> list = productDaoImpl.findAll();

        List<ProductDto> newList = new LinkedList<>();

        for(Product product : list) {
            if(l.distance(product.getProductName(),nameProduct) <= nameProduct.length()/2 )  {
                newList.add(ProductDto.fromEntity(product));
            }
        }

        return newList;

    }


    @Override
    public List<Product> findAll() {
        return productDaoImpl.findAll();
    }

    @Override
    public List<Product> findById(int id) {
        return productDaoImpl.findById(id);
    }

    @Override
    public List<Product> findByProductNameAndProducer(String productName, String producer) {
        return productDaoImpl.findByProductNameAndProducer(productName,producer);
    }

    @Override
    public Product save(Product product) {
        productDaoImpl.save(product);
        return product;
    }

    @Override
    public void update(Product product) {

    }

    @Override
    public void delete(Product product) {

    }
}
