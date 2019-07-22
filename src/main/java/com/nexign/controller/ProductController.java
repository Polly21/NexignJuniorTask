package com.nexign.controller;


import com.nexign.dao.impl.ProductDaoImpl;
import com.nexign.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    ProductDaoImpl productDaoImpl;

    // Get All Notes
    @GetMapping("/AllProducts")
    public List<Product> getAllProducts() {
        return productDaoImpl.findAll();
    }

    @GetMapping("/SpecificProduct/{id}")
    public List<Product> getSpecificProduct(@PathVariable(value = "id") Integer productId) {
        return productDaoImpl.findById(productId);
    }


//
    // Create a new Product
    @PostMapping("/addProduct")
    public Product createNote(@Valid @RequestBody Product product) {
//        productDaoImpl.save(product);
        return productDaoImpl.save(product);
    }
//
//
//    // Update a Product
////    @PutMapping("/notes/{id}")
////    public Product updateNote(@PathVariable(value = "id") Integer noteId,
////                              @Valid @RequestBody Product productDetails) {
////
////        Product product = productRepository.findById(noteId)
////                .orElseThrow(() -> new FileSystemNotFoundException());
////
////        product.setName(productDetails.getName());
////        product.setSumm(productDetails.getSumm());
////
////        Product updatedProduct = productRepository.save(product);
////        return updatedProduct;
////    }
//
//    // Delete a Product
//    @DeleteMapping("/notes/{id}")
//    public ResponseEntity<?> deleteNote(@PathVariable(value = "id") Integer noteId) {
//        Product product = productRepository.findById(noteId)
//                .orElseThrow(() -> new FileSystemNotFoundException());
//
//        productRepository.delete(product);
//
//        return ResponseEntity.ok().build();
//    }

}
