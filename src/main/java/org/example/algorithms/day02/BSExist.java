package org.example.algorithms.day02;

import java.util.List;
import java.util.function.BiFunction;

/**
 * @author 杨泰宇
 * @ClassName BSExist.java
 * @Description
 * @createTime 2023/7/30
 */
public class BSExist<T extends Comparable<T>> implements BiFunction<List<T>, T, Boolean> {
    @Override
    public Boolean apply(List<T> list, T target) {

        if (list == null) {
            return false;
        }
        if (list.isEmpty()) {
            return false;
        }
        if (list.size() == 1) {
            return target.equals(list.get(0));
        }
        int left = 0;
        int right = list.size() - 1;
        while (left <= right) {
            if (left == right) {
                return list.get(left) == target;
            } else {
                int mid = left + (right - left) /2 ;
                if (list.get(mid).compareTo(target) < 0) {
                    left  = mid + 1;
                } else if (list.get(mid).equals(target)) {
                    return true;
                } else {
                     right= mid - 1;
                }
            }
        }

        return false;
    }
}
