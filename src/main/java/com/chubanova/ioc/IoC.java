package com.chubanova.ioc;

public class IoC {
    public static <T> T resolve(String key, Object[] args){
        ScopeDictionary scopesDictionary = ScopeDictionaryImpl.getInstance();
        IoCDictionary<T> handler = (IoCDictionary<T>) scopesDictionary.getCurrentScope();
        return handler.get(key, args);
    }
}
