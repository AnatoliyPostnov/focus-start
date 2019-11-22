package collections.ArrayListTest;

import MyExceptions.MyLinkedListException;
import collections.impl.LinkedList;
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static junit.framework.TestCase.assertEquals;

public class LinkedListTest {
    private final static int CONST_INT = 15;
    private LinkedList<Integer> linkedList;

    @Before
    public void init(){
        linkedList = new LinkedList<>(CONST_INT);
    }

    @Test
    public void addEightElementTest(){
        linkedList.add(CONST_INT);
        linkedList.add(CONST_INT);
        linkedList.add(CONST_INT);
        linkedList.add(CONST_INT);
        linkedList.add(CONST_INT);
        linkedList.add(CONST_INT);
        linkedList.add(CONST_INT);
        Iterator<Integer> iter = linkedList.iterator();
        String test = "15 15 15 15 15 15 15 15 ";
        String result = "";
        while (iter.hasNext()){
            result += iter.next().toString() + " ";
        }
        assertEquals(java.util.Optional.of(8), java.util.Optional.of(linkedList.getSize()));
    }

    @Test
    public void getElementTest() throws MyLinkedListException {
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(5);
        linkedList.add(6);
        linkedList.add(7);
        assertEquals(java.util.Optional.of(15), java.util.Optional.of(linkedList.get(0)));
        assertEquals(java.util.Optional.of(1), java.util.Optional.of(linkedList.get(1)));
        assertEquals(java.util.Optional.of(2), java.util.Optional.of(linkedList.get(2)));
        assertEquals(java.util.Optional.of(3), java.util.Optional.of(linkedList.get(3)));
        assertEquals(java.util.Optional.of(4), java.util.Optional.of(linkedList.get(4)));
        assertEquals(java.util.Optional.of(7), java.util.Optional.of(linkedList.get(7)));
    }

    @Test
    public void addElementInCenterTest() throws MyLinkedListException {
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(5);
        linkedList.add(6);
        linkedList.add(7);
        linkedList.add(100, 3);
        String test = "15 1 2 100 3 4 5 6 7 ";
        Iterator<Integer> iter = linkedList.iterator();
        String result = "";
        while (iter.hasNext()){
            result += iter.next().toString() + " ";
        }
        assertEquals(test, result);
        assertEquals(java.util.Optional.of(9), java.util.Optional.of(linkedList.getSize()));
    }

    @Test
    public void addElementAtBeginTest() throws MyLinkedListException {
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(5);
        linkedList.add(6);
        linkedList.add(7);
        linkedList.add(100, 0);
        String test = "100 15 1 2 3 4 5 6 7 ";
        Iterator<Integer> iter = linkedList.iterator();
        String result = "";
        while (iter.hasNext()){
            result += iter.next().toString() + " ";
        }
        assertEquals(test, result);
        assertEquals(java.util.Optional.of(9), java.util.Optional.of(linkedList.getSize()));
    }

    @Test
    public void addElementAtAndTest() throws MyLinkedListException {
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(5);
        linkedList.add(6);
        linkedList.add(7);
        linkedList.add(100, 7);
        linkedList.add(100, 7);
        String test = "15 1 2 3 4 5 6 100 100 7 ";
        Iterator<Integer> iter = linkedList.iterator();
        String result = "";
        while (iter.hasNext()){
            result += iter.next().toString() + " ";
        }
        assertEquals(test, result);
        assertEquals(java.util.Optional.of(10), java.util.Optional.of(linkedList.getSize()));
    }

    @Test
    public void removeElementTest() throws MyLinkedListException {
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(5);
        linkedList.add(6);
        linkedList.add(7);
        linkedList.remove(3);
        linkedList.remove(3);
        linkedList.remove(2);
        String test = "15 1 5 6 7 ";
        Iterator<Integer> iter = linkedList.iterator();
        String result = "";
        while (iter.hasNext()){
            result += iter.next().toString() + " ";
        }
        assertEquals(test, result);
        assertEquals(java.util.Optional.of(5), java.util.Optional.of(linkedList.getSize()));
    }

    @Test
    public void removeElementAtBeginTest() throws MyLinkedListException {
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(5);
        linkedList.add(6);
        linkedList.add(7);
        linkedList.remove(0);
        linkedList.remove(0);
        linkedList.remove(0);
        String test = "3 4 5 6 7 ";
        Iterator<Integer> iter = linkedList.iterator();
        String result = "";
        while (iter.hasNext()){
            result += iter.next().toString() + " ";
        }
        assertEquals(test, result);
        assertEquals(java.util.Optional.of(5), java.util.Optional.of(linkedList.getSize()));
    }

    @Test
    public void removeElementAtEndTest() throws MyLinkedListException {
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(5);
        linkedList.add(6);
        linkedList.add(7);
        linkedList.remove(7);
        linkedList.remove(6);
        linkedList.remove(5);
        String test = "15 1 2 3 4 ";
        Iterator<Integer> iter = linkedList.iterator();
        String result = "";
        while (iter.hasNext()){
            result += iter.next().toString() + " ";
        }
        assertEquals(test, result);
        assertEquals(java.util.Optional.of(5), java.util.Optional.of(linkedList.getSize()));
    }
}
