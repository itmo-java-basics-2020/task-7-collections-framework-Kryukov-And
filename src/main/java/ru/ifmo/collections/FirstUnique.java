package ru.ifmo.collections;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Design a class which contains integers and returns first unique integer (in order of addition).
 * FirstUniqueTest can be used as an example.
 */
public class FirstUnique {
    private final Queue<Integer> unique;
    private final ArrayList<Integer> unsuitable;

    public FirstUnique(int[] numbers) {
        unique = new LinkedList<>();
        unsuitable = new ArrayList<>();

        for (var number : numbers) {
            add(number);
        }
    }

    public int showFirstUnique() {
        if (unique.isEmpty()) {
            return -1;
        } else {
            return unique.peek();
        }
    }

    public void add(int value) {
        if (!unsuitable.contains(value)) {
            if (unique.contains(value)) {
                unique.remove(value);
                unsuitable.add(value);
            }
            else {
                unique.add(value);
            }
        }
    }
}
