package com.chubanova.ioc;

import com.chubanova.Command;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ChangeScopeCommand implements Command {

    private final Object[] args;

    @Override
    public void execute() {
        ScopeDictionary scopesDictionary = ScopeDictionaryImpl.getInstance();
        scopesDictionary.changeScope(String.valueOf(args[0]));
    }
}
