package com.nexign.dao.impl;

import com.nexign.dao.ProductDao;
import com.nexign.models.Product;
import com.nexign.models.ProductHistories;
import com.nexign.utils.HibernateSessionFactoryUtil;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;


@SuppressWarnings("unchecked")
@Repository
@Transactional
public class ProductDaoImpl implements ProductDao {

    public ProductDaoImpl() {
    }

    @Override
    public List findAll() {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        String sql =
                "SELECT * " +
                        "from products p INNER JOIN products_hist ph ON ph.product_id = p.id " +
                        "where p.is_visible = true " +
                        "AND ph.product_id = p.id " +
                        "AND ph.id IN (select MAX(id) from products_hist WHERE is_visible = true group by product_id )";
        return session.createSQLQuery(sql)
                .addEntity(Product.class)
                .addEntity(ProductHistories.class)
                .list();
    }

    @Override
    public Object findById(int id) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();

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

    public Object findByProductNameAndProducer(String productName, String producer) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
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
    public Object save(Product product, ProductHistories productHistories) {

        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        try {
            session.save(product);
//        TODO корректно ли?
            productHistories.setProductId(product.getId());
            session.save(productHistories);
            tx1.commit();
            session.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            tx1.rollback();
            session.close();
            return ExceptionUtils.getStackTrace(ex);
        }
        return product;

    }

    @Override
    public ProductHistories update(Integer id, ProductHistories productHistories) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();

        if (id != null) {
            productHistories.setProductId(id);
        }

        try {
            session.save(productHistories);
            tx1.commit();
            session.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            tx1.rollback();
            session.close();
        }

        return productHistories;//findById(productHistories.getProductId());
    }

}
