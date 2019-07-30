package com.nexign.services;

import com.nexign.dao.ProductRespository;
import com.nexign.models.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    @Autowired
    ProductRespository productRespository;

    @Transactional
    public ResponseEntity<List<Product>> findAll() {
        List<Product> list = productRespository.findAll();
        if(list.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }



    @Transactional
    public Product findById(int id) {
        return productRespository.findByIdAndIsVisible(id,true).orElseThrow(() -> new NullPointerException() );
    }



//        @Transactional
//    public ResponseEntity<List<Product>> findAll() {
//
//        return new ResponseEntity<>(repos.findAll(), HttpStatus.OK);
//    }

//    @Transactional
//    public ResponseEntity<ProductInfoDto> findById(int id) {
//        ProductInfoDto productInfoDto = ConvertersToDto.createProductInfoDtoFromObject((Object[]) productDaoImpl.findById(id));
//
//        if(productInfoDto == null) {
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        }
//        return new ResponseEntity<>(productInfoDto, HttpStatus.OK);
//    }
//
//    @Transactional
//    public ResponseEntity<ProductInfoDto> findByProductNameAndProducer(String productName, String producer) {
//        ProductInfoDto productInfoDto = ConvertersToDto.createProductInfoDtoFromObject((Object[]) productDaoImpl.findByProductNameAndProducer(productName, producer));
//        if (productInfoDto == null) {
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        }
//        return new ResponseEntity<>(productInfoDto,HttpStatus.OK);
//    }
//
//    @Transactional
//    public ResponseEntity<List<ProductDto>> findProductsByName(String nameProduct) {
//        Levenshtein l = new Levenshtein();
//        List<ProductDto> newList = new LinkedList<>();
//
//        List<Object[]> list = productDaoImpl.findAll();
//
//        for (Object[] array : list) {
//            for (Object obj : array) {
//                if (obj.getClass() != Product.class) {
//                    continue;
//                }
//
//                if (l.distance(((Product) obj).getProductName(), nameProduct) <= nameProduct.length() / 2) {
//                    newList.add(ConvertersToDto.createProductDtoFromProduct((Product) obj));
//                }
//            }
//        }
//        if(newList == null || newList.isEmpty()) {
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        }
//        return new ResponseEntity<>(newList,HttpStatus.OK);
//    }
//
//    @Transactional
//    public ResponseEntity<Product> save(ProductInfoDto productInfoDto) {
//        Product product = new Product(productInfoDto.getProductName(), productInfoDto.getProducer());
//        ProductHistories productHistories = new ProductHistories(product.getId(), productInfoDto.getCalories(), productInfoDto.getCarbohydrate(), productInfoDto.getFat(), productInfoDto.getProteins());
//        return new ResponseEntity<>(productDaoImpl.save(product, productHistories),HttpStatus.OK);
//
//    }
//
//    @Transactional
//    public ResponseEntity<ProductHistories> update(Integer id, ProductHistories productHistories) {
//        if (id != null) {
//            productHistories.setProductId(id);
//        }
//        return new ResponseEntity<>(productDaoImpl.update(id, productHistories),HttpStatus.OK);
//    }

}
