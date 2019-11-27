package collections.impl;

import collections.List;
import exceptions.incorrectIndex;

import java.util.Iterator;
import java.util.Objects;

public class LinkedList<E> implements List<E> {

    private Node head;
    private Node tail;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        String test = (String) o;
        StringBuilder result = new StringBuilder();
        Iterator thisIter = iterator();
        while (thisIter.hasNext()) {
            result.append(thisIter.next());
            result.append(" ");
        }
        return result.toString().equals(test);
    }

    @Override
    public int hashCode() {
        return Objects.hash(head, tail, size);
    }

    private int size;

    public LinkedList(E value) {
        head = new Node(value);
        tail = head;
        size = 1;
    }

    public LinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    class Node {
        E value;
        Node next = null;
        Node prev = null;

        Node(E value) {
            this.value = value;
        }
    }

    @Override
    public boolean add(E e) {
        //todo написать реализацию
        if (head != null) {
            Node newElement = new Node(e);
            tail.next = newElement;
            newElement.prev = tail;
            tail = newElement;
            ++size;
        } else {
            head = new Node(e);
            tail = head;
            size = 1;
        }
        return true;
    }

    public void add(E e, int index) {
        //todo написать реализацию
        if (index > size + 1) {
            throw new incorrectIndex();
        }

        Node newElement = new Node(e);
        Node nextElement = head;
        for (int i = 0; i < index; ++i) {
            nextElement = nextElement.next;
        }

        Node prevElement = nextElement.prev;
        newElement.prev = prevElement;
        newElement.next = nextElement;
        if (head == nextElement) {
            head = newElement;
        }
        if (prevElement != null) {
            prevElement.next = newElement;
        }
        nextElement.prev = newElement;
        ++size;
    }

    @Override
    public E remove(int index) {
        //todo написать реализацию
        if (index > size) {
            throw new incorrectIndex();
        }

        Node removeElement = head;
        for (int i = 0; i < index; ++i) {
            removeElement = removeElement.next;
        }

        if (removeElement != head && removeElement != tail) {
            Node prev = removeElement.prev;
            Node next = removeElement.next;
            prev.next = next;
            next.prev = prev;
        } else if (removeElement == tail) {
            tail = tail.prev;
            tail.next = null;
        } else {
            head = removeElement.next;
            removeElement.prev = null;
        }

        --size;
        return removeElement.value;
    }

    @Override
    public E get(int index) {
        //todo написать реализацию
        if (index > size) {
            throw new incorrectIndex();
        }

        Node nextElement = head;
        for (int i = 0; i < index; ++i) {
            nextElement = nextElement.next;
        }
        return nextElement.value;
    }

    @Override
    public Iterator<E> iterator() {
        //todo написать реализацию
        return new Iterator<E>() {
            Node currentElement = head;
            int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return size >= currentIndex + 1;
            }

            @Override
            public E next() {
                if (head != null && currentIndex == 0) {
                    currentElement = head;
                }
                Node tmp = currentElement;
                currentElement = currentElement.next;
                ++currentIndex;
                return tmp.value;
            }
        };
    }

    public Integer getSize() {
        return size;
    }
}
