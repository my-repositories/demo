package com.example.demo.infrastructure;

import com.example.demo.abstractions.ICommand;
import com.example.demo.abstractions.ICommandFactory;
import com.example.demo.abstractions.ICommandHandler;
import com.example.demo.shared.exceptions.NotFoundException;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.lang.reflect.ParameterizedType;
import java.util.Map;

@Service
public class CommandFactory implements ICommandFactory {

    private ApplicationContext ctx;

    public CommandFactory(ApplicationContext ctx) {
        this.ctx = ctx;
    }

    @Override
    public <T extends ICommand> void execute(T command) throws NotFoundException {
        Map<String, ICommandHandler> commandHandlers = this.ctx.getBeansOfType(ICommandHandler.class);
        if (commandHandlers == null || commandHandlers.size() == 0) {
            throw new IllegalArgumentException("Unkown command: " + command.getClass().toString());
        }

        String commandName = command.getClass().getSimpleName();
        for (ICommandHandler handler : commandHandlers.values()) {
            ParameterizedType type = (ParameterizedType)handler.getClass().getGenericSuperclass();
            Class parameter = (Class)type.getActualTypeArguments()[0];
            if (parameter.getSimpleName() == commandName) {
                handler.execute(command);
            }
        }
    }
}
