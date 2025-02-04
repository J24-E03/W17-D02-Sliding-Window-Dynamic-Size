import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // Task 1
        System.out.println(maxConsecutiveOnesWithFlips(new int[]{1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0}, 2));
        System.out.println(maxConsecutiveOnesWithFlips(new int[]{0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1}, 3));

        // Task 2
        System.out.println(longestSubArrayWithKDistinctIntegers(new int[]{1, 2, 1, 2, 3}, 2));
        System.out.println(longestSubArrayWithKDistinctIntegers(new int[]{4, 3, 5, 2, 3, 3, 4, 4}, 3));
    }

    private static int maxConsecutiveOnesWithFlips(int[] array, int flipNumber) {
        int windowStart = 0;
        int zeroValues = 0;
        int result = 0;

        for (int windowEnd = 0; windowEnd < array.length; windowEnd++) {
            if (array[windowEnd] == 0) {
                zeroValues++;
            }

            while (zeroValues > flipNumber) {
                if (array[windowStart] == 0) {
                    zeroValues--;
                }
                windowStart++;
            }

            result = Math.max(result, windowEnd - windowStart + 1);
        }

        return result;
    }

    private static int longestSubArrayWithKDistinctIntegers(int[] array, int distinctIntegers) {
        Map<Integer, Integer> map = new HashMap<>();
        int windowStart = 0;
        int result = 0;

        for (int windowEnd = 0; windowEnd < array.length; windowEnd++) {
            map.put(array[windowEnd], map.getOrDefault(array[windowEnd], 0) + 1);

            while (map.size() > distinctIntegers) {
                map.put(array[windowStart], map.get(array[windowStart]) - 1);
                if (map.get(array[windowStart]) == 0) {
                    map.remove(array[windowStart]);
                }
                windowStart++;
            }

            result = Math.max(result, windowEnd - windowStart + 1);
        }

        return result;
    }
}
