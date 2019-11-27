package collections;

import exceptions.incorrectIndex;

public interface List<E> extends Iterable<E> {

    boolean add(E e);

    E remove(int index);

    E get(int index);

}
