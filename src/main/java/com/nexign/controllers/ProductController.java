package com.nexign.controllers;

import com.nexign.models.ProductHistories;
import com.nexign.models.dto.ProductDto;
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

    /**
     * Get all products
     */
    @GetMapping("/AllProducts")
    public List<ProductInfoDto> getAllProducts() {
        return productService.findAll();
    }

    /**
     * Get Products by id
     */
    @GetMapping("/SpecificProduct/{id}")
    public ProductInfoDto getSpecificProduct(@PathVariable(value = "id") Integer productId) {
        return productService.findById(productId);
    }

    /**
     * Get Product by name and producer
     *
     * @param nameProduct - Название продукта
     * @param producer    - Производитель
     */
    @GetMapping("/SpecificProduct")
    public ProductInfoDto getSpecificProductAsParams(@RequestParam(value = "name") String nameProduct, @RequestParam(value = "producer") String producer) {
        return productService.findByProductNameAndProducer(nameProduct, producer);
    }

    /**
     * Get Product by name - реализация нечеткого поиска
     *
     * @param nameProduct - название продукта по которому будет производиться нечеткий поиск
     * @return - Возвращает объект ProductDto (навзание продукта, производитель)
     */
    @GetMapping("/SearchProductByName/{name}")
    public List<ProductDto> getSpecificProduct(@PathVariable(value = "name") String nameProduct) {
        return productService.findProductsByName(nameProduct);
    }

    /**
     * Create a new Product
     */
    @PostMapping("/addProduct")
    public ProductInfoDto createProduct(@Valid @RequestBody ProductInfoDto productInfoDto) {
        productService.save(productInfoDto);
        return productInfoDto;
    }

    /**
     * Update product
     *
     * @param productHistories - Объект содержащий только характеристики продукта (не название и производителя)
     */
    @PostMapping("/updateProduct/{id}")
    public Integer updateProduct(@Valid @RequestBody ProductHistories productHistories, @PathVariable(value = "id") Integer id) {
        return productService.update(id, productHistories);
    }

}
