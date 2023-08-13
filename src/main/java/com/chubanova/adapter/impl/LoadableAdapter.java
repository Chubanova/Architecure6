package com.chubanova.adapter.impl;

import com.chubanova.UObject;
import com.chubanova.adapter.Loadable;
import com.chubanova.ioc.IoC;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
public class LoadableAdapter implements Loadable {
    private final UObject uObject;

    @Override
    public Object[] getClasses() {
        return IoC.resolve("LoadableAdapter.classesName.get", new Object[]{uObject});
    }

    @Override
    public void setClasses(Object[] value) {
        IoC.resolve("LoadableAdapter.classesName.set", new Object[]{
                uObject, value
        });
    }
}
