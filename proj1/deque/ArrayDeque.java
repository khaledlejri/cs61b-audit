package deque;

public class ArrayDeque<T> implements Deque<T>{
    private T[] items;
    private int size;
    private int capacity;
    private int nextFirst;
    private int nextTail;

    public ArrayDeque(){
        capacity = 8;
        items = (T[]) new Object[capacity];
        size = 0;
        nextFirst = 3;
        nextTail = 4;
    }

    @Override
    public void addFirst(T item) {
        if(size == capacity){
            System.out.println("We need to resize the array");
            resize();
        }
        //if(head < 0){}
        items[nextFirst] = item;
        nextFirst = Math.floorMod(nextFirst - 1, capacity);
        size += 1;

    }

    @Override
    public void addLast(T item) {
        if(size == capacity){
            System.out.println("We need to resize the array");
            resize();
        }
        items[nextTail] = item;
        nextTail = Math.floorMod(nextTail + 1, capacity);
        size += 1;
    }

    @Override
    public boolean isEmpty() {
        return Deque.super.isEmpty();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void printDeque() {
        System.out.print("Array deque elements are: ");
        for (T item: items) {
            System.out.print(item + " ");
        }
        System.out.println();
    }

    @Override
    public T removeFirst() {
        if (size == 0) return null;
        int firstIndex = Math.floorMod((nextFirst + 1), capacity);
        T value = items[firstIndex];
        items[firstIndex] = null;
        nextFirst = firstIndex;
        size -= 1;
        return value;
    }

    @Override
    public T removeLast() {
        if (size == 0) return null;
        int lastIndex = Math.floorMod((nextTail - 1), capacity);
        T  value = items[lastIndex];
        items[lastIndex] = null;
        nextTail = lastIndex;
        size -= 1;
        return value;
    }

    @Override
    public T get(int index) {
        if (size == 0 || index >= size) {
            return null;
        }
        int newIndex = Math.floorMod((nextFirst + 1 + index), items.length);
        return items[newIndex];
    }

    private void resize(){
        int newCapacity = capacity * 2;
        T[] newItems = (T[]) new Object[newCapacity];
        for (int i = 0; i < size; i += 1) {
            newItems[i] = get(i);
        }
        items = newItems;
        capacity = newCapacity;
        nextFirst = capacity - 1;
        nextTail = size;
    }
}
