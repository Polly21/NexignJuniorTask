package com.nexign.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "products_hist")
@Getter
@Setter
public class ProductHistories implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

//    @Column(name = "product_id")
//private Integer productId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id")
    private Product productId;

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

//    public ProductHistories(Integer productId, Double calories, Double carbohydrate, Double fat, Double proteins) {
//        this.productId = productId;
//        this.calories = calories;
//        this.carbohydrate = carbohydrate;
//        this.fat = fat;
//        this.proteins = proteins;
//    }

    @JsonIgnore
    public Product getProductId() {
        return productId;
    }

    @JsonIgnore
    public Boolean getIsVisible() {
        return isVisible;
    }

    @JsonIgnore
    public Date getUpdateDate() {
        return updateDate;
    }

}
