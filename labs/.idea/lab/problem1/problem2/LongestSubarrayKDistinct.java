package problem2;

// Java Code to count the subarrays having exactly
// k distinct elements by exploring all subarrays

import java.util.HashMap;
import java.util.Map;


public class LongestSubarrayKDistinct {

    // Function to count subarrays having at most k distinct elements
    static int atMostK(int[] arr, int k) {
        int n = arr.length;
        int res = 0;

        // pointers to mark the left and right boundary
        int left = 0, right = 0;

        // Frequency map
        Map<Integer, Integer> freq = new HashMap<>();
        while (right < n) {
            freq.put(arr[right], freq.getOrDefault(arr[right], 0) + 1);

            // If this is a new element in the window,
            // decrement k by 1
            if (freq.get(arr[right]) == 1)
                k -= 1;

            // Shrink the window until distinct element
            // count becomes <= k
            while (k < 0) {
                freq.put(arr[left], freq.get(arr[left]) - 1);
                if (freq.get(arr[left]) == 0)
                    k += 1;
                left += 1;
            }

            // add all possible subarrays to result
            res += (right - left + 1);
            right += 1;
        }
        return res;
    }

    // Function to count subarrays having exactly k distinct elements
    static int exactlyK(int[] arr, int k) {
        return atMostK(arr, k) - atMostK(arr, k - 1);
    }

    public static void main(String[] args) {

        // Example 1
        int[] arr1 = {1, 2, 1, 2, 3};
        int k1 = 2;
        System.out.println(exactlyK(arr1, k1));

        int[] arr2 = {4, 3, 5, 2, 3, 3, 4, 4};
        int k2 = 3;
        System.out.println(exactlyK(arr2,k2));
    }
}