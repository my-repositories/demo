package com.example.demo.domain.books.commands;

import com.example.demo.abstractions.ICommand;

public class DeleteBookCommand implements ICommand {

    public int id;

    public DeleteBookCommand(int id) {
        this.id = id;
    }
}
