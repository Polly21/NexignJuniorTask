package com.nexign.controller;


import com.nexign.dao.impl.ProductDaoImpl;
import com.nexign.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {

//    @Autowired
//    ProductRepository productRepository;
//
    @Autowired
    ProductDaoImpl productDaoImpl;

//    @Autowired
//    MyService serv;
//
//    @GetMapping("/all")
//    public void getlol() {
//        System.out.println("hi");
//        serv.findAll();
//
//    }

    // Get All Notes
    @GetMapping("/notes")
    public List<Product> getAllNotes() {
//        return productRepository.findAll();
        return productDaoImpl.findAll();
//        return serv.findAll();
    }
//
//    // Create a new Product
//    @PostMapping("/notes")
//    public Product createNote(@Valid @RequestBody Product product) {
//        return productRepository.save(product);
//    }
//
//    @GetMapping("/notes/{id}")
//    public Product getNoteById(@PathVariable(value = "id") Integer productId) {
//        return productRepository.findById(productId)
//                .orElseThrow(() -> new FileSystemNotFoundException());
////                .orElseThrow(() -> new ResourceNotFoundException("Product", "id", noteId));
//    }
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
