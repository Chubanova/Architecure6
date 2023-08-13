package com.chubanova.adapter;

public interface Loadable extends Adapter {
    Object[] getClasses();

    void setClasses(Object[] value);
}
