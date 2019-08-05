package com.nexign.utils;

import com.nexign.models.Product;
import com.nexign.models.dto.ProductDto;
import com.nexign.models.dto.ProductInfoDto;

import java.util.LinkedList;
import java.util.List;

public class ConvertersToDto {

    public static ProductDto createProductDtoFromProduct(Product product) {
        ProductDto productDto = new ProductDto();
        productDto.setProducer(product.getProducer());
        productDto.setProductName(product.getProductName());

        return productDto;
    }

    public static ProductInfoDto createProductInfoDtoFromProduct(Product product) {
        ProductInfoDto productInfoDto = new ProductInfoDto();

        productInfoDto.setProducer(product.getProducer());
        productInfoDto.setProductName(product.getProductName());
        productInfoDto.setFat(product.getProductHistories().getFat());
        productInfoDto.setCarbohydrate(product.getProductHistories().getCarbohydrate());
        productInfoDto.setCalories(product.getProductHistories().getCalories());
        productInfoDto.setProteins(product.getProductHistories().getProteins());
        productInfoDto.setFat(product.getProductHistories().getFat());

        return productInfoDto;
    }

    public static List<ProductInfoDto> createProductInfoDtoListFromProductList(List<Product> productList) {
        List<ProductInfoDto> productInfoDtoList = new LinkedList<>();

        for(Product product : productList) {
            productInfoDtoList.add(createProductInfoDtoFromProduct(product));
        }

        return productInfoDtoList;
    }

}
