package com.example.demo.infrastructure;

import com.example.demo.abstractions.IQuery;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class QueryFactory {

    private ApplicationContext ctx;

    public QueryFactory(ApplicationContext ctx) {
        this.ctx = ctx;
    }

    public <T extends IQuery> T resolveQuery(Class<T> tClass) {
        return ctx.getBean(tClass);
    }
}
