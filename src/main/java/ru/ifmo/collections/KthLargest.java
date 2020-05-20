package ru.ifmo.collections;

import java.util.PriorityQueue;

/**
 * Design a class to find the kth largest element in a stream. k is from 1 to numbers.length.
 * Note that it is the kth largest element in the sorted order, not the kth distinct element.
 *
 * Constructor accepts an integer k and an integer array numbers, which contains initial elements from the stream.
 * For each call to the method KthLargest.add(), return the element representing the kth largest element in the stream.
 */
public class KthLargest {
    private final int k;
    private final PriorityQueue<Integer> queue;

    public KthLargest(int k, int[] numbers) {
        queue = new PriorityQueue<>();

        this.k = k;
        for (var number : numbers) {
            queue.add(number);
        }
    }

    public int add(int val) {
        queue.add(val);
        while (queue.size() > k) {
            queue.poll();
        }
        return queue.peek();
    }
}