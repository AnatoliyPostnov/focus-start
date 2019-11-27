package collections.impl;

import java.util.Iterator;
import java.util.Objects;
import java.util.TreeSet;

// monster mode сделать на объъектах с дженериками
public class BinarySearchTree implements Iterable {
    private Node head;
    private Node currentNode;
    private int depth;
    private int currentDepth;
    private int sizeTree;
    private Boolean riseTree;

    public BinarySearchTree(int value){
        head = new Node(value);
        currentNode = head;
        depth = 1;
        currentDepth = depth;
        sizeTree = 1;
        riseTree = true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        TreeSet<Integer> forTestTreeSet = (TreeSet<Integer>) o;
        Iterator forTestIter = forTestTreeSet.iterator();
        Iterator thisIter = iterator();
        while(thisIter.hasNext()){
            if (!(forTestIter.hasNext() && forTestIter.next() == thisIter.next())){
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(head, currentNode, depth, currentDepth, sizeTree, riseTree);
    }

    class Node {
        Integer value;
        Node left = null;
        Node right = null;
        Node perent = null;

        Node(int value) {
            this.value = value;
        }
    }

    @Override
    public Iterator<Integer> iterator() {
        //todo написать реализацию
        return new Iterator<Integer>() {
            private Node currentElement = getLeftLowerElement(head);
            private int currentSize = 1;
            @Override
            public boolean hasNext() {
                return currentSize <= sizeTree;
            }

            @Override
            public Integer next() {
                Integer value = currentElement.value;
                if (currentElement.right != null){
                    currentElement = getLeftLowerElement(currentElement.right);
                }else {
                    if (riseTree){
                        currentElement = findUpElementRiseTree(currentElement);
                    }else{
                        currentElement = findUpElementNotRiseTree(currentElement);
                    }
                }
                ++currentSize;
                return value;
            }
        };
    }

    public void add(int value) {
        //todo написать реализацию
        if (currentNode.value > value){
            createNewLeftNode(value);
        }else if (currentNode.value < value){
            createNewRightNode(value);
        }
        currentDepth = 1;
        currentNode = head;
    }

    public void reverse(){
        reverseTree(currentNode);
        riseTree = !riseTree;
    }

    public int getCurrentDepth() {
        return currentDepth;
    }

    public int getDepth() {
        return depth;
    }

    private Node findUpElementRiseTree(Node currentElement){
        while(currentElement.perent != null &&
                currentElement.perent.value < currentElement.value) {
            currentElement = currentElement.perent;
        }
        return currentElement.perent;
    }

    private Node findUpElementNotRiseTree(Node currentElement){
        while(currentElement.perent != null &&
                currentElement.perent.value > currentElement.value) {
            currentElement = currentElement.perent;
        }
        return currentElement.perent;
    }

    private Node getLeftLowerElement(Node leftNode){
        if (leftNode.left != null){
            return getLeftLowerElement(leftNode.left);
        }
        return leftNode;
    }

    private void createNewLeftNode(int value){
        if (currentNode.left == null){
            currentNode.left = new Node(value);
            currentNode.left.perent = currentNode;
            ++sizeTree;
            if (depth < currentDepth) {
                depth = currentDepth;
            }
            currentNode = currentNode.left;
        }else{
            currentNode = currentNode.left;
            ++currentDepth;
            add(value);
        }
    }

    private void createNewRightNode(int value){
        if (currentNode.right == null){
            currentNode.right = new Node(value);
            currentNode.right.perent = currentNode;
            ++sizeTree;
            if (depth < currentDepth) {
                depth = currentDepth;
            }
            currentNode = currentNode.right;
        }else{
            currentNode = currentNode.right;
            ++currentDepth;
            add(value);
        }
    }

    private void reverseTree(Node currentNode) {
        Node temp = currentNode.right;
        currentNode.right = currentNode.left;
        currentNode.left = temp;

        if (currentNode.left != null) {
            reverseTree(currentNode.left);
        }

        if (currentNode.right != null) {
            reverseTree(currentNode.right);
        }
    }
}
