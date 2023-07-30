package org.example.algorithms.day02;

import java.util.List;
import java.util.function.Function;

/**
 * @author 杨泰宇
 * @ClassName InsertSort.java
 * @Description
 * @createTime 2023/7/30
 */
public class InsertSort<T extends Comparable<T>> implements Function<List<T>, List<T>> {
    @Override
    public List<T> apply(List<T> list) {
        for (int i = 1; i < list.size(); i++) {
            for (int j = 0; j < i; j++) {
                if (list.get(i).compareTo(list.get(j)) < 0) {
                    T temp = list.get(i);
                    for (int k = i; k > j; k--) {
                        list.set(k , list.get(k-1));
                    }
                    list.set(j, temp);

                }

            }
        }
        return list;
    }

    private void swap(List<T> array, int left, int right) {
        if (left < array.size() && right < array.size()) {
            T o = array.get(left);
            array.set(left, array.get(right));
            array.set(right, o);

        }


    }
}



