package com.chubanova.ioc;

import com.chubanova.Command;
import lombok.RequiredArgsConstructor;

import java.util.function.Function;

@RequiredArgsConstructor
public class RegisterCommand implements Command {
    private final Object[] args;

    @Override
    public void execute() {
        ScopeDictionary<IoCDictionary> scopesDictionary = ScopeDictionaryImpl.getInstance();
        IoCDictionary handler = scopesDictionary.getCurrentScope();
        handler.add(String.valueOf(args[0])
                  , (Function<Object[], Object>) args[1]);
    }
}
