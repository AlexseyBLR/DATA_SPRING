//package com.compit.spring_data.dao;
//
//import com.compit.spring_data.entity.Test;
//import org.springframework.stereotype.Repository;
//
//import javax.persistence.EntityManager;
//import javax.persistence.NamedQueries;
//import javax.persistence.PersistenceContext;
//import java.util.List;
//
//@Repository
//public class TestDaoImpl implements TestDAO {
//
//    @PersistenceContext
//    private EntityManager entityManager;
//
//    @Override
//    public List<Test> getAll() {
//        return entityManager.createQuery("select t from Test t").getResultList();
//    }
//}
