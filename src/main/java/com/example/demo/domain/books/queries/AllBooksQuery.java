package com.example.demo.domain.books.queries;

import com.example.demo.domain.BaseQuery;
import com.example.demo.domain.IAppUnitOfWork;
import com.example.demo.domain.books.entities.Book;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AllBooksQuery extends BaseQuery {

    public AllBooksQuery(IAppUnitOfWork uow) {
        super(uow);
    }

    public List<Book> execute() {
        return uow.getBookRepository().getAll();
    }
}
