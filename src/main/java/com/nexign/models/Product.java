package com.nexign.models;


//import org.hibernate.annotations.Table;

import javax.persistence.*;
import java.io.Serializable;

//import javax.persistence.*;
//import java.io.Serializable;


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

    private Double calories;

    private Double proteins;

    private Double fat;

    private Double carbohydrate;

    // Getters and Setters ... (Omitted for brevity)

    public Product(){
    }

    public Integer getId() {
        return id;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
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

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}