package org.example.algorithms.test;

import lombok.extern.slf4j.Slf4j;
import org.example.algorithms.day02.BSExist;
import org.example.algorithms.day02.BubbleSort;
import org.example.algorithms.day02.InsertSort;
import org.example.algorithms.day02.SelectSort;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.function.BiFunction;
import java.util.function.Function;


/**
 * @author 杨泰宇
 * @ClassName TestSort.java
 * @Description
 * @createTime 2023/7/30
 */
@Slf4j
public class TestSort {

    @Test
    public void main() {

//        validateSort(new SelectSort<Integer>());
//        validateSort(new BubbleSort<Integer>());
        //  validateSort(new InsertSort<Integer>());
        validateBSExist(new BSExist<>());
    }

    public static <T> void validateSort(Function<List<T>, List<T>> function) {
        for (int i = 0; i < 10; i++) {
            List<Integer> list = generateList(10);
            function.apply((List<T>) list);
            printList(list);
            validateList(list);
        }
    }

    public static  void validateBSExist(BiFunction<List<Integer>, Integer, Boolean> function) {
        for (int i = 0; i < 10; i++) {
            List<Integer> list = generateList(10, 1);
            new BubbleSort<Integer>().apply(list);
            Boolean apply = function.apply(list, 1);
            log.error("result :" + apply);


        }
    }


    private static List<Integer> generateList(int total, int range) {

        List<Integer> list = new ArrayList<>(total);
        for (int i = 0; i < total; i++) {
            list.add((int) (Math.random() * total * range));
        }

        return list;


    }

    private static List<Integer> generateList(int total) {

        return generateList(total, 10);


    }


    private static void validateList(List<Integer> list) {

        if (list.size() <= 1) {
            log.info("validateList:failed");
            return;
        }
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i - 1) > list.get(i)) {
                log.info("validateList:failed");
                return;
            }
        }
        log.info("validateList:success");
    }

    public static <T> void printList(List<T> list) {
        String str = "";
        for (int i = 0; i < list.size(); i++) {
            str = str + list.get(i) + "  ";
        }
        log.info("printList:" + str);
    }


}
