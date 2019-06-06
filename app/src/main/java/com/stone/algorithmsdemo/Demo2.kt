package com.stone.algorithmsdemo

/**
 * Created By: sqq
 * Created Time: 2019-06-06 10:37.
 */
object Demo2 {

    /**
     * 3. 无重复字符的最长子串
     */
    fun lengthOfLongestSubstring(s: String): Int {
        val sub = StringBuilder()
        var curMaxLen = 0
        var curMaxSub = ""
        s.toCharArray().forEach {
            if (sub.isEmpty() || !sub.contains(it)) sub.append(it)
            else {//已重复，找出索引
                if (curMaxLen < sub.length) {
                    curMaxLen = sub.length;curMaxSub = sub.toString()
                }
                val index = sub.indexOf(it)
                val nSub = sub.substring(index + 1)
                sub.delete(0, sub.length).append(nSub).append(it)
            }
        }
        if (curMaxLen < sub.length) {
            curMaxLen = sub.length;curMaxSub = sub.toString()
        }
        println("the longest substring is $curMaxSub, the length is $curMaxLen")
        return curMaxLen
    }

    /**
     * 4. 寻找两个有序数组的中位数
     */
    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {

        fun findMedian(nums: IntArray): Double {
            val size = nums.size
            val c = size % 2
            val i = size / 2
            val m = if (c == 0) {//偶数
                (nums[i - 1] + nums[i]) / 2.0
            } else {
                nums[size / 2] * 1.0
            }
            println("the median is $m")
            return m
        }

        //合并排序
        val s1 = nums1.size
        val s2 = nums2.size
        val arr = IntArray(s1 + s2)
        var m = 0
        var n = 0
        var l = 0
        while (m != s1 && n != s2) {
            when {
                nums1[m] > nums2[n] -> {
                    arr[l] = nums2[n]
                    ++n
                }
                nums1[m] == nums2[n] -> {
                    arr[l] = nums1[m]
                    arr[++l] = nums2[n]
                    ++m
                    ++n
                }
                else -> {
                    arr[l] = nums1[m]
                    ++m
                }
            }
            ++l
        }
        if (m == s1) {
            for (i in n until s2) {
                arr[l++] = nums2[i]
            }
        }

        if (n == s2) {
            for (i in m until s1) {
                arr[l++] = nums1[i]
            }
        }

        println("the array is ${arr.toList()}")
        val result = findMedian(arr)
        println("the two arrays median is $result")
        return result

    }
}