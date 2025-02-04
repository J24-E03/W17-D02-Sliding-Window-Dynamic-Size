package org.dci;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        System.out.println("Task 1: Find Max Consecutive Ones");
        task1();

        System.out.println("\nTask 2: Find Longest SubArray with K Distinct Integers");
        task2();
    }

    private static void task1() {
        int[] binaryArray1 = {1,1,1,0,0,0,1,1,1,1,0};
        int result1 = findMaxConsecutiveOnes(binaryArray1, 2);
        System.out.println("Input: {1,1,1,0,0,0,1,1,1,1,0}, k = 2");
        System.out.println("Max Consecutive Ones: " + result1);

        int[] binaryArray2 = {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
        int result2 = findMaxConsecutiveOnes(binaryArray2, 3);
        System.out.println("Input: {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1}, k = 3");
        System.out.println("Max Consecutive Ones: " + result2);
    }

    private static int findMaxConsecutiveOnes(int[] binaryArray, int k) {
        int maxSubArrayLength = 0;
        int windowStart = 0;
        int zeroCounter = 0;

        for (int windowEnd = 0; windowEnd < binaryArray.length; windowEnd++) {
            if (binaryArray[windowEnd] == 0) {
                zeroCounter++;
            }

            while (zeroCounter > k) {
                if (binaryArray[windowStart] == 0) {
                    zeroCounter--;
                }
                windowStart++;
            }

            maxSubArrayLength = Math.max(maxSubArrayLength, windowEnd - windowStart + 1);
        }

        return maxSubArrayLength;
    }

    private static void task2() {
        int[] nums1 = {1,2,1,2,3};
        int result1 = findLongestSubArrayKDistinct(nums1, 2);
        System.out.println("\nInput: {1,2,1,2,3}, k = 2");
        System.out.println("Longest SubArray with at most 2 distinct integers: " + result1);

        int[] nums2 = {4, 3, 5, 2, 3, 3, 4, 4};
        int result2 = findLongestSubArrayKDistinct(nums2, 3);
        System.out.println("Input: {4, 3, 5, 2, 3, 3, 4, 4}, k = 3");
        System.out.println("Longest SubArray with at most 3 distinct integers: " + result2);
    }

    private static int findLongestSubArrayKDistinct(int[] nums, int k) {
        int maxSubArrayLength = 0;
        int windowStart = 0;
        Map<Integer, Integer> numbers = new HashMap<>();

        for (int windowEnd = 0; windowEnd < nums.length; windowEnd++) {
            numbers.put(nums[windowEnd], numbers.getOrDefault(nums[windowEnd], 0) + 1);

            while (numbers.size() > k) {
                numbers.put(nums[windowStart], numbers.get(nums[windowStart]) - 1);
                if (numbers.get(nums[windowStart]) == 0) {
                    numbers.remove(nums[windowStart]);
                }
                windowStart++;
            }

            maxSubArrayLength = Math.max(maxSubArrayLength, windowEnd - windowStart + 1);
        }

        return maxSubArrayLength;
    }
}