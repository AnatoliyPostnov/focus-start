package collections.ArrayListTest;

import exceptions.incorrectIndex;
import collections.impl.ArrayList;
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static junit.framework.TestCase.assertEquals;

public class ArrayListTest {
    private final static int CONST_INT = 5;
    private final static String CONST_STRING = "5";
    private final static double CONST_DOUBLE = 5.0;
    private String CONST;
    private ArrayList<String> testList;

    @Before
    public void init(){
        testList = new ArrayList<String>();
        CONST = CONST_STRING;
        for (int i = 0; i < 100; ++i){
            testList.add(CONST);
        }
    }

    @Test
    public void testAddElement(){
        assertEquals(100, testList.getCursor());
        assertEquals(133, testList.getArraySize());
        for (int i = 0; i < 100; ++i){
            assertEquals(true, testList.add(CONST));
        }
    }

    @Test
    public void testGetElement(){
        for (int i = 0; i < 100; ++i){
            assertEquals(java.util.Optional.of(CONST), java.util.Optional.of(testList.get(i)));
        }
        assertEquals(100, testList.getCursor());
        assertEquals(133, testList.getArraySize());
    }

    @Test(expected = incorrectIndex.class)
    public void testGetOverSizeElementException(){
        testList.get(100);
    }


    @Test(expected = incorrectIndex.class)
    public void testGetNegativeElementException(){
        testList.get(-1);
    }

    @Test(expected = incorrectIndex.class)
    public void testRemoveOneElementFromCenter(){
        for (int i = 0; i < 10; ++i){
            testList.add(Integer.valueOf(i).toString());
        }
        testList.remove(105);
        assertEquals(java.util.Optional.of("6"), java.util.Optional.of(testList.get(105)));
        testList.get(109);
    }

    @Test
    public void testRemoveLastElement(){
        testList.remove(99);
        assertEquals(99, testList.getCursor());
        assertEquals(133, testList.getArraySize());
    }

    @Test
    public void testRemoveFirstElement(){
        testList.remove(0);
        assertEquals(99, testList.getCursor());
        assertEquals(133, testList.getArraySize());
    }

    @Test
    public void testRemoveAllElement(){
        for (int i = 0; i < 100; ++i){
            testList.remove(0);
        }
        assertEquals(0, testList.getCursor());
        assertEquals(133, testList.getArraySize());
    }

    @Test
    public void testIterator(){
        Iterator<String> iter = testList.iterator();
        while(iter.hasNext()){
            assertEquals(CONST, iter.next());
        }
    }
}
