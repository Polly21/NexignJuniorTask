package com.nexign.models.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
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

}
