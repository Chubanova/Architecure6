package com.chubanova.ioc;

import com.chubanova.Command;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CreateScopeCommand implements Command {
    private final Object[] args;

    @Override
    public void execute() {
        ScopeDictionary scopesDictionary = ScopeDictionaryImpl.getInstance();
        scopesDictionary.createScope(String.valueOf(args[0]));
    }
}
