package com.example.demo.data.access.repositories;

import com.example.demo.domain.books.entities.Book;
import com.example.demo.domain.books.repositories.IBookRepository;

import java.util.ArrayList;
import java.util.List;

public class BookRepository implements IBookRepository {

    private List<Book> books = new ArrayList<>();

    @Override
    public Book getById(int id) {
        for (Book book : books) {
            if (book.id == id) {
                return book;
            }
        }

        return null;
    }

    @Override
    public List<Book> getAll() {
        return this.books;
    }

    @Override
    public void add(Book enitity) {
        this.books.add(enitity);
    }

    @Override
    public void remove(Book entity) {
        this.books.remove(entity);
    }
}
