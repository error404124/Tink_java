package edu.hw3.Task8;

import java.util.Iterator;
import java.util.List;

public class BackwardIterator<T> implements Iterator<Object> {
    private final List<T> arr;
    private int index = 0;

    public BackwardIterator(List<T> elements) {
        this.arr = elements;
        this.index = elements.size() - 1;
    }

    @Override
    public boolean hasNext() {
        return index >= 0;
    }

    @Override
    public T next() {
        if (hasNext()) {
            T element = arr.get(index);
            index--;
            return element;
        } else {
            return null;
        }
    }
}
