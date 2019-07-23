package com.m3.training.DAO;

import com.m3.training.SQLObject.DatabaseObject;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import java.util.Optional;

public class GenericDAO<T extends DatabaseObject> implements CRUD<T> {

    private final Class<T> typeParamClass;
    private final EntityManager entityManager;

    public GenericDAO(Class<T> typeParamClass) {
        // TODO: Add connection to properties file
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("oracle-connection");
        entityManager = emf.createEntityManager();
        this.typeParamClass = typeParamClass;
    }

    public GenericDAO(EntityManager entityManager, Class<T> typeParamClass) {
        this.entityManager = entityManager;
        this.typeParamClass = typeParamClass;
    }

    @Override
    public List<T> getAll() {
        // TODO: Add to properties file
        return entityManager
                .createQuery("SELECT a FROM " + typeParamClass.getName() + " a", typeParamClass)
                .getResultList();
    }

    @Override
    public Optional<T> getForID(long id) {
        entityManager.getTransaction().begin();
        Optional<T> result = Optional.ofNullable(entityManager.find(typeParamClass, id));
        entityManager.getTransaction().commit();
        return result;
    }

    @Override
    public void create(T obj) {
        entityManager.getTransaction().begin();
        entityManager.persist(obj);
        entityManager.getTransaction().commit();
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
}
