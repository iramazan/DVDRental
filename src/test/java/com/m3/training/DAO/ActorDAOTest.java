package com.m3.training.DAO;

import com.m3.training.SQLObject.Actor;
import org.hibernate.Transaction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.persistence.EntityManager;

import static org.mockito.Mockito.*;

public class ActorDAOTest {

    Actor actor;
    ActorDAO objectUnderTest;
    EntityManager mockEntityManager;

    @BeforeEach
    void before() {
        actor = mock(Actor.class);
        Transaction mockTransaction = Mockito.mock(Transaction.class);
        mockEntityManager = mock(EntityManager.class);
        when(mockEntityManager.getTransaction()).thenReturn(mockTransaction);
        objectUnderTest = new ActorDAO(mockEntityManager);
    }

    @Test
    void test_ActorDAOTest_getByID() {
        long id = 9;
        objectUnderTest.getForID(id);
        verify(mockEntityManager, times(1)).find(Actor.class, id);
    }

    @Test
    void test_ActorDAOTest_create() {
        objectUnderTest.create(actor);
        verify(mockEntityManager, times(1)).persist(actor);
    }

    @Test
    void test_ActorDAOTest_update() {
        objectUnderTest.update(actor);
        verify(mockEntityManager, times(1)).merge(actor);
    }

    @Test
    void test_ActorDAOTest_remove() {
        long id = 9;
        Actor mockActor = mock(Actor.class);
        when(mockEntityManager.find(Actor.class, id)).thenReturn(mockActor);
        objectUnderTest.remove(id);
        verify(mockEntityManager, times(1)).remove(mockActor);
    }

    @Test
    void test_ActorDAOTest_updateNotExist() {
        Actor actor = new Actor();
        actor.setFirstName("John");
        actor.setLastName("Smith");
        ActorDAO dao = new ActorDAO();
        dao.update(actor);
    }

    @Test
    void test_ActorDAOTest_createReal() {
        Actor actor = new Actor();
        actor.setActorID(600);
        actor.setFirstName("John");
        actor.setLastName("Smith");
        ActorDAO dao = new ActorDAO();
        System.out.println(actor);
        dao.create(actor);
    }
}
