package ru.ifmo.collections;

import java.util.*;

/**
 * Represents sorted set of unique values.
 * create() returns a SortedSet instance with natural ordering. (i.e. from smallest to largest in case of integer numbers)
 * from() is used to create a SortedSet instance with given Comparator.
 * Instances of a class can be created using only these two methods above.
 *
 * This class should not be abstract and should be capable of adding/removing single/multiple elements.
 * It has two more methods: getSorted() and getReversed() which return an array of set contents in forward and reverse order respectively.
 *
 * NB! This class must have only map(s) as an internal data structure(s).
 *
 * @param <T> set contents type
 */
public class SortedSet<T> extends AbstractSet<T> {
    private final TreeMap<T, Object> contents;

    public static <T> SortedSet<T> create() {
        return new SortedSet<>();
    }

    public static <T> SortedSet<T> from(Comparator<T> comparator) {
        return new SortedSet<>(comparator);
    }

    public SortedSet(Comparator<T> comparator) {
        contents = new TreeMap<>(comparator);
    }

    public SortedSet() {
        contents = new TreeMap<>();
    }

    @Override
    public boolean add(T t) {
        return contents.put(t, true) == null;
    }

    @Override
    public boolean remove(Object o) {
        if (o == null) {
            throw new IllegalArgumentException("Argument is null");
        }
        return contents.remove(o) == null;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        boolean added = false;
        for (T value : c) {
            added |= add(value);
        }
        return added;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        boolean removed = false;
        for (var value : c) {
            removed |= contents.remove(value) != null;
        }
        return removed;
    }

    @Override
    public Iterator<T> iterator() {
        return contents.keySet().iterator();
    }

    @Override
    public int size() {
        return contents.keySet().size();
    }

    public List<T> getSorted() {
        return new ArrayList<>(contents.keySet());
    }

    public List<T> getReversed() {
        return new ArrayList<>(contents.descendingKeySet());
    }
}
