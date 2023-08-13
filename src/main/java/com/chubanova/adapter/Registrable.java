package com.chubanova.adapter;

public interface Registrable extends Adapter {
    Object[] getRegisterNames();

    void setRegisterNames(Object[] value);
}
