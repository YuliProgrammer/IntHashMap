package com.dolnikova;

import java.util.List;

public interface IntMap {

    void put(int key, int val);

    Integer getVal(int key);
    List<Integer> allValues();

    Integer getKey(int val);
    List<Integer> allKeys();

    int size();
    boolean isEmpty();
    void clear();
    Integer remove(int key);

    boolean containsKey(int key);
    boolean containsValue(int value);

    String toString();

}
