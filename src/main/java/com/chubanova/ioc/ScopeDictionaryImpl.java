package com.chubanova.ioc;

import java.util.HashMap;
import java.util.Map;

public class ScopeDictionaryImpl implements ScopeDictionary<IoCDictionary>{
    private static final String SCOPE_NOT_EXIST = "Область видимости не существует";
    private static ScopeDictionaryImpl scopesDictionary;
    private final Map<String, IoCDictionary> mapHandler;
    private final Map<String, Thread> mapThead;
    private static IoCDictionary currentScope;

    private ScopeDictionaryImpl(){
        mapHandler = new HashMap<>();
        mapThead = new HashMap<>();
        currentScope = null;
    }

    public static ScopeDictionaryImpl getInstance(){
        if (scopesDictionary == null) {
            scopesDictionary = new ScopeDictionaryImpl();
        }
        return scopesDictionary;
    }

    @Override
    public IoCDictionary getCurrentScope() {
        return currentScope;
    }

    @Override
    public void createScope(String scopeName) {
        IoCDictionary ioCDictionary = new IoCDictionaryImpl();

        Thread thread = new Thread(ioCDictionary);
        thread.start();

        mapHandler.put(scopeName, ioCDictionary);
        mapThead.put(scopeName, thread);

        initializeCommandHandlerInScope(ioCDictionary);

        currentScope = ioCDictionary;
    }

    @Override
    public void changeScope(String toScopeName) {
        if (!mapHandler.containsKey(toScopeName)){
            new RuntimeException(SCOPE_NOT_EXIST);
        }

        currentScope = mapHandler.get(toScopeName);
    }

    private void initializeCommandHandlerInScope(IoCDictionary ioCDictionary){
        Initializer initializerCommandHandler = new InitializerCommandHandler();
        initializerCommandHandler.initialize(ioCDictionary);
    }
}
