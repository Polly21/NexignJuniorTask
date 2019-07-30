package com.nexign.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "products")
@Getter
@Setter
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "product_name", nullable = false)
    private String productName;

    @Column(nullable = false)
    private String producer;

    @Column(name = "is_visible", insertable = false)
    private Boolean isVisible;

    @Column(name = "create_date", insertable = false)
    private Date createDate;


    public Product() {
    }

    public Product(String productName, String producer) {
        this.productName = productName;
        this.producer = producer;
    }

    @JsonIgnore
    public Boolean getVisible() {
        return isVisible;
    }

    @JsonIgnore
    public Date getCreateDate() {
        return createDate;
    }

}