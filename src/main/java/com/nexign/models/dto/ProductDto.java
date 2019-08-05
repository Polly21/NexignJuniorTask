package com.nexign.models.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * Класс для возварата производителя и наименование продукта
 */

@Getter
@Setter
public class ProductDto {

    @JsonProperty("producer")
    private String producer;

    @JsonProperty("productName")
    private String productName;

}
