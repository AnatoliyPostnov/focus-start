package collections.ArrayListTest;

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
        linkedList = new LinkedList<>();
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
        assert(linkedList.equals("15 15 15 15 15 15 15 "));
    }

    @Test
    public void getElementTest(){
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(5);
        linkedList.add(6);
        linkedList.add(7);
        assertEquals(java.util.Optional.of(1), java.util.Optional.of(linkedList.get(0)));
        assertEquals(java.util.Optional.of(2), java.util.Optional.of(linkedList.get(1)));
        assertEquals(java.util.Optional.of(3), java.util.Optional.of(linkedList.get(2)));
        assertEquals(java.util.Optional.of(4), java.util.Optional.of(linkedList.get(3)));
        assertEquals(java.util.Optional.of(7), java.util.Optional.of(linkedList.get(6)));
    }

    @Test
    public void addElementInCenterTest(){
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(5);
        linkedList.add(6);
        linkedList.add(7);
        linkedList.add(100, 3);
        assert(linkedList.equals("1 2 3 100 4 5 6 7 "));
        assertEquals(java.util.Optional.of(8), java.util.Optional.of(linkedList.getSize()));
    }

    @Test
    public void addElementAtBeginTest(){
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(5);
        linkedList.add(6);
        linkedList.add(7);
        linkedList.add(100, 0);
        assert(linkedList.equals("100 1 2 3 4 5 6 7 "));
        assertEquals(java.util.Optional.of(8), java.util.Optional.of(linkedList.getSize()));
    }

    @Test
    public void addElementAtAndTest(){
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(5);
        linkedList.add(6);
        linkedList.add(7);
        linkedList.add(100, 6);
        linkedList.add(100, 6);
        assert(linkedList.equals("1 2 3 4 5 6 100 100 7 "));
        assertEquals(java.util.Optional.of(9), java.util.Optional.of(linkedList.getSize()));
    }

    @Test
    public void removeElementTest(){
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
        assert(linkedList.equals("1 2 6 7 "));
        assertEquals(java.util.Optional.of(4), java.util.Optional.of(linkedList.getSize()));
    }

    @Test
    public void emptyListTest(){
        Iterator iter = linkedList.iterator();
        if (iter.hasNext()) {
            iter.next();
        }
    }

    @Test
    public void removeElementAtBeginTest(){
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
        assert(linkedList.equals("4 5 6 7 "));
        assertEquals(java.util.Optional.of(4), java.util.Optional.of(linkedList.getSize()));
    }

    @Test
    public void removeElementAtEndTest(){
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(5);
        linkedList.add(6);
        linkedList.add(7);
        linkedList.remove(6);
        linkedList.remove(5);
        linkedList.remove(4);
        assert(linkedList.equals("1 2 3 4 "));
        assertEquals(java.util.Optional.of(4), java.util.Optional.of(linkedList.getSize()));
    }
}
