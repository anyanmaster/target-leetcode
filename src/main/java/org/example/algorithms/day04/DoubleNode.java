package org.example.algorithms.day04;

/**
 * @author 杨泰宇
 * @ClassName DoubleNode.java
 * @Description
 * @createTime 2023/8/1
 */
public class DoubleNode<T> {
    T value;
    DoubleNode<T> pre;
    DoubleNode<T> next;

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public DoubleNode<T> getPre() {
        return pre;
    }

    public void setPre(DoubleNode<T> pre) {
        this.pre = pre;
    }

    public DoubleNode<T> getNext() {
        return next;
    }

    public void setNext(DoubleNode<T> next) {
        this.next = next;
    }
}
