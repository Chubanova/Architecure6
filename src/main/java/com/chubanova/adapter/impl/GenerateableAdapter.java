package com.chubanova.adapter.impl;

import com.chubanova.UObject;
import com.chubanova.adapter.Generateable;
import com.chubanova.ioc.IoC;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
public class GenerateableAdapter implements Generateable {
    private final UObject uObject;

    @Override
    public Object[] getSourceFiles() {
        return IoC.resolve("GenerateableAdapter.sourceFiles.get", new Object[]{uObject});
    }

    @Override
    public void setSourceFiles(Object[] value) {
        IoC.resolve("GenerateableAdapter.sourceFiles.set", new Object[]{
                uObject, value
        });
    }
}
