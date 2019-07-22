package com.nexign.models;


//import org.hibernate.annotations.Table;

import javax.persistence.*;
import java.io.Serializable;

//import javax.persistence.*;
//import java.io.Serializable;


// CREATE TABLE products (id INT PRIMARY KEY AUTO_INCREMENT, producer VARCHAR(32) NOT NULL, calories DECIMAL(7,2), proteins DECIMAL(3,2) NOT NULL, fat DECIMAL(3,2), carbohydrate DECIMAL(3,2));
//INSERT INTO products (producer,calories,carbohydrate,fat,proteins) values ("qwe",14.45,12.12,13.13,14.14);
@Entity
@Table(name = "products")
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

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
}