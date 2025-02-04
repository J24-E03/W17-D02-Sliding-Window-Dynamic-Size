import java.util.HashMap;

public class LongestSubarray {
    public static int longestSubarray(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
    int left = 0,  maxLength = 0;
    for(int right = 0; right < nums.length; right++) {
        map.put(nums[right], map.getOrDefault(nums[right], 0)+1);

        while(map.size() > k) {
            map.put(nums[left], map.get(nums[left]) - 1);
            if(map.get(nums[left]) == 0) {
                map.remove(nums[left]);
            }
            left++;
        }
        maxLength = Math.max(maxLength,right-left+1);
    }
    return maxLength;
    }
    public static void main(String[] args) {
        int[] nums = {1,2,1,2,3};
        int k = 2;
        System.out.println(longestSubarray(nums,k));

        int[] nums1 = {4, 3, 5, 2, 3, 3, 4, 4};
        int k1 = 3;
        System.out.println(longestSubarray(nums1,k1));
    }
}
