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
        Node<T> newNode = new Node<T>((T) item, null, null);
        if (head.var == newNode.var) {
            head = head.next;
            head.prev = null;
            size--;
            return true;
        }
        Node<T> ptr = head.next;
        while (ptr != null) {
            if (ptr.var == newNode.var) {
                Node<T> temp = ptr.prev;
                temp.next = ptr.next;
                Node<T> temp2 = ptr.next;
                temp2.prev = temp;
                size--;
                return true;
            }
            ptr = ptr.next;
        }
        return false;
    }

    @Override
    public Object remove(int index) {
        checkIndex(index);
        if (index == 0) {
            Object removed = head.var;
            if (size == 1) {
                head = null;
                tail = null;
                size = 0;
                return removed;
            }
            head = head.next;
            head.prev = null;
            size--;
            return removed;
        }
        if (index == size-1) {
            Object removed = tail.var;
            tail = tail.prev;
            tail.next = null;
            size--;
            return removed;
        }
        Node<T> ptr = head.next;
        for (int i = 1; i <= size; i++) {
            if (index == i) {
                Node<T> p = ptr.prev;
                Node<T> n = ptr.next;
                Object removed = ptr.var;

                p.next = n;
                n.prev = p;
                size--;
                return removed;
            }
            ptr = ptr.next;
        }
        return null;
    }

    @Override
    public void clear() {
        this.head = null;
        this.tail = null;
        size = 0;
    }

    @Override
    public Object get(int index) {
        checkIndex(index);
        if (index == 0) {
            return head.var;
        }
        Node<T> newNode = head.next;
        for (int i = 1; i <= size; i++) {
            if (i == index) {
                return newNode.var;
            }
            newNode = newNode.next;
        }
        return null;
    }

    @Override
    public int indexOf(Object o) {
        Node<T> newNode = new Node<T>((T) o, null, null);
        if (head.var == newNode.var) {
            return 0;
        }
        Node<T> ptr = head.next;
        for (int i = 1; i <= size; i++) {
            if (ptr.var == newNode.var) {
                return i;
            }
            ptr = ptr.next;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        Node<T> newNode = new Node<T>((T) o, null, null);
        if (tail.var == newNode.var) {
            return size-1;
        }
        Node<T> ptr = tail.prev;
        for (int i = size-1; i >= 1; i--) {
            if (ptr.var == newNode.var) {
                return i;
            }
            ptr = ptr.prev;
        }
        return -1;
    }

    @Override
    public void sort() {
        if (isTrueForSort()) {
            Node<T> front = head;
            Node<T> back = null;
            while (front != null) {
                back = front.next;
                while (back != null && back.prev != null && (Integer)back.var<(Integer)back.prev.var) {
                    swapValue(back, back.prev);
                    back = back.prev;
                }
                front = front.next;
            }
        }

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