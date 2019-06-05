package com.stone.algorithmsdemo

import java.math.BigInteger

/**
 * Created By: sqq
 * Created Time: 2019-06-04 17:23.
 */
object Demo1 {
    /**
     * 遍历，简单粗暴
     */
    fun twoSum1(nums: IntArray, target: Int): IntArray {
        for (i in 0 until nums.size) {
            for (j in i + 1 until nums.size) {
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
     *
     * 先排序，再遍历。
     * 当和大于target时结束循环
     */
    fun twoSum2(nums: IntArray, target: Int): IntArray {
        data class Num(val index: Int, val value: Int)

        val len = nums.size
        val list = arrayOfNulls<Num>(len)
        for (n in nums.withIndex()) {
            list[n.index] = Num(n.index, n.value)
        }
        list.sortBy { it?.value }
        for (i in 0 until len) {
            for (j in i + 1 until len) {
                val a = list[i] ?: return intArrayOf(0, 0)
                val b = list[j] ?: return intArrayOf(0, 0)
                if (a.value + b.value == target) {
                    println("the result is [${a.index},${b.index}]")
                    return intArrayOf(a.index, b.index)
                } else if (a.value + b.value > target) break
            }
        }
        return intArrayOf(0, 0)
    }

    /**
     * 1. 两数之和
     * nums = [2, 7, 11, 15], target = 9
     * 返回 [0, 1]
     *
     * 双循环遍历，外循环小数组；
     * 当小数组元素与target之和大于target时，内循环则遍历小数组；反之遍历大数组
     */
    fun twoSum3(nums: IntArray, target: Int): IntArray {
        data class Num(val index: Int, val value: Int)

        val list = arrayListOf<Num>()
        for (n in nums.withIndex()) {
            list.add(Num(n.index, n.value))
        }
        list.sortBy { it.value }

        fun listForEach(li: List<Num>, target: Int): IntArray {
            val size = li.size
            for (i in 0 until size) {
                for (j in i + 1 until size) {
                    val x = li[i]
                    val y = li[j]
                    if (x.value + y.value == target) return intArrayOf(x.index, y.index)
                    else if (x.value + y.value > target) break
                }
            }
            return intArrayOf(0, 0)
        }
        if (list[0].value >= target || list.last().value < target) return listForEach(list, target)

        val small = arrayListOf<Num>()
        val big = arrayListOf<Num>()
        list.forEach { if (it.value > target) big.add(it) else small.add(it) }
        val len = small.size
        for (i in 0 until len) {
            val s = small[i]
            if (s.value + target >= target) {
                for (j in i + 1 until len) {
                    val b = small[j]
                    if (s.value + b.value == target) {
                        println("the result is [${s.index}, ${b.index}]")
                        return intArrayOf(s.index, b.index)
                    }
                }
            } else {
                for (j in 0 until big.size) {
                    val b = big[j]
                    if (s.value + b.value == target) {
                        println("the result is [${s.index}, ${b.index}]")
                        return intArrayOf(s.index, b.index)
                    }
                }
            }
        }
        return intArrayOf(0, 0)
    }


    /**
     * 2. 两数相加
     */

    data class ListNode(val `val`: Int) {
        var next: ListNode? = null
    }

    fun addTwoNumbers1(l1: ListNode?, l2: ListNode?): ListNode? {
        val a = list2Num(l1)
        val b = list2Num(l2)
        return num2List(a + b)
    }

    fun num2List(int: BigInteger): ListNode? {
        var start: ListNode? = null
        var node: ListNode? = null
        val len = int.toString().length
        var curInt = int
        val big0 = "0".toBigInteger()
        val exp = "10".toBigInteger()
        for (i in 0 until len) {
            val value = curInt.rem(exp).toInt()
            curInt = curInt.div(exp)
            val n = ListNode(value)
            if (node == null) {
                node = n;start = n
            } else {
                node.next = n;node = n
            }
            if (curInt == big0) return start
        }
        return start ?: ListNode(0)
    }

    fun list2Num(li: ListNode?): BigInteger {
        li ?: return "0".toBigInteger()
        var next: ListNode? = li
        val str = StringBuilder()
        while (next != null) {
//            println("the ``val`` is ${next.`val`}")
            str.append(next.`val`)
            next = next.next
        }
//        println("the str is $str")
        return str.reversed().toString().toBigInteger()
    }


    fun addTwoNumbers2(l1: ListNode?, l2: ListNode?): ListNode? {
        var extraOne = 0
        fun addTwoNumbers(l1: ListNode?, l2: ListNode?, one: Int): ListNode? {
            val sum = (l1?.`val` ?: 0) + (l2?.`val` ?: 0) + one
            extraOne = sum / 10
            return ListNode(sum % 10)
        }

        var start: ListNode? = null
        var node: ListNode? = null
        var n1 = l1
        var n2 = l2
        while (true) {
            if (n1 == null && n2 == null && extraOne == 0) break
            val n = addTwoNumbers(n1, n2, extraOne)
            n1 = n1?.next;n2 = n2?.next
            if (node == null) start = n else node.next = n
            node = n
        }

        return start
    }


    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        var extraOne = 0
        var start: ListNode? = null
        var node: ListNode? = null
        var n1 = l1
        var n2 = l2
        while (n1 != null && n2 != null) {
            val sum = n1.`val` + n2.`val` + extraOne
            extraOne = sum / 10
            println("the while sum is $sum")
            val n = ListNode(sum % 10)
            if (node == null) start = n else node.next = n
            node = n
            n1 = n1.next;n2 = n2.next

        }
        var n = n1 ?: n2
        while (n != null) {
            val sum = n.`val` + extraOne
            println("the while2 sum is $sum")
            extraOne = sum / 10
            val nn = ListNode(sum % 10)
            if (node == null) start = nn else node.next = nn
            node = nn
            n = n.next
        }

        if (extraOne != 0) {
            node?.next = ListNode(extraOne)
        }
        return start
    }


}