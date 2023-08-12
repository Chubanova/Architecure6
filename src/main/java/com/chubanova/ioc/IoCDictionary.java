package com.chubanova.ioc;

import java.util.function.Function;

public interface IoCDictionary<T> extends Runnable{
    void add(String commandName, Function<Object[],T> returnObject);
    T get(String commandName, Object[] args);
}
