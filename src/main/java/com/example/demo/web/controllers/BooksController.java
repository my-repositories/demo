package com.example.demo.web.controllers;

import com.example.demo.domain.books.commands.CreateBookCommand;
import com.example.demo.domain.books.commands.DeleteBookCommand;
import com.example.demo.domain.books.entities.Book;
import com.example.demo.domain.books.queries.AllBooksQuery;
import com.example.demo.domain.books.queries.BookByIdQuery;
import com.example.demo.infrastructure.CommandFactory;
import com.example.demo.infrastructure.QueryFactory;
import com.example.demo.shared.exceptions.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("books")
public class BooksController {

    private CommandFactory commandFactory;
    private QueryFactory queryFactory;

    public BooksController(CommandFactory commandFactory, QueryFactory queryFactory) {
        this.commandFactory = commandFactory;
        this.queryFactory = queryFactory;
    }

    @GetMapping("")
    public ResponseEntity getAll() {
        List<Book> data = this.queryFactory.resolveQuery(AllBooksQuery.class).execute();
        return new ResponseEntity(data, HttpStatus.OK);
    }

    @GetMapping("{id}")
    public ResponseEntity getById(@PathVariable int id) throws NotFoundException {
        Book data = this.queryFactory.resolveQuery(BookByIdQuery.class).execute(id);
        return new ResponseEntity(data, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity create(@RequestBody CreateBookCommand command) throws NotFoundException {
        this.commandFactory.execute(command);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity deleteById(@PathVariable int id) throws NotFoundException {
        this.commandFactory.execute(new DeleteBookCommand(id));
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
