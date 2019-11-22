package collections.impl;

import MyExceptions.MyLinkedListException;
import collections.List;

import java.util.Iterator;

public class LinkedList<E> implements List<E> {

    private Node head;
    private Node tail;
    private int size;

    public LinkedList(E value){
        head = new Node(value);
        tail = head;
        size = 1;
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
        Node newElement = new Node(e);
        tail.next = newElement;
        newElement.prev = tail;
        tail = newElement;
        ++size;
        return true;
    }

    public void add(E e, int index){
        //todo написать реализацию
        if (index > size + 1){
            throw new MyLinkedListException();
        }

        Node newElement = new Node(e);
        Node nextElement = head;
        for (int i = 0; i < index; ++i){
            nextElement = nextElement.next;
        }

        Node prevElement = nextElement.prev;
        newElement.prev = prevElement;
        newElement.next = nextElement;
        if (head == nextElement){
            head = newElement;
        }
        if (prevElement != null) {
            prevElement.next = newElement;
        }
        nextElement.prev = newElement;
        ++size;
    }

    @Override
    public E remove(int index){
        //todo написать реализацию
        if (index > size){
            throw new MyLinkedListException();
        }

        Node removeElement = head;
        for (int i = 0; i < index; ++i){
            removeElement = removeElement.next;
        }

        if (removeElement != head && removeElement != tail) {
            Node prev = removeElement.prev;
            Node next = removeElement.next;
            prev.next = next;
            next.prev = prev;
        }else if (removeElement == tail){
            tail = tail.prev;
            tail.next = null;
        }else{
            head = removeElement.next;
            removeElement.prev = null;
        }

        --size;
        return removeElement.value;
    }

    @Override
    public E get(int index){
        //todo написать реализацию
        if (index > size){
            throw new MyLinkedListException();
        }

        Node nextElement = head;
        for (int i = 0; i < index; ++i){
            nextElement = nextElement.next;
        }
        return nextElement.value;
    }

    @Override
    public Iterator<E> iterator() {
        //todo написать реализацию
        return new Iterator<E>() {
            Node currentElement = head;
            int currentSize = 1;

            @Override
            public boolean hasNext() {
                return size >= currentSize;
            }

            @Override
            public E next() {
                Node tmp = currentElement;
                currentElement = currentElement.next;
                ++currentSize;
                return tmp.value;
            }
        };
    }

    public Integer getSize(){
        return size;
    }
}
