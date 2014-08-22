package com.xebia.assetManagement.persistence.impl;

import com.xebia.assetManagement.persistence.GenericDAO;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * Created by anirudh on 22/08/14.
 */

@Repository
public class GenericDAOImpl<T, ID extends Serializable> implements GenericDAO<T, ID> {


    private Class<T> persistenceClass;
    private Session session;

    @Autowired
    private SessionFactory sessionFactory;

    //getting Persistence class by reflection
    public GenericDAOImpl() {
        this.persistenceClass = (Class<T>) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0];
    }

    public Class<T> getPersistenceClass() {
        return persistenceClass;
    }

    public Session getSession() {
        if (session == null) {
            return sessionFactory.getCurrentSession();
        }
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    @Override
    public T findById(ID id) {
        return (T) getSession().load(getPersistenceClass(), id);
    }

    @Override
    public List<T> findAll() {
        return findByCriteria();
    }

    @Override
    public List<T> findByExample(T exampleInstance, String... excludeProperty) {
        return null;
    }

    @Override
    public T makePersistant(T entity) {
        getSession().saveOrUpdate(entity);
        return entity;
    }

    @Override
    public void delete(T entity) {
        getSession().delete(entity);
    }

    @Override
    public void flush() {
        getSession().flush();

    }

    @Override
    public void clear() {
        getSession().clear();
    }

    public List<T> findByCriteria(Criterion... criterion) {
        Criteria criteria = getSession().createCriteria(getPersistenceClass());
        for (Criterion c : criterion) {
            criteria.add(c);
        }
        return criteria.list();
    }
}
