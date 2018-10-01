package com.example.demo.data.access;

import com.example.demo.data.access.repositories.BookRepository;
import com.example.demo.domain.IAppUnitOfWork;
import com.example.demo.domain.books.repositories.IBookRepository;
import org.springframework.stereotype.Service;

@Service
public class AppUnitOfWork implements IAppUnitOfWork {

    private IBookRepository bookRepository;

    @Override
    public IBookRepository getBookRepository() {
        if (this.bookRepository == null)
        {
            this.bookRepository = new BookRepository();
        }

        return this.bookRepository;
    }

    @Override
    public int saveChanges() {
        return 42;
    }
}
