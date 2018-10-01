package com.example.demo.domain.books.handlers;

import com.example.demo.domain.CommandHandlerBase;
import com.example.demo.domain.IAppUnitOfWork;
import com.example.demo.domain.books.commands.DeleteBookCommand;
import com.example.demo.domain.books.entities.Book;
import com.example.demo.shared.exceptions.NotFoundException;
import org.springframework.stereotype.Service;

@Service
public class DeleteBookCommandHandler extends CommandHandlerBase<DeleteBookCommand> {

    protected DeleteBookCommandHandler(IAppUnitOfWork uow) {
        super(uow);
    }

    @Override
    public void execute(DeleteBookCommand command) throws NotFoundException {
        Book book = this.uow.getBookRepository().getById(command.id);
        if (book == null) {
            throw new NotFoundException();
        }

        this.uow.getBookRepository().remove(book);
    }
}
