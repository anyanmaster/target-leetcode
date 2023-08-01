package org.example.algorithms.day04;

/**
 * @author 杨泰宇
 * @ClassName Node.java
 * @Description
 * @createTime 2023/8/1
 */
public class SingleNode<T> {

    T value;
    SingleNode<T> next;

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public SingleNode<T> getNext() {
        return next;
    }

    public void setNext(SingleNode<T> next) {
        this.next = next;
    }
}
