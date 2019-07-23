package com.m3.training.DAO;

import com.m3.training.SQLObject.Inventory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class InventoryDAOTest {
    InventoryDAO inventoryDAO;

    @BeforeEach
    void before() {
        inventoryDAO = new InventoryDAO();
    }

    @Test
    void test_InventoryDAOTest_getByIDTest() {
        Optional<Inventory> result = inventoryDAO.getForID(9);
        assertTrue(result.isPresent());
    }
}
