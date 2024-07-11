import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayDeque61B<T> implements Deque61B<T> {
    private static int INITIAL_CAPACITY = 8;
    private T[] data;
    private int head;
    private int tail;
    private int size;
    private int capacity;

    public ArrayDeque61B() {
        data = (T[]) new Object[INITIAL_CAPACITY];
        head = data.length - 1;
        tail = 0;
        size = 0;
        capacity = INITIAL_CAPACITY;
    }

    private void resize() {
        T[] newData = (T[]) new Object[capacity * 2];
        if (tail == 0) {
            System.arraycopy(data, 0, newData, 0, capacity);
        } else {
            System.arraycopy(data, 0, newData, 0, tail);
            System.arraycopy(data, head + 1, newData, head + 1 + capacity, capacity - head - 1);
        }
        data = newData;
        head += capacity;
        capacity *= 2;
    }

    @Override
    public void addFirst(T x) {
        if (size == capacity) {
            resize();
        }
        data[head] = x;
        head--;
        if (head < 0) {
            head += capacity;
        }
        size++;
    }

    @Override
    public void addLast(T x) {
        if (size == capacity) {
            resize();
        }
        data[tail] = x;
        tail++;
        if (tail == capacity) {
            tail -= capacity;
        }
        size++;
    }

    @Override
    public List<T> toList() {
        List<T> list = new ArrayList<>();
        if (isFull()) {
            if (tail == 0) {
                list.addAll(Arrays.asList(data));
            } else {
                list.addAll(Arrays.asList(data).subList(head + 1, capacity));
                list.addAll(Arrays.asList(data).subList(0, tail));
            }
        } else if (head < tail) {
            list.addAll(Arrays.asList(data).subList(head + 1, tail));
        } else {
            list.addAll(Arrays.asList(data).subList(head + 1, capacity));
            list.addAll(Arrays.asList(data).subList(0, tail));
        }
        return list;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    private boolean isFull() {
        return size == capacity;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T removeFirst() {
        head++;
        if (head == capacity) {
            head -= capacity;
        }
        size--;
        return data[head];
    }

    @Override
    public T removeLast() {
        tail--;
        if (tail < 0) {
            tail += capacity;
        }
        size--;
        return data[tail];
    }

    @Override
    public T get(int index) {
        if (index >= size) {
            return null;
        }
        return data[(index + 1 + head) % capacity];
    }

    @Override
    public T getRecursive(int index) {
        throw new UnsupportedOperationException("No need to implement getRecursive for proj 1b");
    }
}
