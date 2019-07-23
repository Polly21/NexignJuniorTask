package com.nexign.models;

import javax.persistence.*;
import java.io.Serializable;

//CREATE TABLE productStatus (id INT PRIMARY KEY AUTO_INCREMENT, product_id INT NOT NULL, status BOOLEAN DEFAULT false, FOREIGN KEY (product_id) REFERENCES products (id));
//INSERT INTO productstatus values (1,1,true), (2,2,true), (3,3,true), (4,4, false);
@Entity
@Table(name = "productstatus")
public class ProductStatus implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "product_id")
    private Integer productId;

    private Boolean status;

    public ProductStatus() {
    }

//TODO найти  анотацию значение по дефолту
    public ProductStatus(Integer productId) {
        this.productId = productId;
        this.status = false;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Boolean getVisible() {
        return status;
    }

    public void setVisible(Boolean visible) {
        status = visible;
    }
}
