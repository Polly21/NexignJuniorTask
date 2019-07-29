package com.nexign.models.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nexign.models.Product;
import com.nexign.models.ProductHistories;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;


public class ProductInfoDto implements Serializable {

    @JsonProperty("productName")
    private String productName;

    @JsonProperty("producer")
    private String producer;

    @JsonProperty("calories")
    private Double calories;

    @JsonProperty("proteins")
    private Double proteins;

    @JsonProperty("fat")
    private Double fat;

    @JsonProperty("carbohydrate")
    private Double carbohydrate;


    public static List<ProductInfoDto> fromList(List<Object[]> list) {
        List<ProductInfoDto> dtolist = new LinkedList<>();

        for (Object[] obj : list) {

            dtolist.add(createOneObject(obj));

        }
        return dtolist;
    }

    public static ProductInfoDto createOneObject(Object[] array) {

        ProductInfoDto dto = new ProductInfoDto();

        for (int i = 0; i < array.length; i++) {
            if (array[i].getClass() == Product.class) {
                dto.setProductName(((Product) array[i]).getProductName());
                dto.setProducer(((Product) array[i]).getProducer());
            } else {
                dto.setCalories(((ProductHistories) array[i]).getCalories());
                dto.setFat(((ProductHistories) array[i]).getFat());
                dto.setCarbohydrate(((ProductHistories) array[i]).getCarbohydrate());
                dto.setProteins(((ProductHistories) array[i]).getProteins());
            }
        }

        return dto;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public Double getCalories() {
        return calories;
    }

    public void setCalories(Double calories) {
        this.calories = calories;
    }

    public Double getProteins() {
        return proteins;
    }

    public void setProteins(Double proteins) {
        this.proteins = proteins;
    }

    public Double getFat() {
        return fat;
    }

    public void setFat(Double fat) {
        this.fat = fat;
    }

    public Double getCarbohydrate() {
        return carbohydrate;
    }

    public void setCarbohydrate(Double carbohydrate) {
        this.carbohydrate = carbohydrate;
    }


}
