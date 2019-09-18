package cn.datacharm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * description:
 * LeetCode 1046 https://leetcode-cn.com/problems/last-stone-weight/
 * @author Herb
 * @date 2019/09/2019-09-18
 */
public class LastStone {
    public static int lastStoneWeight(int[] stones) {
        Arrays.sort(stones);
        int size = stones.length;
        int x,y,sub = 0;
        while( size > 1 &&( x = stones[size-1]) != 0 &&(y = stones[size-2]) != 0 ){
            //System.out.println(size);
            if((sub = x - y) == 0){
                stones[size-1] = 0;
                stones[size-2] = 0;
            }else{
                stones[size-2] = sub;
                stones[size-1] = 0;
            }
            Arrays.sort(stones);
        }

        return stones[size - 1];

    }

    public static void main(String[] args) {
        int[] stones = {2,7,4,1,8,1,1};
        int result = lastStoneWeight(stones);
        System.out.println(result);

    }
}
