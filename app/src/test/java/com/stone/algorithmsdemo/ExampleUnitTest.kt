package com.stone.algorithmsdemo

import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }


    @Test
    fun twoSumTest() {
        val twoSum1 = Demo1.twoSum1(intArrayOf(3, 2, 4), 6)
        assertEquals("12", "${twoSum1[0]}${twoSum1[1]}")
        val twoSum2 = Demo1.twoSum2(intArrayOf(3, 2, 4), 6)
        assertEquals("12", "${twoSum2[0]}${twoSum2[1]}")
        val twoSum3 = Demo1.twoSum3(intArrayOf(3, 2, 4), 6)
        assertEquals("12", "${twoSum3[0]}${twoSum3[1]}")
//        val twoSum = Demo1.twoSum(intArrayOf(2, 7, 11, 15), 9)
    }
}
