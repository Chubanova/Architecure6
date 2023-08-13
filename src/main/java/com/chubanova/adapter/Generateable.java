package com.chubanova.adapter;

public interface Generateable extends Adapter {
    Object[] getSourceFiles();

    void setSourceFiles(Object[] value);
}
