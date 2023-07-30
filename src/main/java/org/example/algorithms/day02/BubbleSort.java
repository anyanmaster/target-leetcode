package org.example.algorithms.day02;

import java.util.List;
import java.util.function.Function;

import static org.example.algorithms.test.TestSort.printList;

/**
 * @author 杨泰宇
 * @ClassName BubbleSort.java
 * @Description
 * @createTime 2023/7/30
 */
public class BubbleSort<T extends Comparable<T>> implements Function<List<T>, List<T>> {
    @Override
    public List<T> apply(List<T> list) {
        if (list == null) {
            return null;
        }
        if (list.isEmpty() || list.size() == 1) {
            return list;
        }
        bubbleSort(list);
        return list;
    }

    private void bubbleSort(List<T> list) {
        for (int i = 0; i < list.size(); i++) {
            for (int j = 1; j < list.size() - i; j++) {
                if (list.get(j - 1).compareTo(list.get(j)) > 0) {
                    swap(list, j, j - 1);

                }

            }
            printList(list);

        }


    }

    private void swap(List<T> array, int left, int right) {
        if (left < array.size() && right < array.size()) {
            T o = array.get(left);
            array.set(left, array.get(right));
            array.set(right, o);

        }


    }
}
