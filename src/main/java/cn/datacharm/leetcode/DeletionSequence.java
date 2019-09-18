package cn.datacharm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * description:
 * LeetCode 944
 * https://leetcode-cn.com/problems/delete-columns-to-make-sorted/
 * @author Herb
 * @date 2019/09/2019-09-18
 */
public class DeletionSequence {
    public static  int minDeletionSize(String[] A) {

        char[] col = new char[A.length];
        int len = A[0].length();
        //List<Integer> result = new ArrayList<>();
        int result = 0;

        for (int j = 0; j < len; j++) {
            for (int i = 0; i < A.length; i++) {
                col[i] = A[i].charAt(j);
                if( i > 0 && (col[i] < col[i-1])){
                    result++;
                    break;
                }
            }

        }
        return result;
    }

    public static void main(String[] args) {
        String[] str = {"zyx", "wvu", "tsr"};
        int result = minDeletionSize(str);
        System.out.println(result);
    }
}
