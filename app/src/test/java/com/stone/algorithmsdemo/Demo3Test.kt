package com.stone.algorithmsdemo

import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class Demo3Test {
    @Test
    fun lengthOfLongestSubstringTest() {
        assertEquals("bcb", Demo3.longestPalindrome("abcabcbb"))
        assertEquals("bb", Demo3.longestPalindrome("cbb"))
        assertEquals("a", Demo3.longestPalindrome("abc"))
        assertEquals("", Demo3.longestPalindrome(""))
        assertEquals("a", Demo3.longestPalindrome("a"))
        assertEquals(
            "ranynar", Demo3.longestPalindrome(
                "civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth"
            )
        )
    }


    @Test
    fun convertTest() {
        assertEquals("LDREOEIIECIHNTSG", Demo3.convert("LEETCODEISHIRING", 4))
        assertEquals("LCIRETOESIIGEDHN", Demo3.convert("LEETCODEISHIRING", 3))
    }

    @Test
    fun reverseTest() {
        assertEquals(0, Demo3.reverse(-2147483648))
        assertEquals(0, Demo3.reverse(2147483647))
        assertEquals(-321, Demo3.reverse(-123))
        assertEquals(321, Demo3.reverse(123))

    }
}
