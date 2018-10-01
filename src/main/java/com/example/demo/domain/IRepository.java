package com.example.demo.domain;

public interface IRepository<T> {

    void add(T enitity);

    void remove(T entity);
}
