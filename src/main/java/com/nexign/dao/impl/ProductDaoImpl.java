package com.nexign.dao.impl;

import com.nexign.dao.ProductDao;
import com.nexign.models.Product;
import com.nexign.models.ProductStatus;
import com.nexign.utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class ProductDaoImpl implements ProductDao {

    @Autowired
//    private SessionFactory sessionFactory;

    public ProductDaoImpl() {
    }

    @Override
    public List<Product> findAll() {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
//        String sql = "select " + Product.class.getSimpleName() + " from " + Product.class.getSimpleName() + " p";// where p.id IN (Select productId from ProductStatus s where s.status = true)";
        String sql = "select p.* from Products as p, ProductStatus as ps where p.id = ps.product_id AND ps.status = true";

        System.out.println(sql);

//        Session session = this.sessionFactory.getCurrentSession();
//        List <Product> queryRes = session.createQuery(sql, Product.class).getResultList();
        System.out.println("waaawawt");
        return session.createSQLQuery(sql).addEntity(Product.class).list();
//        Transaction tx1 = session.beginTransaction();
//        Query query = session.createQuery("from Product p where p.id IN (Select productId from ProductStatus s where s.status = true )");
//        return session.createQuery().list();

    }

    @Override
    public Product findById(int id) {
//        String query =
//                "SELECT p from " + Product.class.getSimpleName() + " p INNER JOIN " + ProductStatus.class.getSimpleName() +
//                " s ON p.id = s.product_id WHERE p.id = :productId AND s.status == true";
//        System.out.println(query);
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
//        Query query = session.createQuery("FROM Product p INNER JOIN ProductStatus s ON p.id = s.productId WHERE p.id = :productId AND s.status == true");
        Query query = session.createQuery("FROM Product p where p.id = (Select * FROM ProductStatus s where s.productId = :id AND s.status = true)");
        System.out.println(query.toString());
        query.setParameter("productId",id);
        List <Product> results = query.getResultList();
//        session.createQuery("FROM Product p INNER JOIN ProductStatus s ON p.id = s.productId WHERE p.id = :productId AND s.status == true");

        return results.get(0);
    }

    @Override
    public void save(Product product) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.save(product);
//        TODO корректно ли?
        session.save(new ProductStatus(product.getId()));
        tx1.commit();
        session.close();
    }

    @Override
    public void update(Product product) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();
        session.update(product);
        session.save(new ProductStatus(product.getId()));
        tx1.commit();
        session.close();
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
