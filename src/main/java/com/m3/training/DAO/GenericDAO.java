package com.m3.training.DAO;

import com.m3.training.SQLObject.DatabaseObject;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.RollbackException;
import java.util.List;
import java.util.Optional;

public class GenericDAO<T extends DatabaseObject> implements CRUD<T>, AutoCloseable {

    private final Class<T> typeParamClass;
    private final EntityManager entityManager;
    private final String tableName;

    public GenericDAO(Class<T> typeParamClass) {
        // TODO: Add connection to properties file
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("oracle-connection");
        entityManager = emf.createEntityManager();
        this.typeParamClass = typeParamClass;
        this.tableName = typeParamClass.getSimpleName();
    }

    public GenericDAO(EntityManager entityManager, Class<T> typeParamClass) {
        this.entityManager = entityManager;
        this.typeParamClass = typeParamClass;
        this.tableName = typeParamClass.getName();
    }

    @Override
    public List<T> getAll() {
        // TODO: Add to properties file
        return entityManager
                .createQuery("SELECT a FROM " + tableName + " a", typeParamClass)
                .getResultList();
    }

    @Override
    public Optional<T> getForID(long id) {
        entityManager.getTransaction().begin();
        Optional<T> result = Optional.ofNullable(entityManager.find(typeParamClass, id));
        entityManager.getTransaction().commit();
        return result;
    }

    public List<T> getForParam(String columnName, String columnVal) {
        return entityManager
                .createQuery("FROM " + tableName + " E WHERE E." + columnName + " = '" + columnVal + "'", typeParamClass)
                .getResultList();
    }

    public <P> List<T> getForParam(String columnName, P columnVal) {
        return entityManager
                .createQuery("FROM " + tableName + " E WHERE E." + columnName + " = " + columnVal, typeParamClass)
                .getResultList();
    }

    public <P> List<T> getForParamLessThan(String columnName, P upperBound) {
        return entityManager
                .createQuery("FROM " + tableName + " E WHERE E." + columnName + " < " + upperBound, typeParamClass)
                .getResultList();
    }

    public <P> List<T> getForParamGreaterThan(String columnName, P lowerbound) {
        return entityManager
                .createQuery("FROM " + tableName + " E WHERE E." + columnName + " > " + lowerbound, typeParamClass)
                .getResultList();
    }

    @Override
    public void create(T obj) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(obj);
            entityManager.getTransaction().commit();
        } catch (RollbackException e) {
            String msg = "Cannot create a new SQL object with index already in the table.";
            throw new IllegalStateException(msg);
        }
    }

    @Override
    public void update(T obj) {
        entityManager.getTransaction().begin();
        entityManager.merge(obj);
        entityManager.getTransaction().commit();
    }

    @Override
    public void remove(long id) {
        entityManager.getTransaction().begin();
        Optional<T> result = Optional.ofNullable(entityManager.find(typeParamClass, id));
        result.ifPresent(entityManager::remove);
        entityManager.getTransaction().commit();
    }

    @Override
    public void close() {
        entityManager.close();
    }
}
