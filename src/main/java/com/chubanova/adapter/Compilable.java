package com.chubanova.adapter;

public interface Compilable extends Adapter {
    Object[] getCompileFiles();

    void setCompileFiles(Object[] value);
}
