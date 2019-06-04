package com.stone.algorithmsdemo

/**
 * Created By: sqq
 * Created Time: 2019-06-04 17:23.
 */
object Demo1 {
    fun twoSum1(nums: IntArray, target: Int): IntArray {
        for (i in 0 until nums.size) {
            for (j in i+1 until nums.size) {
                if (nums[i] + nums[j] == target) {
                    println("the result is [$i,$j]")
                    return intArrayOf(i, j)
                }
            }
        }
        return intArrayOf(0, 0)
    }
    /**
     * 1. 两数之和
     * nums = [2, 7, 11, 15], target = 9
     * 返回 [0, 1]
     */
    fun twoSum2(nums: IntArray, target: Int): IntArray {
        data class Num(val index: Int, val value: Int)
        val list = arrayListOf<Num>()
        for (n in nums.withIndex()) {
            list.add(Num(n.index, n.value))
        }
        list.sortBy { it.value }
        val len = list.size
        for (i in 0 until len) {
            for (j in i + 1 until len) {
                val a = list[i]
                val b = list[j]
                if (a.value + b.value == target) {
                    println("the result is [${a.index},${b.index}]")
                    return intArrayOf(a.index, b.index)
                }
            }
        }

        return intArrayOf(0, 0)
    }

    /**
     * 1. 两数之和
     * nums = [2, 7, 11, 15], target = 9
     * 返回 [0, 1]
     */
    fun twoSum3(nums: IntArray, target: Int): IntArray {
        data class Num(val index: Int, val value: Int)
        val list = arrayListOf<Num>()
        for (n in nums.withIndex()) {
            list.add(Num(n.index, n.value))
        }
        list.sortBy { it.value }
        val len = list.size
        for (i in 0 until len) {
            for (j in i + 1 until len) {
                val a = list[i]
                val b = list[j]
                if (a.value + b.value == target) {
                    println("the result is [${a.index}, ${b.index}]")
                    return intArrayOf(a.index, b.index)
                }
            }
        }
        return intArrayOf(0, 0)
    }

}