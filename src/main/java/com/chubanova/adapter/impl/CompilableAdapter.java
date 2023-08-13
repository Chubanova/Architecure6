package com.chubanova.adapter.impl;

import com.chubanova.UObject;
import com.chubanova.adapter.Compilable;
import com.chubanova.ioc.IoC;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
public class CompilableAdapter implements Compilable {
    private final UObject uObject;

    @Override
    public Object[] getCompileFiles() {
        return IoC.resolve("CompilableAdapter.compileFiles.get", new Object[]{uObject});
    }

    @Override
    public void setCompileFiles(Object[] value) {
        IoC.resolve("CompilableAdapter.compileFiles.set", new Object[]{
                uObject, value
        });
    }
}
