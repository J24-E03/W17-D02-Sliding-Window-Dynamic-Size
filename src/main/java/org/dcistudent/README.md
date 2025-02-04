**1. Max Consecutive Ones with Flips**

* **Problem Statement:**

Given a binary array `nums` (containing only 0s and 1s) and an integer `k`, find the maximum number of consecutive 1s you can obtain by flipping at most `k` 0s.

* **Example:**

    * `nums = [1,1,1,0,0,0,1,1,1,1,0]`, `k = 2`
    * **Output:** 6
        * Explanation: Flip the two 0s at indices 3 and 4 to get a maximum sequence of 6 consecutive 1s: `[1,1,1,1,1,1,1,1,1,1,0]`

* **Approach: Sliding Window**

    1. **Initialization:**
        - `left`: Pointer to the beginning of the current window.
        - `right`: Pointer to the end of the current window.
        - `maxOnes`: Stores the maximum number of consecutive ones found so far (initialized to 0).
        - `zeroCount`: Keeps track of the number of zeros encountered within the current window.

    2. **Sliding Window:**
        - **Expand the Window:** Move the `right` pointer to the right, expanding the window.
            - If a 0 is encountered, increment `zeroCount`.
        - **Shrink the Window:**
            - If `zeroCount` exceeds `k` (meaning we've flipped more zeros than allowed):
                - Move the `left` pointer to the right, shrinking the window.
                - If the element at `left` was a 0, decrement `zeroCount`.
        - **Update `maxOnes`:**
            - Calculate the current window size (`right - left + 1`).
            - If the current window size is greater than `maxOnes`, update `maxOnes`.

    3. **Repeat:**
        - Continue expanding and shrinking the window until the `right` pointer reaches the end of the array.

**2. Longest Subarray with at Most K Distinct Integers**

* **Problem Statement:**

Given an array of integers `nums` and an integer `k`, find the length of the longest contiguous subarray that contains at most `k` distinct integers.

* **Example:**

    * `nums = [1, 2, 1, 3, 2, 1]`, `k = 2`
    * **Output:** 3
        * Explanation: The longest subarray with at most 2 distinct integers is `[1, 2, 1, 3, 2]`.

* **Approach: Sliding Window**

    1. **Initialization:**
        - `left`: Pointer to the beginning of the current window.
        - `right`: Pointer to the end of the current window.
        - `maxLength`: Stores the length of the longest subarray found so far (initialized to 0).
        - `frequencyMap`: A HashMap to store the frequency of each integer encountered within the current window.

    2. **Sliding Window:**
        - **Expand the Window:** Move the `right` pointer to the right, expanding the window.
            - Update the `frequencyMap` for the newly added element.

        - **Shrink the Window:**
            - If the number of distinct integers in the `frequencyMap` exceeds `k`:
                - Move the `left` pointer to the right, shrinking the window.
                - Decrement the frequency of the element at the `left` pointer in the `frequencyMap`.
                - If the frequency of the element at `left` becomes 0, remove it from the `frequencyMap`.

        - **Update `maxLength`:**
            - Calculate the current window size (`right - left + 1`).
            - If the current window size is greater than `maxLength`, update `maxLength`.

    3. **Repeat:**
        - Continue expanding and shrinking the window until the `right` pointer reaches the end of the array.

* **Key Concepts**

    * **Sliding Window:** This technique efficiently solves problems by maintaining a "window" of elements within a given data structure (like an array). The window moves through the data, and calculations or operations are performed on the elements within the current window.
    * **HashMap:** A data structure that allows for efficient insertion, deletion, and retrieval of values based on their keys. In these problems, it's used to keep track of the frequencies of elements within the window.