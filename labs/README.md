# Lab: Dynamic Sliding Window Problems

## Overview
In this lab, you will implement two **dynamic sliding window** problems in Java. Sliding window is a technique used to efficiently solve problems involving subarrays or substrings by maintaining a moving range of elements.

## Instructions
- You must implement both problems described below.
- Your solution should have **O(N) time complexity**.
- Use the **sliding window approach**.
- Write test cases to validate your implementation.

---

## Problem 1: Max Consecutive Ones with Flips

Given a binary array `nums` and an integer `k`, return the maximum number of consecutive `1`s in the array if you can flip at most `k` `0`s.

### Example 1:
**Input:**  
`nums = [1,1,1,0,0,0,1,1,1,1,0]`, `k = 2`  

**Output:**  
`6`  

**Explanation:**  
After flipping at most `k = 2` zeros, the longest contiguous subarray of `1`s is:  
`[1,1,1,0,0,1,1,1,1,1,1]`  
(*Bolded numbers were flipped from `0` to `1`.*)

### Example 2:
**Input:**  
`nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1]`, `k = 3`  

**Output:**  
`10`  

**Explanation:**  
After flipping at most `k = 3` zeros, the longest contiguous subarray of `1`s is:  
`[0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]`  
(*Bolded numbers were flipped from `0` to `1`.*)


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

