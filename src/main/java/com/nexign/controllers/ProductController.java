package com.nexign.controllers;


import com.nexign.models.ProductHistories;
import com.nexign.models.dto.ProductInfoDto;
import com.nexign.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    ProductService productService;

    // Get All Products
    @GetMapping("/AllProducts")
    public List getAllProducts() {
        return productService.findAll();
    }

    // Get Products by id
    @GetMapping("/SpecificProduct/{id}")
    public Object getSpecificProduct(@PathVariable(value = "id") Integer productId) {
        return productService.findById(productId);
    }

    // Get Product by name and producer
    @GetMapping("/SpecificProduct")
    public Object getSpecificProductAsParams(@RequestParam(value = "name") String nameProduct, @RequestParam(value = "producer") String producer) {
        return productService.findByProductNameAndProducer(nameProduct, producer);
    }

    // Get Product by name
    @GetMapping("/SearchProductByName/{name}")
    public List getSpecificProduct(@PathVariable(value = "name") String nameProduct) {
        return productService.findProductsByName(nameProduct);
    }

    // Create a new Product
    @PostMapping("/addProduct")
    public Object createProduct(@Valid @RequestBody ProductInfoDto productInfoDto) {
        return productService.save(productInfoDto);
    }

    //    TODO разобраться почему не получается апдейтить через ProductHistories
    @PostMapping("/updateProduct/{id}")
    public ProductHistories updateProduct(@Valid @RequestBody ProductHistories productHistories, @PathVariable(value = "id") Integer id) {
        return productService.update(id, productHistories);
    }

}
