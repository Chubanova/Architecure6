package com.chubanova;


import com.chubanova.adapter.Adapter;

public interface Movable extends Adapter {

    Vector getPosition();
    Vector getVelocity();
    void setPosition(Vector newV);
}
