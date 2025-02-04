package org.dcistudent;

import java.util.HashMap;

public class Main {
  public static void main(String[] args) {
    new Main();
  }

  /**
   * Overview:
   * In this lab, you will implement two dynamic sliding window problems in Java.
   * Sliding window is a technique used to efficiently solve problems involving subarrays or substrings by maintaining
   * a moving range of elements.
   *
   * Instructions:
   * - You must implement both problems described below.
   * - Your solution should have O(N) time complexity.
   * - Use the sliding window approach.
   * - Write test cases to validate your implementation.
   *
   * Hints:
   * - Use a HashMap to count occurrences of elements in the current window.
   * - Expand the window while keeping ≤ k distinct integers.
   * - If the window exceeds k distinct numbers, shrink from the left.
   */
  private Main() {
    Main.exercise1();
    Main.exercise2();
  }

  /**
   * 1. Max Consecutive Ones with Flips
   *
   * Given a binary array nums and an integer k, return the maximum number of consecutive 1s in the array if you can
   * flip at most k 0s.
   */
  private static void exercise1() {
    int[] nums = {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0}; // Example input
    int k = 2; // Example k

    int left = 0; // Left pointer of the window
    int right = 0; // Right pointer of the window
    int maxOnes = 0; // Maximum number of consecutive ones found
    int zerosInWindow = 0; // Number of zeros in the current window

    while (right < nums.length) {
      // If we encounter a zero, increment the count of zeros in the window
      if (nums[right] == 0) {
        zerosInWindow++;
      }

      // If the number of zeros in the window exceeds the allowed flips (k)
      while (zerosInWindow > k) {
        // If the left pointer is pointing to a zero, decrement the count of zeros
        if (nums[left] == 0) {
          zerosInWindow--;
        }
        left++;
      }

      // Update the maximum number of consecutive ones
      maxOnes = Math.max(maxOnes, right - left + 1);
      right++;
    }

    System.out.println("Max Consecutive Ones with Flips: " + maxOnes);
  }

  /**
   * 2. Longest Subarray with at Most K Distinct Integers
   *
   * Given an array of integers nums and an integer k, find the length of the longest contiguous subarray that contains
   * at most k distinct integers.
   */
  private static void exercise2() {
    int[] nums = {1, 2, 1, 3, 2, 1}; // Example input
    int k = 2; // Example k

    int left = 0; // Left pointer of the window
    int right = 0; // Right pointer of the window
    int maxLength = 0; // Length of the longest subarray found
    HashMap<Integer, Integer> frequencyMap = new HashMap<>(); // Map to store the frequency of each number in the window

    while (right < nums.length) {
      // Increase the frequency of the current number
      frequencyMap.put(nums[right], frequencyMap.getOrDefault(nums[right], 0) + 1);

      // If the number of distinct integers in the window exceeds k
      while (frequencyMap.size() > k) {
        // Decrease the frequency of the leftmost number
        frequencyMap.put(nums[left], frequencyMap.get(nums[left]) - 1);
        // If the frequency of the leftmost number becomes zero, remove it from the map
        if (frequencyMap.get(nums[left]) == 0) {
          frequencyMap.remove(nums[left]);
        }
        left++;
      }

      // Update the maximum length of the subarray
      maxLength = Math.max(maxLength, right - left + 1);
      right++;
    }

    System.out.println("Longest Subarray with at Most K Distinct Integers: " + maxLength);
  }
}