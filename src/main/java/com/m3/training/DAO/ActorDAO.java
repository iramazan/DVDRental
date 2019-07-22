package com.m3.training.DAO;

import com.m3.training.SQLObject.Actor;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Optional;

public class ActorDAO implements CRUD<Actor>, AutoCloseable {

    private EntityManager entityManager;

    public ActorDAO() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("oracle-connection");
        entityManager = emf.createEntityManager();
    }

    public ActorDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Optional<Actor> getForID(long id) {
        entityManager.getTransaction().begin();
        Optional<Actor> result = Optional.ofNullable(entityManager.find(Actor.class, id));
        entityManager.getTransaction().commit();
        return result;
    }

    @Override
    public void create(Actor obj) {
        entityManager.getTransaction().begin();
        entityManager.persist(obj);
        entityManager.getTransaction().commit();
    }

    @Override
    public void update(Actor obj) {
        entityManager.getTransaction().begin();
        entityManager.merge(obj);
        entityManager.getTransaction().commit();
    }


    @Override
    public void remove(long id) {
        entityManager.getTransaction().begin();
        Optional<Actor> result = Optional.ofNullable(entityManager.find(Actor.class, id));
        result.ifPresent(entityManager::remove);
        entityManager.getTransaction().commit();
    }

    @Override
    public void close() throws Exception {
        entityManager.close();
    }
}
