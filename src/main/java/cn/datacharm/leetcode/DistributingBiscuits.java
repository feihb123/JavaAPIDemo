package cn.datacharm.leetcode;


import java.util.Arrays;

/**
 * description:
 * LeetCode 455
 * https://leetcode-cn.com/problems/assign-cookies/
 * @author Herb
 * @date 2019/09/2019-09-18
 */
public class DistributingBiscuits {
    public static int findContentChildren(int[] g, int[] s) {
        int x=0,y=0,result = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        for(int i = x ; i < g.length ; i++){
            for(int j = y;j < s.length ;j++){
                if(s[j] >= g[i]){
                    result++;
                    x++;
                    y++;
                    break;
                }else{
                    y++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] g = {1, 2, 3};
        int[] s = {1, 1};
        int result = findContentChildren(g, s);
        System.out.println(result);
    }
}
