package com.nexign.services;

import com.nexign.dao.ProductHistoriesRepository;
import com.nexign.dao.ProductRepository;
import com.nexign.models.Product;
import com.nexign.models.ProductHistories;
import com.nexign.models.dto.ProductDto;
import com.nexign.models.dto.ProductInfoDto;
import com.nexign.utils.ConvertersToDto;
import info.debatty.java.stringsimilarity.Levenshtein;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductHistoriesRepository productHistoriesRepository;

    @Transactional
    public List<ProductInfoDto> findAll() {
        List<Product> list = productRepository.findAll();
        if (list.isEmpty()) {
            return null;
        }

        return ConvertersToDto.createProductInfoDtoListFromProductList(list);
    }

    @Transactional
    public ProductInfoDto findById(long id) {

        return ConvertersToDto.createProductInfoDtoFromProduct(
                productRepository.findById(id)
                        .orElseThrow(NullPointerException::new));
    }

    @Transactional
    public ProductInfoDto findByProductNameAndProducer(String productName, String producer) {

        return ConvertersToDto.createProductInfoDtoFromProduct(
                productRepository.findByProductNameAndProducer(productName, producer)
                        .orElseThrow(NullPointerException::new));
    }

    @Transactional
    public List<ProductDto> findProductsByName(String nameProduct) {
        Levenshtein levenshtein = new Levenshtein();
        List<ProductDto> filteredProductsList = new LinkedList<>();

        int infelicity = nameProduct.length() / 2;
        List<Product> allProductsList = productRepository.findAll();

        for (Product product : allProductsList) {
            if (levenshtein.distance(product.getProductName(), nameProduct) <= infelicity) {
                filteredProductsList.add(ConvertersToDto.createProductDtoFromProduct(product));
            }
        }
        if (filteredProductsList.isEmpty()) {
            return null;
        }

        return filteredProductsList;
    }

    @Transactional
    public ProductInfoDto save(ProductInfoDto productInfoDto) {

        Product product = new Product();
        product.setProducer(productInfoDto.getProducer());
        product.setProductName(productInfoDto.getProductName());
        ProductHistories productHistories = new ProductHistories();
        productHistories.setCalories(productInfoDto.getCalories());
        productHistories.setCarbohydrate(productInfoDto.getCarbohydrate());
        productHistories.setFat(productInfoDto.getFat());
        productHistories.setProteins(productInfoDto.getProteins());
        product.setProductHistories(Collections.singletonList(productHistories));

        productRepository.save(product);

        productHistories.setProductId(product);
        productHistoriesRepository.save(productHistories);

        return ConvertersToDto.createProductInfoDtoFromProduct(product);
    }

    @Transactional
    public Integer update(Long id, ProductHistories productHistories) {
        if (id != null) {
            Product product = new Product();
            product.setId(id);
            productHistories.setProductId(product);
        }

        if (productHistories.getProductId() == null) {
            return 1;
        }

        productHistoriesRepository.save(productHistories);

        return 0;
    }

}
