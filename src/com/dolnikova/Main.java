package com.dolnikova;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        IntMap map = new IntHashMap();
        map.put(0, 3);
        map.put(1, 5);
        map.put(2, 7);
        System.out.println(map.toString());

        System.out.println("Key by value " + map.getKey(7));
        System.out.println("Value by key " + map.getVal(7));
        System.out.println("Value by key " + map.getVal(0));

        map.put(0, -33);
        System.out.println(map.toString());

        System.out.println("Deleted value = " + map.remove(1));
        System.out.println(map.toString());

        map.remove(1);
        System.out.println();

        map.put(11, 333);
        map.put(15, 6);
        map.put(7, -70);
        System.out.println(map.toString());

        map.put(11, 0);
        System.out.println(map.toString());

        System.out.println("Size = " + map.size());
        System.out.println("Is empty? " + map.isEmpty());

        System.out.println("Contains key ? " + map.containsKey(11));
        System.out.println("Contains value ? " + map.containsValue(-9));

        List<Integer> allVal = map.allValues();
        System.out.println("All values: " + allVal);

        List<Integer> allKey = map.allKeys();
        System.out.println("All keys: " + allKey);

        map.clear();
        System.out.println(map.toString());

    }
}
