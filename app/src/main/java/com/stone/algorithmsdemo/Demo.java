package com.stone.algorithmsdemo;

import java.math.BigInteger;

/**
 * Created By: sqq
 * Created Time: 2019-06-05 17:05.
 */
public class Demo {

//
//    data class ListNode(val `val`: Int) {
//        var next: ListNode? = null
//    }

    public class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return int2List(list2Int(l1).add(list2Int(l2)));
    }

    public ListNode int2List(BigInteger num) {
        ListNode start = null, node = null;
        int len = String.valueOf(num).length();
        BigInteger curInt = num;
        for (int i = 0; i < len; ++i) {
            int value = Integer.valueOf(curInt.remainder(BigInteger.TEN).toString());
            curInt = curInt.divide(BigInteger.TEN);
            ListNode n = new ListNode(value);
            if (node == null) {
                node = n;
                start = n;
            } else {
                node.next = n;
                node = n;
            }
            if (curInt.equals(BigInteger.ZERO)) return start;
        }
        return start;
    }

    public BigInteger list2Int(ListNode li) {
        ListNode next = li;
        StringBuilder str = new StringBuilder();
        while (next != null) {
            str.append(next.val);
            next = next.next;
        }
        return new BigInteger(str.reverse().toString());
    }

}
