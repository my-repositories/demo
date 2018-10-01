package com.example.demo.abstractions;

public interface IQueryFactory {
    <T extends IQuery> T resolveQuery();
}
