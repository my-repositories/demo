package com.example.demo.domain;

import com.example.demo.abstractions.IQuery;

public abstract class BaseQuery implements IQuery {

    protected IAppUnitOfWork uow;

    protected BaseQuery(IAppUnitOfWork uow) {
        this.uow = uow;
    }
}