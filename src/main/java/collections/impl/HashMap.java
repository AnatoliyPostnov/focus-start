package collections.impl;

import collections.Map;
import exceptions.incorrectIndex;

public class HashMap<K, V> implements Map<K, V> {
    private Integer size;
    private Node<K, V>[] tab;
    private int capacity;

    private static class Node<K, V> {
        private int hash;
        private V value;

        Node(K key, V value){
            this.value = value;
            hash = key.hashCode();
        }
    }

    public HashMap(){
        capacity = 16;
        size = 0;
        tab = new Node[capacity];
    }

    @Override
    public boolean insert(K key, V value) {
        //todo написать реализацию. Коллизии обрабатывать не надо
        Node<K, V> newNode = new Node<K, V>(key, value);
        int index = newNode.hash & capacity - 1;
        if (tab[index] == null) {
            ++size;
        }
        tab[index] = newNode;
        return true;
    }

    @Override
    public V get(K key) {
        //todo написать реализацию
        int index = key.hashCode() & capacity - 1;
        if (tab[index] != null){
            return tab[index].value;
        }else{
            throw new incorrectIndex();
        }
    }

    @Override
    public boolean delete(K key) {
        //todo написать реализацию
        int index = key.hashCode() & capacity - 1;
        if (tab[index] != null){
            tab[index] = null;
            --size;
            return true;
        }
        return false;
    }

    public int getSize(){
        return size;
    }
}
