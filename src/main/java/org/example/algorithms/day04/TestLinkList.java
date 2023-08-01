package org.example.algorithms.day04;


import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

import java.util.Random;

/**
 * @author 杨泰宇
 *
 *
 *
 *
 *
 * @createTime 2023/8/1
 */
public class TestLinkList {
    public static void main(String[] args) {
        verifyReverseList(10, 10);
        verifyDeleteValue(10, 10, 10);
    }

    static void verifyDeleteValue(int count, int length, int value) {
        for (int i = 0; i < count; i++) {
            SingleNode<Integer> singleNode = generateSingleNodeList(length, 2
            );
            System.out.println("删除前：");
            printList(singleNode);
            SingleNode<Integer> node = deleteValue(singleNode, value);
            System.out.println("删除后：");
            printList(node);
        }
    }

    static SingleNode<Integer> deleteValue(SingleNode<Integer> singleNode, int value) {
        while (singleNode != null && singleNode.getValue() == value) {
            singleNode = singleNode.getNext();

        }

        SingleNode<Integer> head = singleNode;
        SingleNode<Integer> prev = singleNode;

        while (singleNode != null && singleNode.getNext() != null) {
            SingleNode<Integer> next = singleNode.getNext();
            if (next.getValue() != value) {
                prev.setNext(next);
                prev = next;
            }
            singleNode = next;
        }


        return head;


    }

    static void verifyReverseList(Integer count, Integer length) {
        for (int i = 0; i < count; i++) {

            SingleNode<Integer> singleNode = generateSingleNodeList(length, 10);
            printList(singleNode);
            SingleNode<Integer> node = reverseList(singleNode);
            printList(node);

        }


    }


    static SingleNode<Integer> reverseList(SingleNode<Integer> head) {
        if (head == null) {
            return null;
        }
        if (head.getNext() == null) {
            return head;
        }

        SingleNode<Integer> previous = head;
        SingleNode<Integer> next = head.getNext();
        previous.setNext(null);

        while (next != null) {
            SingleNode<Integer> temp = next.getNext();
            next.setNext(previous);
            previous = next;
            next = temp;
        }
        return previous;
    }

    static SingleNode<Integer> generateSingleNodeList(int length, int range) {
        SingleNode<Integer> singleNode = new SingleNode<>();
        Random random = new Random();
        SingleNode<Integer> headNode = singleNode;
        for (int i = 0; i < length; i++) {
            singleNode.setValue(random.nextInt(length * range));
            SingleNode<Integer> next = new SingleNode<>();
            singleNode.setNext(next);
            singleNode = next;
        }
        singleNode.setValue(random.nextInt(length * range));
        return headNode;
    }

    static void printList(SingleNode<Integer> headNode) {
        if (headNode == null) {
            return;
        }
        while (headNode.getNext() != null) {
            System.out.print(headNode.value + "->");
            headNode = headNode.getNext();
        }
        System.out.println(headNode.value);
    }

}
