package org.example.algorithms.day04;

/**
 * @author 杨泰宇
 * @ClassName Node.java
 * @Description
 * @createTime 2023/8/1
 */
public class Node<T> {

    T value;
    Node<T> next;

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }
}
