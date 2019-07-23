package com.m3.training.DAO;

import com.m3.training.SQLObject.Actor;
import org.hibernate.Transaction;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.function.Executable;
import org.mockito.Mockito;

import javax.persistence.EntityManager;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ActorDAOTest {

    Actor actor;
    GenericDAO<Actor> objectUnderTest;
    GenericDAO<Actor> realObj;
    EntityManager mockEntityManager;

    @BeforeEach
    void before() {
        actor = mock(Actor.class);
        Transaction mockTransaction = Mockito.mock(Transaction.class);
        mockEntityManager = mock(EntityManager.class);
        when(mockEntityManager.getTransaction()).thenReturn(mockTransaction);
        objectUnderTest = new GenericDAO<>(mockEntityManager, Actor.class);
        realObj = new GenericDAO<>(Actor.class);
    }

    @AfterEach
    void after() {
        realObj.close();
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
        realObj.update(actor);
    }

    @Test
    void test_ActorDAOTest_getActors() {
        long id = 2;
        Optional<Actor> result = realObj.getForID(id);
        result.ifPresent(actor -> actor.getFilms().forEach(System.out::println));
    }

    @Test
    @Order(1)
    void test_ActorDAOTest_createReal() {
        Actor actor = new Actor();
        actor.setActorID(600);
        actor.setFirstName("John");
        actor.setLastName("Smith");
        realObj.create(actor);
    }

    @Test
    @Order(2)
    void test_ActorDAOTest_createAlreadyExists() {
        Actor actor = new Actor();
        actor.setActorID(2);
        actor.setFirstName("Nick");
        actor.setLastName("Wahlberg");
        Executable closure = () -> realObj.create(actor);
        String msg = "Create should throw an illegal state exception if trying to create an object that already exists.";
        assertThrows(IllegalStateException.class, closure, msg);
    }

    @Test
    @Order(3)
    void test_ActorDAOTest_updateReal() {
        Actor actor = new Actor();
        actor.setActorID(600);
        actor.setFirstName("Jan");
        actor.setLastName("Smith");
        realObj.update(actor);
    }

    @Test
    @Order(4)
    void test_ActorDAOTest_deleteReal() {
        long id = 600;
        realObj.remove(id);
    }
}
