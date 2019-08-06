package com.nexign.models;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "products")
@Getter
@Setter
//@Where(clause = "is_visible = true AND id IN (" +
//        "select abb.product_id from (" +
//        " select ph.product_id, MAX(ph.id) from products_hist ph where ph.is_visible = true group by ph.product_id) as abb")
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

    @OneToOne(mappedBy = "productId"/*, cascade = CascadeType.ALL*/)
    private ProductHistories productHistories;


    public Product() {
    }

}