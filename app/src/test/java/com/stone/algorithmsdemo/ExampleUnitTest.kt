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
    fun twoSum1Test() {
        val twoSum1 = Demo1.twoSum1(intArrayOf(3, 2, 4), 6)
        assertEquals("12", "${twoSum1[0]}${twoSum1[1]}")
    }

    @Test
    fun twoSum2Test() {
        val twoSum2 = Demo1.twoSum2(intArrayOf(3, 2, 4), 6)
        assertEquals("12", "${twoSum2[0]}${twoSum2[1]}")
        val twoSum31 = Demo1.twoSum2(intArrayOf(-1, -2, -3, -4, -5), -8)
        assertEquals("24", "${twoSum31[0]}${twoSum31[1]}")
    }

    @Test
    fun twoSum3Test() {
        val twoSum3 = Demo1.twoSum3(intArrayOf(3, 2, 4), 6)
        assertEquals("12", "${twoSum3[0]}${twoSum3[1]}")
        val twoSum31 = Demo1.twoSum3(intArrayOf(-1, -2, -3, -4, -5), -8)
        assertEquals("24", "${twoSum31[0]}${twoSum31[1]}")
    }

    @Test
    fun addTwoNumbers1() {
        val i1 = Demo1.list2Num(Demo1.num2List("342".toBigInteger()))
        println("342 is $i1")
        assertEquals("342".toBigInteger(), i1)
        val node = Demo1.addTwoNumbers(Demo1.num2List("1".toBigInteger())!!, Demo1.num2List("99".toBigInteger())!!)
        val result = Demo1.list2Num(node)
        println("the result is $result")
        assertEquals("807".toBigInteger(), result)

        val node1 = Demo1.addTwoNumbers(Demo1.num2List("9".toBigInteger()), Demo1.num2List("9999999991".toBigInteger()))
        val result1 = Demo1.list2Num(node1)
        println("the result is $result1")
        assertEquals(807, result1)
    }

    /**
     * [9]
    [1,9,9,9,9,9,9,9,9,9]
     */
}
