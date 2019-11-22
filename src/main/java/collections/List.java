package collections;

import MyExceptions.MyGetElementFromArrayListException;
import MyExceptions.MyLinkedListException;
import MyExceptions.MyRemoveElementFromArrayListException;

public interface List<E> extends Iterable<E> {

    boolean add(E e);

    E remove(int index) throws MyRemoveElementFromArrayListException, MyLinkedListException;

    E get(int index) throws MyGetElementFromArrayListException, MyLinkedListException;

}
