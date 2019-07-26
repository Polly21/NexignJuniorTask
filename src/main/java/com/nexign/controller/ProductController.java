package com.nexign.controller;


import com.nexign.service.ProductService;
import com.nexign.models.Product;
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
    public List<Product> getAllProducts() {
        return productService.findAll();
    }

    // Get Products by id
    @GetMapping("/SpecificProduct/{id}")
    public List<Product> getSpecificProduct(@PathVariable(value = "id") Integer productId) {
        return productService.findById(productId);
    }

    // Get Product by name and producer
    @GetMapping("/SpecificProduct")
    public List<Product> getSpecificProductAsParams(@RequestParam (value = "name") String nameProduct, @RequestParam (value = "producer") String producer) {
        return productService.findByProductNameAndProducer(nameProduct,producer);
    }

    // Get Product by name
    @GetMapping("/SearchProductByName/{name}")
    public List getSpecificProduct(@PathVariable(value = "name") String nameProduct) {
        return  productService.findProductsByName(nameProduct);
    }

    // Create a new Product
    @PostMapping("/addProduct")
    public Product createProduct(@Valid @RequestBody Product product) {
        return productService.save(product);
    }

    @PostMapping("/updateProduct/{id}")
    public Product updateProduct(@Valid @RequestBody Product product) {
        return productService.update(product);
    }

}
