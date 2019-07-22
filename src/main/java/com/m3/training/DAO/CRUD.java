package com.m3.training.DAO;

import java.util.Optional;

public interface CRUD<T> {
    Optional<T> getForID(long id);
    void create(T obj);
    void update(T obj);
    void remove(long id);
}
