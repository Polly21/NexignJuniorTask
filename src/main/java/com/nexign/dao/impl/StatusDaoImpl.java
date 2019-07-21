package com.nexign.dao.impl;

import com.nexign.dao.StatusDao;
import com.nexign.models.ProductStatus;
import org.hibernate.Session;
import com.nexign.utils.HibernateSessionFactoryUtil;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class StatusDaoImpl implements StatusDao {

    @Override
    public ProductStatus findById(int id) {
        return null;
    }

    @Override
    public void save(ProductStatus productStatus) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
//        Transaction tx1 = session.beginTransaction();
        session.save(productStatus);
//        tx1.commit();
        session.close();
    }

    @Override
    public void update(ProductStatus productStatus) {

    }

    @Override
    public void delete(ProductStatus productStatus) {

    }
}
