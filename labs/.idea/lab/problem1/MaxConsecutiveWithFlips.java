package problem1;

// Java program to find the maximum subarray having all
// ones, by exploring all subarrays

import java.util.*;

public class MaxConsecutiveWithFlips {

    static int maxOnes(int[] arr, int k) {
        int res = 0;

        // Exploring all subarrays
        for(int i = 0; i < arr.length; i++) {

            // Counter for zeroes
            int cnt = 0;
            for(int j = i; j < arr.length; j++) {
                if(arr[j] == 0)
                    cnt++;

                // If cnt is less than or equal to k, then
                // all zeroes can be flipped to one
                if(cnt <= k)
                    res = Math.max(res, (j - i + 1));
            }
        }

        return res;
    }

    public static void main(String[] args) {
        // Example 1
        int[] arr1 = {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
        int k1 = 2;
        System.out.println(maxOnes(arr1, k1));
        // Example 2
        int[] arr2 = {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
        int k2 = 3;
        System.out.println(maxOnes(arr2, k2));
    }

}
