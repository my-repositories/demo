package com.example.demo.domain;

import com.example.demo.abstractions.IUnitOfWork;
import com.example.demo.domain.books.repositories.IBookRepository;

public interface IAppUnitOfWork extends IUnitOfWork {

    IBookRepository getBookRepository();
}