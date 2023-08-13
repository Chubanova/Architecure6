package com.chubanova.adapter.impl;

import com.chubanova.UObject;
import com.chubanova.adapter.Registrable;
import com.chubanova.ioc.IoC;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
public class RegistrableAdapter implements Registrable {
    private final UObject uObject;

    @Override
    public Object[] getRegisterNames() {
        return IoC.resolve("RegistrableAdapter.registerName.get", new Object[]{uObject});
    }

    @Override
    public void setRegisterNames(Object[] value) {
        IoC.resolve("RegistrableAdapter.registerName.set", new Object[]{
                uObject, value
        });
    }
}
