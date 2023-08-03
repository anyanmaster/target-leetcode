package org.example.algorithms.test;

import lombok.extern.slf4j.Slf4j;
import org.example.algorithms.day02.BSExist;
import org.example.algorithms.day02.BubbleSort;
import org.example.algorithms.day02.InsertSort;
import org.example.algorithms.day02.SelectSort;
import org.example.algorithms.day05.MergeSort;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
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
    public void testSort() {

//        validateSort(new SelectSort<Integer>());
//        validateSort(new BubbleSort<Integer>());
//        validateSort(new InsertSort<Integer>());
        validateSort(new MergeSort<Integer>());

    }

    @Test
    public void testBSExist() {
        validateBSExist(new BSExist<>());
    }


    public static <T> void validateSort(Function<List<T>, List<T>> listFunction) {
        for (int i = 0; i < 10; i++) {
            List<Integer> list = generateList(10);
            List<T> apply = listFunction.apply((List<T>) list);
            printList(list);
            validateList(list);
        }
    }

    static Random random = new Random();

    public static void validateBSExist(BiFunction<List<Integer>, Integer, Boolean> function) {
        for (int i = 0; i < 10; i++) {
            List<Integer> list = generateList(10, 1);
            new BubbleSort<Integer>().apply(list);
            int target = random.nextInt(10);
            Boolean apply = function.apply(list, target);
            log.error("BSExist : " + target);
            log.error("Result :" + apply);


        }
    }


    private static List<Integer> generateList(int total, int range) {
        List<Integer> list = new ArrayList<>(total);
        for (int i = 0; i < total; i++) {
            list.add(random.nextInt(total * range));
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
