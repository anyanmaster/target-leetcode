package org.example.algorithms.day03;

/**
 * @author 杨泰宇
 * @ClassName EOr.java
 * @Description
 * @createTime 2023/7/31
 */
public class EOR {

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 1, 2, 3, 4, 5, 6, 7, 8, 1, 3};
        new EOR().getTwoResult(array);

    }

    void getTwoResult(int[] array) {
        int eor = 0;
        for (int element : array) {
            eor ^= element;
        }
        //取得最右侧的1，形如000000010000
        int rightOnePositionNumber = eor & (-eor);
        int onlyRightOnePositionNumberEor = 0;
        for (int element : array) {
            if ((element & rightOnePositionNumber) != 0) {
                onlyRightOnePositionNumberEor ^= element;
            }
        }

        System.out.println(onlyRightOnePositionNumberEor + " " + (eor ^ onlyRightOnePositionNumberEor));
    }

}
