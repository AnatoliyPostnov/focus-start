package collections.ArrayListTest;

import collections.impl.BinarySearchTree;
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static junit.framework.TestCase.assertEquals;

public class BinarySearchTreeTest {
    private BinarySearchTree binarySearchTree;

    @Before
    public void init(){
        binarySearchTree = new BinarySearchTree(10);
    }

    @Test
    public void addLeftSideThreeElementTest(){
        binarySearchTree.add(5);
        binarySearchTree.add(3);
        binarySearchTree.add(1);
        assertEquals(3, binarySearchTree.getDepth());
        assertEquals(1, binarySearchTree.getCurrentDepth());
    }

    @Test
    public void addRightSideThreeElementTest(){
        binarySearchTree.add(12);
        binarySearchTree.add(14);
        binarySearchTree.add(15);
        assertEquals(3, binarySearchTree.getDepth());
        assertEquals(1, binarySearchTree.getCurrentDepth());
    }

    @Test
    public void addRepeatElementTest(){
        binarySearchTree.add(14);
        binarySearchTree.add(10);
        binarySearchTree.add(15);
        assertEquals(2, binarySearchTree.getDepth());
        assertEquals(1, binarySearchTree.getCurrentDepth());
    }

    @Test
    public void addFiveLeftElementAndThreeRightElementTest(){
        binarySearchTree.add(9);
        binarySearchTree.add(8);
        binarySearchTree.add(7);
        binarySearchTree.add(6);
        binarySearchTree.add(5);
        binarySearchTree.add(11);
        binarySearchTree.add(12);
        binarySearchTree.add(13);
        assertEquals(5, binarySearchTree.getDepth());
        assertEquals(1, binarySearchTree.getCurrentDepth());
    }

    @Test
    public void addThreeLeftElementAndFiveRightElementTest(){
        binarySearchTree.add(9);
        binarySearchTree.add(8);
        binarySearchTree.add(7);
        binarySearchTree.add(11);
        binarySearchTree.add(12);
        binarySearchTree.add(13);
        binarySearchTree.add(14);
        binarySearchTree.add(15);
        assertEquals(5, binarySearchTree.getDepth());
        assertEquals(1, binarySearchTree.getCurrentDepth());
    }

    @Test
    public void iterator1Test(){
        binarySearchTree.add(9);
        binarySearchTree.add(8);
        binarySearchTree.add(7);
        binarySearchTree.add(11);
        binarySearchTree.add(12);
        binarySearchTree.add(13);
        binarySearchTree.add(14);
        binarySearchTree.add(15);
        Iterator iter = binarySearchTree.iterator();
        String test = "7 8 9 10 11 12 13 14 15 ";
        String result = "";
        while(iter.hasNext()){
            result += iter.next().toString() + " ";
        }
        assertEquals(test, result);
        assertEquals(5, binarySearchTree.getDepth());
        assertEquals(1, binarySearchTree.getCurrentDepth());
    }

    @Test
    public void iterator2Test(){
        binarySearchTree.add(5);
        binarySearchTree.add(15);
        binarySearchTree.add(2);
        binarySearchTree.add(9);
        binarySearchTree.add(6);
        binarySearchTree.add(8);
        binarySearchTree.add(7);
        binarySearchTree.add(1);
        binarySearchTree.add(4);
        binarySearchTree.add(3);
        binarySearchTree.add(15);
        binarySearchTree.add(30);
        Iterator iter = binarySearchTree.iterator();
        String test = "1 2 3 4 5 6 7 8 9 10 15 30 ";
        String result = "";
        while(iter.hasNext()){
            result += iter.next().toString() + " ";
        }
        assertEquals(test, result);
        assertEquals(5, binarySearchTree.getDepth());
        assertEquals(1, binarySearchTree.getCurrentDepth());
    }

    @Test
    public void iterator3Test(){
        binarySearchTree.add(5);
        binarySearchTree.add(9);
        binarySearchTree.add(8);
        binarySearchTree.add(7);
        binarySearchTree.add(6);
        Iterator iter = binarySearchTree.iterator();
        String test = "5 6 7 8 9 10 ";
        String result = "";
        while(iter.hasNext()){
            result += iter.next().toString() + " ";
        }
        assertEquals(test, result);
        assertEquals(5, binarySearchTree.getDepth());
        assertEquals(1, binarySearchTree.getCurrentDepth());
    }

    @Test
    public void reverse1Test(){
        binarySearchTree.add(5);
        binarySearchTree.add(11);
        binarySearchTree.reverse();
        Iterator iter = binarySearchTree.iterator();
        String test = "11 10 5 ";
        String result = "";
        while(iter.hasNext()){
            result += iter.next().toString() + " ";
        }
        assertEquals(test, result);
    }

    @Test
    public void reverse2Test(){
        binarySearchTree.add(5);
        binarySearchTree.add(15);
        binarySearchTree.add(11);
        binarySearchTree.reverse();
        Iterator iter = binarySearchTree.iterator();
        String test = "15 11 10 5 ";
        String result = "";
        while(iter.hasNext()){
            result += iter.next().toString() + " ";
        }
        assertEquals(test, result);
    }

    @Test
    public void reverse3Test(){
        binarySearchTree.add(5);
        binarySearchTree.add(15);
        binarySearchTree.add(2);
        binarySearchTree.add(9);
        binarySearchTree.add(6);
        binarySearchTree.add(8);
        binarySearchTree.add(7);
        binarySearchTree.add(1);
        binarySearchTree.add(4);
        binarySearchTree.add(3);
        binarySearchTree.add(15);
        binarySearchTree.add(30);
        binarySearchTree.reverse();
        Iterator iter = binarySearchTree.iterator();
        String test = "30 15 10 9 8 7 6 5 4 3 2 1 ";
        String result = "";
        while(iter.hasNext()){
            result += iter.next().toString() + " ";
        }
        assertEquals(test, result);
    }
}
