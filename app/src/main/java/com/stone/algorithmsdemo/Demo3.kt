package com.stone.algorithmsdemo

/**
 * Created By: sqq
 * Created Time: 2019-06-11 20:38.
 */
object Demo3 {
    fun longestPalindrome2(s: String): String {
        val len = s.length
        for (i in len downTo 1) {//子串的长度
            for (j in 0..(len - i)) {
                val sub = s.substring(j, i + j)
                if (sub == sub.reversed()) return sub
            }
        }
        return s
    }

    fun longestPalindrome1(s: String): String {
        val len = s.length
        val charArray = s.toCharArray()
        for (i in len downTo 1) {
            for (j in 0..(len - i)) {
                val slice = charArray.sliceArray(IntRange(j, i + j - 1))
                if (isPalindrome(slice)) return String(slice)
            }
        }
        return s
    }

    fun longestPalindrome3(s: String): String {
        val len = s.length
        val charArray = s.toCharArray()
        for (i in len downTo 1) {
            for (j in 0..(len - i)) {
                if (isPalindrome(charArray, j, i + j - 1)) return s.substring(j, i + j)
            }
        }
        return s
    }

    fun longestPalindrome(s: String): String {
        val len = s.length
        if (len <= 1) return s
        val chars = s.toCharArray()
        var max = 0
        var sub = ""
        fun checkPalindrome(i1: Int, i2: Int) {
            var low = i1
            var high = i2
            while (low >= 0 && high <= len - 1) {
                if (chars[low] == chars[high]) {
                    val curLen = high - low + 1
                    if (curLen > max) {
                        max = curLen;sub = s.substring(low, high + 1)
                    }
                    --low;++high
                } else return
            }
        }
        for (i in 0 until len - 1) {
            checkPalindrome(i, i)//单核
            checkPalindrome(i, i + 1)//双核
        }
        return sub
    }


    /**
     * @param start  inclusive
     * @param end inclusive
     */
    private fun isPalindrome(chars: CharArray, start: Int, end: Int): Boolean {
        val len = end - start + 1
        for (i in 1..len.shr(1)) {
            if (chars[start + i - 1] != chars[end + 1 - i]) return false
        }
        return true
    }


    private fun isPalindrome(s: String): Boolean {
        return isPalindrome(s.toCharArray())
    }

    private fun isPalindrome(chars: CharArray): Boolean {
        return isPalindrome(chars, 0, chars.size - 1)
    }


    fun convert(s: String, numRows: Int): String {
        val len = s.length
        if (len <= 2 || numRows == 1) return s
        val d = numRows * 2 - 2
        val sb = StringBuilder()
        for (i in 0 until numRows) {
            if (i == 0 || i == numRows - 1) {
                var index = i
                while (index < len) {
                    sb.append(s[index])
                    index += d
                }
            } else {
                var j = 0
                var index = i
                while (index < len) {
                    sb.append(s[index])
                    ++j
                    index += if (j.and(1) == 1) d - 2 * i else 2 * i
//                    println("the j is $j, index is $index")

                }
            }
        }
        return sb.toString()
    }

    //利用Long
    fun reverse1(x: Int): Int {
        val rl = Math.abs(x.toLong()).toString().reversed().toLong()
        return if (rl > Int.MAX_VALUE) {
            0
        } else {
            rl.toInt() * if (x > 0) 1 else -1
        }
    }

    //不使用Long
    fun reverse(x: Int): Int {
//        2147483647 -2147483648
        val str = Math.abs(x).toString()
        val len = str.length
        val rstr = str.reversed()
        if (len < 10) return (if (x > 0) rstr else "-$str").toInt()
        else {

        }
        return 0

    }

    fun reverse3(x: Int): Int {
        if (x / 1000000000 > 1) {//10位数
            val g = x % 10
            when {
                g < 2 -> return reverseInt(x)
                g > 2 -> return 0
                else -> {
                    x/100
                }
            }
        } else {
            return reverseInt(x)
        }
    }

    fun reverseInt(x: Int): Int {
        return Math.abs(x).toString().reversed().toInt() * if (x > 0) 1 else -1
    }

}