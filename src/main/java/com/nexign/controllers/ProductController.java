package com.nexign.controllers;


import com.nexign.models.Product;
import com.nexign.models.ProductHistories;
import com.nexign.models.dto.ProductDto;
import com.nexign.models.dto.ProductInfoDto;
import com.nexign.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    ProductService productService;

    /**
     * Get all products
     */
    @GetMapping("/AllProducts")
    public ResponseEntity<List<Product>> getAllProducts() {
        return productService.findAll();
    }

//    @GetMapping("/AllProducts")
//    public ResponseEntity<List<Product>> getAllProducts() {
//        return productService.findAll();
//    }
//
    /**
     * Get Products by id
     */
    @GetMapping("/SpecificProduct/{id}")
    public Product getSpecificProduct(@PathVariable(value = "id") Integer productId) {
//        return productService.findById(productId);
        return productService.findById(productId);
    }
//
//    /**
//     * Get Product by name and producer
//     */
//    @GetMapping("/SpecificProduct")
//    public ResponseEntity<ProductInfoDto> getSpecificProductAsParams(@RequestParam(value = "name") String nameProduct, @RequestParam(value = "producer") String producer) {
//        return productService.findByProductNameAndProducer(nameProduct, producer);
//    }
//
//    /**
//     * Get Product by name
//     * @param nameProduct - название продукта по которому будет производиться нечеткий поиск
//     * @return - Возвращает объект ProductDto (навзание продукта, производитель)
//     */
//    @GetMapping("/SearchProductByName/{name}")
//    public ResponseEntity<List<ProductDto>> getSpecificProduct(@PathVariable(value = "name") String nameProduct) {
//        return productService.findProductsByName(nameProduct);
//    }
//
//    /**
//     * Create a new Product
//     * @param productInfoDto - Объект с заполненными полями
//     */
//    @PostMapping("/addProduct")
//    public ResponseEntity<Product> createProduct(@Valid @RequestBody ProductInfoDto productInfoDto) {
//        return productService.save(productInfoDto);
//    }
//
//    /**
//     * Update product
//     * @param productHistories - Объект содержащий только характеристики продукта (не название и производитель)
//     */
//    @PostMapping("/updateProduct/{id}")
//    public ResponseEntity<ProductHistories> updateProduct(@Valid @RequestBody ProductHistories productHistories, @PathVariable(value = "id") Integer id) {
//        return productService.update(id, productHistories);
//    }

}
