package com.nexign.models;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Where;
import org.hibernate.annotations.WhereJoinTable;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "products")
@Getter
@Setter
@WhereJoinTable(clause = "products_hist.id IN (select MAX(ph.id) from products_hist ph WHERE products_hist.is_visible = true group by products_hist.product_id)")
@Where(clause = "is_visible = true")
public class Product implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product_name", nullable = false)
    private String productName;

    @Column(nullable = false)
    private String producer;

    @Column(name = "is_visible", insertable = false)
    private Boolean isVisible;

    @Column(name = "create_date", insertable = false)
    private Date createDate;

    /**
     * Используется OneToMany т.к. в таблице products_hist хранится история информации о продукте
     */
    @OneToMany(mappedBy = "productId"/*, cascade = CascadeType.ALL*/)
    @Where(clause = "id IN (select MAX(ph.id) from products_hist ph WHERE ph.is_visible = true group by ph.product_id)")
    private List<ProductHistories> productHistories;

}