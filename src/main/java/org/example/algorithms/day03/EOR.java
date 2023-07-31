package org.example.algorithms.day03;

/**
 * @author 杨泰宇
 * @ClassName EOr.java
 * @Description
 * @createTime 2023/7/31
 */
public class EOR {

    public static void main(String[] args) {
        int[] array={1,2,3,4,5,6,7,8,1,2,3,4,5,6,7,8,1,3};
        new EOR().getTwoResult(array);

    }

    void getTwoResult(int[] array) {
        int eor = 0;
        for (int k : array) {
            eor ^= k;
        }
        int rightOnePositionNumber = eor & (-eor);
        int onlyRightOnePositionNumberEor = 0;
        for (int j : array) {
            if ((j & rightOnePositionNumber) != 0) {
                onlyRightOnePositionNumberEor ^= j;
            }
        }

        System.out.println(onlyRightOnePositionNumberEor+" "+(eor^onlyRightOnePositionNumberEor));
    }

}
