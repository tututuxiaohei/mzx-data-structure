package com.mzx.learn.datastructure.data;

import java.util.Arrays;

public class MyArrayList<E> implements MyList<E> {


    private E[] data;
    private int size;

    private static final int DEFAULT_SIZE = 10;

    public MyArrayList(int capacity) {
        data = (E[]) new Object[capacity];
        size = 0;
    }

    public MyArrayList() {
        this(DEFAULT_SIZE);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean contains(E e) {
        for (int i = 0; i < data.length; i++) {
            if (e.equals(data[i])) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(E e) {
        for (int i = 0; i < data.length; i++) {
            if (e.equals(data[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public E get(int index) throws Exception {
        if (index < 0 || index > data.length) {
            throw new Exception("下标越界");
        }
        return data[index];
    }

    @Override
    public void set(int index, E element) throws Exception {
        if (index < 0 || index > data.length) {
            throw new Exception("下标越界");
        }
        data[index] = element;
        size++;
    }

    @Override
    public boolean add(int index, E e) throws Exception {
        if (index < 0 || index >= data.length) {
            throw new Exception("下标越界");
        }
        if (size == data.length -1) {
            grow(data.length * 2);
        }
        for (int i = index; i < size; i++) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
        return true;
    }

    private void grow(int newCapacity) {
        data = Arrays.copyOf(data, newCapacity);
    }

    @Override
    public E remove(int index) throws Exception {
        if (index < 0 || index >= data.length) {
            throw new Exception("下标越界");
        }
        E result = data[index];
        if (size < data.length / 2) {
            grow(data.length / 2);
        }
        for (int i = index; i < size; i++) {
            data[i] = data[i+1];
        }
        data[size] = null;
        size--;
        return result;
    }


    public static void main(String[] args) throws Exception {
        MyArrayList myArrayList = new MyArrayList();
        for (int i = 0; i < 100; i++) {
            myArrayList.add(i,i);
        }

        for (int i = 0; i < 50; i+=5) {
            Object remove = myArrayList.remove(i);
        }

        for (int i = 0; i < myArrayList.size; i++) {
            System.out.println(myArrayList.get(i));
        }
    }
}
