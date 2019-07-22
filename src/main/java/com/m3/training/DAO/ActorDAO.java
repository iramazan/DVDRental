package com.m3.training.DAO;

import com.m3.training.SQLObject.Actor;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Optional;

public class ActorDAO implements CRUD<Actor> {

    private final EntityManager em;

    public ActorDAO() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("oracle-connection");
        em = emf.createEntityManager();
    }

    @Override
    public Optional<Actor> getForID(long id) {
        em.getTransaction().begin();
        Optional<Actor> result = Optional.ofNullable(em.find(Actor.class, id));
        em.getTransaction().commit();
        return result;
    }

    @Override
    public void create(Actor obj) {

    }

    @Override
    public void update(Actor obj) {

    }

    @Override
    public void remove(long id) {

    }
}
