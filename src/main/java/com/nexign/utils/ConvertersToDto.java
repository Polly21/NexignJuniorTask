package com.nexign.utils;

import com.nexign.models.Product;
import com.nexign.models.ProductHistories;
import com.nexign.models.dto.ProductDto;
import com.nexign.models.dto.ProductInfoDto;

import java.util.LinkedList;
import java.util.List;

public class ConvertersToDto {

    public static List<ProductInfoDto> createListProductInfoDto(List<Object[]> listObj) {

        if(listObj == null || listObj.isEmpty()) {
            return null;
        }

        List<ProductInfoDto> listDto = new LinkedList<>();

        for (Object[] listElem : listObj) {
            listDto.add(createProductInfoDtoFromObject(listElem));
        }
        return listDto;
    }

    public static ProductInfoDto createProductInfoDtoFromObject(Object[] array) {

        if(array == null) {
            return null;
        }

        ProductInfoDto dto = new ProductInfoDto();

        for (int i = 0; i < array.length; i++) {
            if (array[i].getClass() == Product.class) {
                dto.setProductName(((Product) array[i]).getProductName());
                dto.setProducer(((Product) array[i]).getProducer());
            } else {
                dto.setCalories(
                        ((ProductHistories) array[i]).getCalories());
                dto.setFat(
                        ((ProductHistories) array[i]).getFat());
                dto.setCarbohydrate(
                        ((ProductHistories) array[i]).getCarbohydrate());
                dto.setProteins(
                        ((ProductHistories) array[i]).getProteins());
            }
        }
        return dto;
    }

    public static ProductDto createProductDtoFromProduct(Product product) {
        ProductDto productDto = new ProductDto();
        productDto.setProducer(product.getProducer());
        productDto.setProductName(product.getProductName());

        return productDto;
    }

}
