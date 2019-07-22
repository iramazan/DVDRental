package com.m3.training.DAO;

import com.m3.training.SQLObject.Actor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ActorDAOTest {

    ActorDAO actorDAO;

    @BeforeEach
    void before() {
        actorDAO = new ActorDAO();
    }

    @Test
    void test_ActorDAOTest_getByIDTest() {
        Optional<Actor> result = actorDAO.getForID(9);
        assertTrue(result.isPresent());
    }

}
