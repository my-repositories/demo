package com.example.demo.abstractions;

import com.example.demo.shared.exceptions.NotFoundException;

public interface ICommandFactory {
    <T extends ICommand> void execute(T command) throws NotFoundException;
}
