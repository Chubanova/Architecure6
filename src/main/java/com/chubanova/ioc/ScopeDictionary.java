package com.chubanova.ioc;

public interface ScopeDictionary<T> {
     T getCurrentScope();
     void createScope(String scopeName);
     void changeScope(String toScopeName);
}
