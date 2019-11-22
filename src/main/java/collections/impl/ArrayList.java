package collections.impl;

import MyExceptions.MyGetElementFromArrayListException;
import MyExceptions.MyRemoveElementFromArrayListException;
import collections.List;

import java.util.Iterator;


public class ArrayList<E> implements List<E> {
    private final static int ARRAY_SIZE_START = 10;
    private final static int CURSOR_START = 0;

    private int array_size;
    private int cursor;
    private Object[] elementData;

    public ArrayList(){
        elementData = new Object[ARRAY_SIZE_START];
        array_size = ARRAY_SIZE_START;
        cursor = CURSOR_START;
    }

    @Override
    public boolean add(E e) {
        //todo написать реализацию
        if (cursor < array_size){
            elementData[cursor++] = e;
            return true;
        }else {
            array_size = (array_size * 3) / 2 + 1;

            Object[] elementDataTmp = new Object[array_size];
            System.arraycopy(elementData, 0, elementDataTmp, 0, elementData.length);
            elementData = elementDataTmp;

            add(e);
            return true;
        }
    }

    @Override
    public E remove(int index) {
        //todo написать реализацию
        E element;
        if (index >= cursor || index < 0){
            throw new MyRemoveElementFromArrayListException();
        }else{
            element = (E) elementData[index];
            for (int i = index; i < cursor; ++i){
                if (array_size - 1 > i) {
                    elementData[i] = elementData[i + 1];
                }
            }
            --cursor;
        }
        return element;
    }

    @Override
    public E get(int index) {
        //todo написать реализацию
        if (index >= cursor || index < 0){
            throw new MyGetElementFromArrayListException();
        }
        return (E) elementData[index];
    }

    @Override
    public Iterator<E> iterator() {
        //todo написать реализацию
        return new Iterator<E>() {
            private int currentIndex = 0;
            @Override
            public boolean hasNext() {
                return currentIndex + 1 < cursor;
            }

            @Override
            public E next() {
                if(hasNext()) {
                    return (E) elementData[++currentIndex];
                }else {
                    throw new RuntimeException();
                }
            }
        };
    }

    public int getCursor() {
        return cursor;
    }

    public int getArraySize() {
        return array_size;
    }
}
