package com.nexign.dao.impl;

import com.nexign.dao.ProductDao;
import com.nexign.models.Product;
import com.nexign.models.ProductStatus;
import com.nexign.utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.exception.GenericJDBCException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@SuppressWarnings("unchecked")
@Repository
@Transactional
public class ProductDaoImpl implements ProductDao {

//    @Autowired
//    private SessionFactory sessionFactory;

    public ProductDaoImpl() {
    }

    @Override
    public List<Product> findAll() {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        String sql = "select p.* from Products as p, ProductStatus as ps where p.id = ps.product_id AND ps.status = true";
        return session.createSQLQuery(sql).addEntity(Product.class).list();
    }

////    TODO
//    @Override
//    public Product findById(int id) {
//        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
//        String sql = "select p.* from Products as p, ProductStatus as ps where p.id = ps.product_id AND p.id = :id AND ps.status = true";
//          List<Object> list = session.createNativeQuery(sql)
//                .addEntity(Product.class)
//                .setParameter("id", id).list();
//        return (Product)list.get(0);
//    }

    @Override
    public List findById(int id) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        String sql = "select p.* from Products as p, ProductStatus as ps where p.id = ps.product_id AND p.id = :id AND ps.status = true ORDER BY id LIMIT 1";
        List<Object> list = session.createNativeQuery(sql)
                .addEntity(Product.class)
                .setParameter("id", id).list();
        return list;
    }

    public List<Product> findByProductNameAndProducer(String productName, String producer) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        String sql = "select p.* from Products as p, ProductStatus as ps where p.id = ps.product_id AND p.product_name = :productName AND p.producer = :producer AND ps.status = true";
        return session.createNativeQuery(sql)
                .addEntity(Product.class)
                .setParameter("productName", productName)
                .setParameter("producer", producer)
                .list();
    }

//    public List findProductsByName(String name) {
//        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
//        String sql = "select p.product_name, p.producer from Products as p, ProductStatus as ps where p.id = ps.product_id AND ps.status = true";
//        return  session.createNativeQuery(sql)
//                .addEntity(Product.class).list();
//    }

//    @Override
//    public Product save(Product product) {
//        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
//        Transaction tx1 = session.beginTransaction();
//        try {
//
//            session.save(product);
////        TODO корректно ли?
//            session.save(new ProductStatus(product.getId()));
//            tx1.commit();
//            session.close();
//            return product;
//        } catch (Exception ex) {
//            tx1.rollback();
//            ex.printStackTrace();
//            session.close();
//            return null;
//        }
//    }

    @Transactional
    public Product save(Product product) {
        try(Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
//        Transaction tx1 = session.beginTransaction();
            session.save(product);
//        TODO корректно ли?
            session.save(new ProductStatus(product.getId()));
//            tx1.commit();
        }
            return product;

    }

    @Override
    @Transactional
    public Product update(Product product) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
//        Transaction tx1 = session.beginTransaction();
        session.save(product);
        session.save(new ProductStatus(product.getId()));
//        tx1.commit();
        session.close();
        return product;
    }

    @Override
    public void delete(Product product) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.delete(product);
        tx1.commit();
        session.close();
    }

}
