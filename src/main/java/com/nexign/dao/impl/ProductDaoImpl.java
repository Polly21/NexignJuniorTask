package com.nexign.dao.impl;

import com.nexign.dao.ProductDao;
import com.nexign.models.Product;
import com.nexign.models.ProductHistories;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Реализация репозитория для работы с продуктами
 */
@SuppressWarnings("unchecked")
@Repository
@Transactional
public class ProductDaoImpl implements ProductDao {

    @Autowired
    private SessionFactory sessionFactory;

    public ProductDaoImpl() {
    }

    @Override
    @Transactional
    public List findAll() {
        Session session = sessionFactory.openSession();
        String sql =
                "SELECT * " +
                        "from products p INNER JOIN products_hist ph ON ph.product_id = p.id " +
                        "where p.is_visible = true " +
                        "AND ph.product_id = p.id " +
                        "AND ph.id IN (select MAX(id) from products_hist WHERE is_visible = true group by product_id )";
        return session.createNativeQuery(sql)
                .addEntity(Product.class)
                .addEntity(ProductHistories.class)
                .list();
    }

    @Override
    @Transactional
    public Object findById(int id) {
        Session session = sessionFactory.openSession();
        String sql = "select * from products p INNER JOIN products_hist ph ON ph.product_id = p.id " +
                "WHERE p.is_visible = true " +
                "AND p.id = :id " +
                "AND ph.id IN (select MAX(id) from products_hist where is_visible = true group by product_id)";
        return session.createNativeQuery(sql)
                .addEntity(Product.class)
                .addEntity(ProductHistories.class)
                .setParameter("id", id)
                .uniqueResult();
    }

    @Override
    @Transactional
    public Object findByProductNameAndProducer(String productName, String producer) {
        Session session = sessionFactory.openSession();
        String sql = "select * from products p INNER JOIN products_hist ph ON p.id = ph.product_id " +
                "where p.is_visible = true " +
                "AND p.product_name = :productName " +
                "AND p.producer = :producer " +
                "AND ph.id IN (select MAX(id) from products_hist where is_visible = true group by product_id )";
        return session.createNativeQuery(sql)
                .addEntity(Product.class)
                .addEntity(ProductHistories.class)
                .setParameter("productName", productName)
                .setParameter("producer", producer)
                .uniqueResult();
    }

    @Override
    @Transactional
    public Product save(Product product, ProductHistories productHistories) {
            Session session = sessionFactory.openSession();
            session.save(product);
            productHistories.setProductId(product.getId());
            session.save(productHistories);
            session.disconnect();
            return product;
    }

    @Override
    @Transactional
    public ProductHistories update(Integer id, ProductHistories productHistories) {
        Session session = sessionFactory.openSession();
        session.save(productHistories);
        session.disconnect();
        return productHistories;
    }

}
