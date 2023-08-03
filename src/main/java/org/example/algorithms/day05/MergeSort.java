package org.example.algorithms.day05;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import static org.example.algorithms.test.TestSort.printList;

/**
 * @author 杨泰宇
 * @ClassName MergeSort.java
 * @Description
 * @createTime 2023/8/2
 */
public class MergeSort<T extends Comparable<T>> implements Function<List<T>, List<T>> {
    @Override
    public List<T> apply(List<T> list) {
        if (list == null) {
            return null;
        }
        if (list.size() == 1) {
            return list;
        }
        process(list, 0, list.size() - 1);
        return list;
    }

    private void process(List<T> list, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = left + (right - left) / 2;
        process(list, left, mid);
        process(list, mid + 1, right);
        merge(list, left, mid + 1, right);
        printList(list);


    }

    private void merge(List<T> list, int left, int mid, int right) {
        if (left >= right) {
            return;
        }
        int total = right - left + 1;
        int tempMid = mid;
        int tempLeft = left;
        List<T> newList = new ArrayList<>(total);
        while (left < mid || tempMid <= right) {
            if (left == mid) {
                newList.add(list.get(tempMid));
                tempMid++;

            } else if (tempMid > right) {
                newList.add(list.get(left));
                left++;
            } else {
                if (list.get(left) == list.get(tempMid)) {
                    newList.add(list.get(left));
                    left++;
                    tempMid++;
                } else if (list.get(left).compareTo(list.get(tempMid)) < 0) {
                    newList.add(list.get(left));
                    left++;
                } else {
                    newList.add(list.get(tempMid));
                    tempMid++;
                }
            }


        }
        for (T t : newList) {
            list.set(tempLeft, t);
            tempLeft++;
        }


    }
}
