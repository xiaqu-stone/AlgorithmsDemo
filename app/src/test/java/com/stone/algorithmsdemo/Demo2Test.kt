package com.stone.algorithmsdemo

import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class Demo2Test {
    @Test
    fun lengthOfLongestSubstringTes() {
        assertEquals(3, Demo2.lengthOfLongestSubstring("abcabcbb"))
        assertEquals(1, Demo2.lengthOfLongestSubstring("bbbbb"))
        assertEquals(3, Demo2.lengthOfLongestSubstring("pwwkew"))
        assertEquals(0, Demo2.lengthOfLongestSubstring(""))
    }

    @Test
    fun findMedianSortedArraysTest() {
        assertEquals(2.0, Demo2.findMedianSortedArrays(intArrayOf(1, 3), intArrayOf(2)), 0.00)
        println("---------------------")
        assertEquals(2.5, Demo2.findMedianSortedArrays(intArrayOf(1, 2), intArrayOf(3, 4)), 0.00)

        println("---------------------")
        assertEquals(1.5, Demo2.findMedianSortedArrays(intArrayOf(1, 2), intArrayOf()), 0.00)

        println("---------------------")
        assertEquals(1.5, Demo2.findMedianSortedArrays(intArrayOf(), intArrayOf(1, 2)), 0.00)
    }

}
