package com.example.demo.abstractions;

import com.example.demo.shared.exceptions.NotFoundException;
import org.springframework.stereotype.Service;

@Service
public interface ICommandHandler<T extends ICommand>  {
    void execute(T command) throws NotFoundException;
}
