public class DynamicSlidingWindow {
    public static int slidingWindow(int[] nums, int k) {
        int leftPointer = 0;
         int maxOnes = 0;
        int zeroCount = 0;
        for (int rightPointer = 0; rightPointer < nums.length; rightPointer++){
            if (nums[rightPointer] == 0){
                zeroCount++;
            }
            while(zeroCount > k){
                if(nums[leftPointer] == 0){
                    zeroCount--;
                }
                leftPointer++;
            }
            maxOnes = Math.max(maxOnes, nums[rightPointer - leftPointer + 1]);
        }
        return maxOnes;
    }
    public static void main(String[] args) {
        int[] nums = {1,1,1,0,0,0,1,1,1,1,0};
        int k = 2;
        System.out.println(slidingWindow(nums, k));

        int[] nums1 = {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
        int k1 = 3;
        System.out.println(slidingWindow(nums1,k1));

    }
}
