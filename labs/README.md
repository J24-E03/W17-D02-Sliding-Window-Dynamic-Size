# Lab: Dynamic Sliding Window Problems

## Overview
In this lab, you will implement two **dynamic sliding window** problems in Java. Sliding window is a technique used to efficiently solve problems involving subarrays or substrings by maintaining a moving range of elements.

## Instructions
- You must implement both problems described below.
- Your solution should have **O(N) time complexity**.
- Use the **sliding window approach**.
- Write test cases to validate your implementation.

---

## **Problem 1: Longest Repeating Character Replacement**

### **Problem Statement**
You are given a string `s` and an integer `k`. You can choose **any character** in the string and change it to any other uppercase English letter. You can perform this operation **at most `k` times**.

Return the length of the **longest contiguous substring** containing the same character after performing the operations.

### **Example 1:**
**Input:**
```java
s = "AABABBA", k = 1;
```
**Output:**
```java
4
```
**Explanation:**
After changing one `'B'` to `'A'`, the longest contiguous substring is **"AAAA"**.

### **Example 2:**
**Input:**
```java
s = "ABAB", k = 2;
```
**Output:**
```java
4
```
**Explanation:**
We can change both `'B'` to `'A'`, making **"AAAA"**.

### **Constraints:**
- `1 ≤ s.length ≤ 10^5`
- `s` contains only uppercase English letters.
- `0 ≤ k ≤ s.length`

### **Hints:**
- Use a **HashMap or array** to track the count of characters in the current window.
- Try expanding the window and **shrink it only when needed**.

---

## **Problem 2: Longest Subarray with at Most K Distinct Integers**

### **Problem Statement**
Given an array of integers `nums` and an integer `k`, find the **length of the longest contiguous subarray** that contains **at most `k` distinct integers**.

### **Example 1:**
**Input:**
```java
nums = [1, 2, 1, 2, 3], k = 2;
```
**Output:**
```java
4
```
**Explanation:**
The longest subarray with at most 2 distinct integers is **[1,2,1,2]** (`length = 4`).

### **Example 2:**
**Input:**
```java
nums = [4, 3, 5, 2, 3, 3, 4, 4], k = 3;
```
**Output:**
```java
6
```
**Explanation:**
The longest subarray with at most 3 distinct integers is **[5,2,3,3,4,4]** (`length = 6`).

### **Constraints:**
- `1 ≤ nums.length ≤ 10^5`
- `0 ≤ nums[i] ≤ 10^4`
- `1 ≤ k ≤ nums.length`

### **Hints:**
- Use a **HashMap** to count occurrences of elements in the current window.
- Expand the window while keeping **≤ k distinct integers**.
- If the window exceeds `k` distinct numbers, **shrink from the left**.


Happy coding! 🚀

