package com.example.demo.domain.books.queries;

import com.example.demo.domain.BaseQuery;
import com.example.demo.domain.IAppUnitOfWork;
import com.example.demo.domain.books.entities.Book;
import com.example.demo.shared.exceptions.NotFoundException;
import org.springframework.stereotype.Service;

@Service
public class BookByIdQuery extends BaseQuery {

    public BookByIdQuery(IAppUnitOfWork uow) {
        super(uow);
    }

    public Book execute(int id) throws NotFoundException {
        Book book = uow.getBookRepository().getById(id);
        if (book == null) {
            throw new NotFoundException();
        }

        return book;
    }
}
