package com.omar;

import java.util.HashSet;

public class SmallestSubArray {
//    Problem: find the smallest sub array within a given array that is greater than or equal to a given number sum

    public static int smallestsubArray(int targetSum, int[] nums){
        int minWindowSize = Integer.MAX_VALUE;

        int currentSum = 0;

        int windowStart = 0;

//        for dynamic sized window questions normally we increment the window end in a for loop
        for(int windowEnd = 0; windowEnd<nums.length;windowEnd++){

            currentSum+= nums[windowEnd];

            while(currentSum >= targetSum){


                minWindowSize = Math.min(minWindowSize,windowEnd-windowStart+1);

                currentSum -= nums[windowStart];
                windowStart++;

            }

        }
        return minWindowSize;
    }

    public static void main(String[] args) {
        int[] testNums = {1,3,2,5,7,2,10};
        System.out.println(String.format("%d is the minimum window length",smallestsubArray(8,testNums)));

        System.out.printf("%d is the biggest unique substring in this string%n",maxUniqueSubString("abcabeace"));
    }

    public static int maxUniqueSubString(String s){
        int maxSubString = 0;
        HashSet<Character> set = new HashSet<>();
        int windowStart = 0;

        for(int windowEnd = 0; windowEnd<s.length(); windowEnd++){


            while(set.contains(s.charAt(windowEnd))){
                set.remove(s.charAt(windowStart));
                windowStart+= 1;
            }

            maxSubString = Math.max(maxSubString, windowEnd-windowStart + 1);

            set.add(s.charAt(windowEnd));
        }
        return maxSubString;
    }

}


