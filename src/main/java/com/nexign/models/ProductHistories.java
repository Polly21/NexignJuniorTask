package com.nexign.models;

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

    @OneToOne
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

}
