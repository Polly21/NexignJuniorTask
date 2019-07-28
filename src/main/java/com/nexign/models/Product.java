package com.nexign.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;



// CREATE TABLE products (id INT PRIMARY KEY AUTO_INCREMENT, product_name VARCHAR(32)  NOT NULL, producer VARCHAR(32) NOT NULL, calories DOUBLE(7,2) NOT NULL, proteins DOUBLE(5,2) DEFAULT 0, fat DOUBLE(5,2) DEFAULT 0, carbohydrate DOUBLE(5,2) DEFAULT 0, CHECK  (fat+carbohydrate+proteins<=100.00));
// CREATE TABLE updates (id INT AUTO_INCREMENT, id_old_product INT NOT NULL, id_new_product INT NOT NULL);
// CREATE TABLE new_inserts (id INT AUTO_INCREMENT, id_new_product INT NOT NULL)
//INSERT INTO products (product_name,producer,calories,carbohydrate,fat,proteins) values ("Хлеб","Аленка",120,48,20,20),("Вода","Аленка",120,10,10,10),("Творог","Сибирский орех",555,38,50,5);
@Entity
@Table(name = "products")
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "product_name")
    private String productName;

    private String producer;

    @Column(name = "is_visible", insertable = false)
    private Boolean isVisible;

    @Column(name = "create_date", insertable = false)
    private Date createDate;

    public Product(){
    }

    public Product(String productName, String producer) {

        this.productName = productName;
        this.producer = producer;

    }

    public Integer getId() {
        return id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }
    @JsonIgnore
    public Boolean getVisible() {
        return isVisible;
    }

    public void setVisible(Boolean visible) {
        isVisible = visible;
    }
    @JsonIgnore
    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}