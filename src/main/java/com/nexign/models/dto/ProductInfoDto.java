package com.nexign.models.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class ProductInfoDto implements Serializable {

    private String productName;

    private String producer;

    private Double calories;

    private Double proteins;

    private Double fat;

    private Double carbohydrate;

}
