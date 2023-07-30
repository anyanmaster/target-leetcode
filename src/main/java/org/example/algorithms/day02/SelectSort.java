package org.example.algorithms.day02;

import java.util.List;
import java.util.function.Function;




/**
 * @author 杨泰宇
 * @ClassName day02.SelectSort.java
 * @Description
 * @createTime 2023/7/30
 */
public class SelectSort<T extends Comparable<T>> implements Function<List<T>, List<T>> {

    @Override
    public List<T> apply(List<T> list) {
        if (list == null) {
            return null;
        }
        if (list.isEmpty() || list.size() == 1) {
            return list;
        }
        selectSort(list);
        return list;
    }

    private void selectSort(List<T> list) {
        for (int i = 1; i < list.size(); i++) {
            for (int j = i; j < list.size(); j++) {
                if (list.get(i - 1).compareTo(list.get(j)) > 0) {
                    swap(list, i - 1, j);
                }
            }
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
