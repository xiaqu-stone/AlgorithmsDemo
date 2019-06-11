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
     *
     *  O(M+N)
     */
    fun findMedianSortedArrays1(nums1: IntArray, nums2: IntArray): Double {

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

    fun findMedian(nums: IntArray): Double {
        val size = nums.size
        val i = size.shr(1)
        val m = if (size.and(1) == 0) {//偶数
            (nums[i - 1] + nums[i]) / 2.0
        } else {
            nums[size.shr(1)] * 1.0
        }
        println("the median is $m")
        return m
    }

    fun findMedianSortedArrays2(nums1: IntArray, nums2: IntArray): Double {

        val s1 = nums1.size
        val s2 = nums2.size
        val total = s1 + s2
        val half = total.shr(1)
        //判断奇偶，奇数则第k个数为中位数；偶数则k、k+1的均值为中位数
        val k = if (total.and(1) == 1) half + 1 else half
        println("s1 = $s1, s2 = $s2")
        fun findR(r: IntArray, other: IntArray): Double {
            return if (total.and(1) == 1) {
                r[k - 1].toDouble()
            } else {
                if (k >= r.size) {
                    (r[k - 1] + other[0]) / 2.0
                } else {
                    (r[k - 1] + Math.min(r[k], other[0])) / 2.0
                }
            }
        }

        fun findK(a: IntArray, m: Int, b: IntArray, n: Int, k: Int): Double {
            if (m > n) {
                return findK(b, n, a, m, k)
            }
            if (m == 0) {
                return findMedian(b)
            }

            if (m == 1 && n == 1) {
                return (a[0] + b[0]) / 2.0
            }

            //然后通过二分搜索寻找在nums1中的x取值，x代表在nums1中的取值个数
            val km = Math.min(k, m)
//            var ks = 0
            val x = km.shr(1)
            fun findX(x: Int, minx: Int, maxx: Int): Double {
                //在a、b中的取值个数
                val ka = x
                val kb = k - ka

                println("ka = $ka, kb = $kb")
                if (ka == 0) {
                    return if (a[0] >= b[k - 1]) findR(b, a)
                    else {//x取小了
                        var nx = (maxx + ka).shr(1)
                        if (nx <= ka && nx < maxx) nx += 1
                        findX(nx, ka, maxx)
                    }
                }
                if (kb == 0) {
                    return if (b[0] >= a[k - 1]) findR(a, b)
                    else {//x取大了
                        findX(ka.shr(1), minx, ka)
                    }
                }

                if (ka == m && kb == n) {
                    return (a[m - 1] + b[n - 1]) / 2.0
                }

                if (ka == m) {
                    if (a[ka - 1] <= b[kb]) {
                        return if (total.and(1) == 1) {
                            Math.max(a[ka - 1], b[kb - 1]).toDouble()
                        } else {
                            (Math.max(a[ka - 1], b[kb - 1]) + b[kb]) / 2.0
                        }
                    }
                }

                if (kb == n) {
                    if (b[kb - 1] <= a[ka]) {
                        return if (total.and(1) == 1) Math.max(a[ka - 1], b[kb - 1]).toDouble()
                        else (Math.max(a[ka - 1], b[kb - 1]) + a[kb]) / 2.0
                    } else {//x 取小了
                        var nx = (maxx + ka).shr(1)
                        if (nx <= ka && nx < maxx) nx += 1
                        findX(nx, ka, maxx)
                    }
                }


                return when {
                    a[ka - 1] > b[kb] -> {//x取大了，需要减小
                        var nx = (ka + minx).shr(1)
                        if (nx >= ka && nx > minx) nx -= 1
                        findX(nx, minx, ka)
                    }
                    b[kb - 1] > a[ka] -> {//x取小了，需要增大
                        var nx = (maxx + ka).shr(1)
                        if (nx <= ka && nx < maxx) nx += 1
                        findX(nx, ka, maxx)
                    }
                    else -> //取值正好
                    {
                        if (ka == 0) return findR(b, a)
                        if (kb == 0) return findR(a, b)
                        if (total.and(1) == 1) Math.max(a[ka - 1], b[kb - 1]).toDouble()
                        else (Math.max(a[ka - 1], b[kb - 1]) + Math.min(a[ka], b[kb])) / 2.0
                    }
                }
            }

            return findX(x, 0, km)
        }
        return findK(nums1, s1, nums2, s2, k)
    }

    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
        fun findK(a: IntArray, m: Int, b: IntArray, n: Int, k: Int): Double {
            if (m > n) {
                return findK(b, n, a, m, k)
            }
            if (m == 0) {
                return b[k - 1].toDouble()
            }

            if (k == 1) {
                return Math.min(a[0], b[0]).toDouble()
            }

            val ka = Math.min(k.shr(1), m)
            val kb = k - ka

            return when {
                a[ka - 1] < b[kb - 1] -> findK(a.sliceArray(IntRange(ka, m - 1)), m - ka, b, n, k - ka)
                a[ka - 1] > b[kb - 1] -> findK(a, m, b.sliceArray(IntRange(kb, n - 1)), n - kb, k - kb)
                else -> a[ka - 1].toDouble()
            }
        }

        val s1 = nums1.size
        val s2 = nums2.size
        val total = s1 + s2
        val half = total.shr(1)
        return if (total.and(1) == 1) {
            findK(nums1, s1, nums2, s2, half + 1)
        } else {
            findK(nums1, s1, nums2, s2, half) / 2 + findK(nums1, s1, nums2, s2, half + 1) / 2
        }
    }

}