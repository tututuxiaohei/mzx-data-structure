package com.mzx.learn.datastructure.data;

public interface MyList<E> {

    int size();

    boolean contains(E e);

    int indexOf(E e);

    E get(int index) throws Exception;

    void set(int index, E element) throws Exception;

    boolean add(int index, E e) throws Exception;

    E remove(int index) throws Exception;
}
