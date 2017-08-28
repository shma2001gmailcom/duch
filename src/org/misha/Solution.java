package org.misha;// you can also use imports, for example:
// import java.util.*;
// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    private static final int UPPER = 25001;
    private static final int LOWER = -25000;

    private int solution(int[] A) {
        if (max(A) > UPPER || min(A) < LOWER) {
            return -1;
        }
        int length = A.length;
        int[] s = new int[length];
        int sum = 0;
        for (int i = 0; i < length; ++i) {
            sum += A[i];
            s[i] = sum;
        }
        if (sum == 0) {
            return 0;
        }
        for (int i = 0; i < length - 1; ++i) {
            if (s[i] == sum - s[i + 1]) {
                return i + 1;
            }
        }
        return -1;
    }

    private int max(int[] x) {
        if (x.length == 0) {
            return Integer.MAX_VALUE;
        }
        int result = x[0];
        for (int a : x) {
            if (a > result) {
                result = a;
            }
        }
        return result;
    }

    private int min(int[] y) {
        int length = y.length;
        if (length == 0) {
            return Integer.MIN_VALUE;
        }
        int[] x = new int[length];
        for (int i = 0; i < length; ++i) {
            x[i] = -y[i];
        }
        return -max(x);
    }

    public static void main(String... a) {
        System.out.print(new Solution().solution(new int[]{1, -2, 4, 400, 3}) == 3);
        System.out.print('\n');
        System.out.print(new Solution().solution(new int[]{1}) == -1);
        System.out.print('\n');
        System.out.print(new Solution().solution(new int[0]) == -1);
    }
}
