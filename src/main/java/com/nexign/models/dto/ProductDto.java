package com.nexign.models.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.nexign.models.Product;

import java.util.List;


/*Класс для возварата производителя и наименование продукта*/
public class ProductDto {

    @JsonProperty("producer")
    private String producer;
    @JsonProperty("productName")
    private String productName;

    public ProductDto() {
    }

    // you can do any transforamtion/validation here
    public static ProductDto fromEntity(Product product) {
        ProductDto dto = new ProductDto();
        dto.setProducer(product.getProducer());
        dto.setProductName(product.getProductName());
        return dto;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}
