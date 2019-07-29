package com.nexign.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "products_hist")
public class ProductHistories implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "product_id")
    private Integer productId;

    private Double calories;

    private Double proteins;

    private Double fat;

    private Double carbohydrate;

    @Column(name = "is_visible", insertable = false)
    private Boolean isVisible;

    @Column(name = "update_date", insertable = false)
    private Date updateDate;


    public ProductHistories() {
    }

    public ProductHistories(Integer productId, Double calories, Double carbohydrate, Double fat, Double proteins) {

        this.productId = productId;
        this.calories = calories;
        this.carbohydrate = carbohydrate;
        this.fat = fat;
        this.proteins = proteins;

    }

    public Integer getId() {
        return id;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
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

    @JsonIgnore
    public Boolean getIsVisible() {
        return isVisible;
    }

    public void setIsVisible(Boolean isVisible) {
        this.isVisible = isVisible;
    }

    @JsonIgnore
    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}
