package org.dci;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void testFindMaxConsecutiveOnes() {
        assertEquals(6, Main.findMaxConsecutiveOnes(new int[]{1,1,1,0,0,0,1,1,1,1,0}, 2));
        assertEquals(10, Main.findMaxConsecutiveOnes(new int[]{1,1,1,1,1,1,1,1,1,1}, 2));
        assertEquals(1, Main.findMaxConsecutiveOnes(new int[]{0,0,0,0}, 1));
    }

    @Test
    void testFindLongestSubArrayKDistinct() {
        assertEquals(4, Main.findLongestSubArrayKDistinct(new int[]{1,2,1,2,3}, 2));
        assertEquals(5, Main.findLongestSubArrayKDistinct(new int[]{4, 3, 5, 2, 3, 3, 4, 4}, 3));
        assertEquals(5, Main.findLongestSubArrayKDistinct(new int[]{1,1,1,1,1}, 1));
        assertEquals(0, Main.findLongestSubArrayKDistinct(new int[]{}, 2));
        assertEquals(1, Main.findLongestSubArrayKDistinct(new int[]{5}, 1));
    }

}
