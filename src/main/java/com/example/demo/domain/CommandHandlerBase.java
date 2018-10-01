package com.example.demo.domain;

import com.example.demo.abstractions.ICommand;
import com.example.demo.abstractions.ICommandHandler;
import com.example.demo.shared.exceptions.NotFoundException;

public abstract class CommandHandlerBase<TCommand extends ICommand> implements ICommandHandler<TCommand> {

    protected IAppUnitOfWork uow;

    protected CommandHandlerBase(IAppUnitOfWork uow) {
        this.uow = uow;
    }

    @Override
    public abstract void execute(TCommand command) throws NotFoundException;
}
