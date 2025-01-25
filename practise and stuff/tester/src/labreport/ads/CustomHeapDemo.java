package labreport.ads;

import java.util.*;

class CustomHeap {
    private List<Integer> heap;
    private boolean isMinHeap;
    public CustomHeap(boolean isMinHeap) {
        this.heap = new ArrayList<>();
        this.isMinHeap = isMinHeap;
    }
    public void add(int value) {
        heap.add(value);
        heapifyUp(heap.size() - 1);
    }
    public int poll() {
        if (heap.isEmpty()) throw new NoSuchElementException("Heap is empty");
        int top = heap.get(0);
        heap.set(0, heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);
        heapifyDown(0);
        return top;
    }
    private void heapifyUp(int index) {
        int parentIndex = (index - 1) / 2;
        if (index > 0 && compare(heap.get(index), heap.get(parentIndex))) {
            Collections.swap(heap, index, parentIndex);
            heapifyUp(parentIndex);
        }
    }
    private void heapifyDown(int index) {
        int leftChild = 2 * index + 1;
        int rightChild = 2 * index + 2;
        int extremum = index;

        if (leftChild < heap.size() && compare(heap.get(leftChild), heap.get(extremum))) {
            extremum = leftChild;
        }
        if (rightChild < heap.size() && compare(heap.get(rightChild), heap.get(extremum))) {
            extremum = rightChild;
        }

        if (extremum != index) {
            Collections.swap(heap, index, extremum);
            heapifyDown(extremum);
        }
    }
    private boolean compare(int child, int parent) {
        return isMinHeap ? child < parent : child > parent;
    }
    public boolean isEmpty() {
        return heap.isEmpty();
    }
    public void display() {
        System.out.println(heap);
    }
}

public class CustomHeapDemo {
    public static void main(String[] args) {
        // Min Heap
        CustomHeap minHeap = new CustomHeap(true);
        System.out.println("Min Heap:");
        minHeap.add(3);
        minHeap.add(1);
        minHeap.add(6);
        minHeap.add(5);
        minHeap.add(2);
        minHeap.add(4);
        while (!minHeap.isEmpty()) {
            System.out.print(minHeap.poll() + " ");
        }
        System.out.println();

        // Max Heap
        CustomHeap maxHeap = new CustomHeap(false);
        System.out.println("Max Heap:");
        maxHeap.add(3);
        maxHeap.add(1);
        maxHeap.add(6);
        maxHeap.add(5);
        maxHeap.add(2);
        maxHeap.add(4);
        while (!maxHeap.isEmpty()) {
            System.out.print(maxHeap.poll() + " ");
        }
    }
}
