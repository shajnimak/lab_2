import repository.MyArray;

public class MyLinkedList<T> implements MyArray {
    private class Node<T> {
        T var;
        Node<T> next;
        Node<T> prev;

        Node(T val, Node<T> next, Node<T> prev) {
            this.var = val;
            this.next = next;
            this.prev = prev;
        }
    }

    private Node<T> head;
    private Node<T> tail;
    private int size;

    public MyLinkedList() {
        this.head = null;
        this.tail = null;
        size = 0;
    }
    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean contains(Object o) {
        if (head.var == o) {
            return true;
        }
        Node<T> ptr = head.next;
        while (ptr != null) {
            if (ptr.var == o) {
                return true;
            }
            ptr = ptr.next;
        }
        return false;
    }

    @Override
    public void add(Object item) {
        Node<T> newNode = new Node<T>((T) item, null, null);
        if (head == null) {
            head = newNode;
            tail = head;
        }
        else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    @Override
    public void add(Object item, int index) {
        checkIndex(index);
        Node<T> newNode = new Node<T>((T) item, null, null);
        if (index == 0) {
            add(item);
            return;
        }
        Node<T> ptr = head;
        for (int i = 1; i <= size; i++) {
            if (i == index) {
                Node<T> temp = ptr.next;
                ptr.next = newNode;
                newNode.prev = ptr;
                newNode.next = temp;
                temp.prev = newNode;
            }
            ptr = ptr.next;
        }
        size++;
    }

    @Override
    public boolean remove(Object item) {
        return false;
    }

    @Override
    public Object remove(int index) {
        return null;
    }

    @Override
    public void clear() {

    }

    @Override
    public Object get(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public void sort() {

    }
    public void swapValue(Node<T> one, Node<T> two) {
        Object val = one.var;
        one.var = two.var;
        two.var = (T) val;
    }
    public void checkIndex(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
    }
    public boolean isTrueForSort() {
        Node<T> header = head;
        int len = 0;
        int secondSize = 0;
        for (int i = 1; i <= size; i++) {
            try {
                len++;
            } catch (ClassCastException e) {
            }
            try {
                secondSize++;
            } catch (ClassCastException e) {
            }
            header = header.next;
        }
        if (len==size || secondSize==size || secondSize+len==size) {
            return true;
        }
        return false;
    }

}