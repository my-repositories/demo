package com.example.demo.domain.books.handlers;

import com.example.demo.domain.CommandHandlerBase;
import com.example.demo.domain.IAppUnitOfWork;
import com.example.demo.domain.books.commands.CreateBookCommand;
import com.example.demo.domain.books.entities.Book;
import org.springframework.stereotype.Service;

@Service
public class CreateBookCommandHandler extends CommandHandlerBase<CreateBookCommand> {

    protected CreateBookCommandHandler(IAppUnitOfWork uow) {
        super(uow);
    }

    @Override
    public void execute(CreateBookCommand command) {
        Book book = new Book();
        book.genre = command.genre;
        book.price = command.price;
        book.publishDate = command.publishDate;
        book.quantity = command.quantity;
        book.title = command.title;
        book.id = 1 + this.uow.getBookRepository().getAll().size();

        this.uow.getBookRepository().add(book);
    }
}
