package _1_fundamentals._4_analysis_of_algorithms;

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Write a program to determine the number pairs of values in an input file that
 * are equal. If your first try is quadratic, think again and use Arrays.sort() to develop
 a linearithmic solution.
 */
public class Ex_1_4_8 {

    public static void main(String[] args) {
        Integer[][] input = {{1,2}, {8,7}, {3,4}, {1,2}, {5,6}, {7,8}, {2,1}};
        StdOut.printf("%d equal pairs", countPairs(input));
    }

    private static int countPairs(Integer[][] input) {
        Arrays.sort(input, new Comparator<Integer[]>() { // n log(n)
            @Override
            public int compare(Integer[] pair1, Integer[] pair2) {
                int v1 = pairVal(pair1);
                int v2 = pairVal(pair2);
                return (v1 > v2) ? 1 : (v2 > v1) ? -1 : 0;
            }
        });
        int i = 0;
        int count = 0;
        while(i < input.length) { // n
            int j = i+1;
            Integer[] pair = input[i];
            while(j < input.length && pairVal(pair) == pairVal(input[j])) {
                j++;
                count++;
            }
            i = j;
        }
        return count;
    }

    private static int pairVal(Integer[] pair) {
        return pair[0] + pair[1];
    }

}

// n log(n) + n = O(n log(n))
