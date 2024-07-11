import java.util.ArrayList;
import java.util.List;

public class LinkedListDeque61B<T> implements Deque61B<T> {
    class Node {
        T data;
        Node prev;
        Node next;

        public Node(T data) {
            this.data = data;
            prev = null;
            next = null;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public LinkedListDeque61B() {
        head = new Node(null);
        tail = new Node(null);
        size = 0;
    }

    @Override
    public void addFirst(T x) {
        Node node = new Node(x);
        if (size == 0) {
            head = node;
            tail = node;
        } else {
            node.next = head;
            head.prev = node;
            head = node;
        }
        size++;
    }

    @Override
    public void addLast(T x) {
        Node node = new Node(x);
        if (size == 0) {
            head = node;
        } else {
            tail.next = node;
            node.prev = tail;
        }
        tail = node;
        size++;
    }

    @Override
    public List<T> toList() {
        List<T> list = new ArrayList<>();
        for (Node node = head; node != null; node = node.next) {
            list.add(node.data);
        }
        return list;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T removeFirst() {
        Node node = head;
        head = head.next;
        head.prev = null;
        return node.data;
    }

    @Override
    public T removeLast() {
        Node node = tail;
        tail = tail.prev;
        tail.next = null;
        return node.data;
    }

    @Override
    public T get(int index) {
        try {
            Node node = head;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
            return node.data;
        } catch (NullPointerException e) {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public T getRecursive(int index) {
        return null;
    }
}
