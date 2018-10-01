package com.example.demo.domain.books.repositories;

import com.example.demo.domain.IRepository;
import com.example.demo.domain.books.entities.Book;

import java.util.List;

public interface IBookRepository extends IRepository<Book> {

    Book getById(int id);

    List<Book> getAll();
}
