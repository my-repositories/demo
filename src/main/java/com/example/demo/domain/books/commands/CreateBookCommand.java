package com.example.demo.domain.books.commands;

import com.example.demo.abstractions.ICommand;

public class CreateBookCommand implements ICommand {

    public String genre;

    public int quantity;

    public int price;

    public String publishDate;

    public String title;
}
