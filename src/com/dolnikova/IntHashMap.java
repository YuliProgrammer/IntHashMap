package com.dolnikova;

import java.util.ArrayList;
import java.util.List;

public class IntHashMap implements IntMap {

    static class Entry {
        int key;
        int value;
        Entry next;

        Entry(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    Entry first;
    int count = 0;

    @Override
    public void put(int key, int val) {

        Entry entry = new Entry(key, val);

        if (count == 0) {
            first = entry;
            count++;
        } else {
            if (getVal(key) == null) {
                Entry last = getEntry(count - 1);
                last.next = entry;
                count++;
            } else {
                Entry en = first;
                for (int i = 0; i < count; i++) {
                    if (en.key == key) {
                        en.value = val;
                        break;
                    }
                    en = en.next;
                }
            }
        }
    }

    private Entry getEntry(int index) {
        Entry myElement = first;
        for (int i = 0; i < index; i++) {
            myElement = myElement.next;
        }

        return myElement;
    }

    @Override
    public Integer getVal(int key) {
        Entry entry = first;
        for (int i = 0; i < count; i++) {
            if (entry.key == key) {
                return entry.value;
            }
            entry = entry.next;
        }
        return null;
    }

    @Override
    public List<Integer> allValues() {
        List<Integer> listOfVal = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            listOfVal.add(getEntry(i).value);
        }
        return listOfVal;
    }

    @Override
    public Integer getKey(int val) {
        Entry entry = first;
        for (int i = 0; i < count; i++) {
            if (entry.value == val) {
                return entry.key;
            }
            entry = entry.next;
        }
        return null;
    }

    @Override
    public List<Integer> allKeys() {
        List<Integer> listOfKeys = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            listOfKeys.add(getEntry(i).key);
        }
        return listOfKeys;
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public void clear() {
        count = 0;
        first = null;
    }

    @Override
    public Integer remove(int key) {
        if (getVal(key) != null) {

            Entry entry = first;
            Integer deletedVal = null;

            for (int i = 0; i < count; i++) {
                if (entry.key == key) {
                    deletedVal = entry.value;
                    entry = entry.next;
                    continue;
                }

                entry.key = getKey(entry.value);
                entry.value = getVal(entry.key);

                if (i != 0) {
                    Entry last;
                    if (deletedVal != null) {
                        last = getEntry(i - 2);
                    } else {
                        last = getEntry(i - 1);
                    }

                    last.next = entry;
                }

                entry = entry.next;
            }

            count--;
            return deletedVal;

        } else {
            System.out.println("Null pointer exception.");
            return null;
        }
    }

    @Override
    public boolean containsKey(int key) {
        return getVal(key) != null;
    }

    @Override
    public boolean containsValue(int value) {
        return getKey(value) != null;
    }

    @Override
    public String toString() {

        Entry entry = first;

        StringBuilder sb = new StringBuilder();
        sb.append("{");

        for (int i = 0; i < count; i++) {
            sb.append("[");
            sb.append(entry.key);
            sb.append(",");
            sb.append(entry.value);
            sb.append("]");

            entry = entry.next;
        }

        sb.append("}");
        return sb.toString();
    }
}
