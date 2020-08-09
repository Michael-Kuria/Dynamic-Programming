package com.michael;

public class Pair<T,V> {

    public T f;
    public V s;

    public Pair(){}

    public Pair(T f, V s){
        this.f = f;
        this.s = s;
    }

    public void setAll(T f, V s){
        this.f = f;
        this.s = s;
    }

    @Override
    public String toString(){
        return "[" + f +", " +s +"]";
    }
}
