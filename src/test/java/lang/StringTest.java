package lang;

import com.sun.org.apache.xpath.internal.operations.Bool;
import org.junit.Test;

import java.io.UnsupportedEncodingException;

/**
 * @Author: wzg
 * @Date: 2020/10/29 3:31 下午
 */
public class StringTest {
    @Test
    public void getCharsTest() {
        String str = "abcdefg";
        char dst[] = {'1', '2', '3', ' ', ' ', ' ', ' ', ' ', ' '};
        str.getChars(3, 7, dst, 2);
        System.out.println(dst);
    }

    @Test
    public void getBytesTest() throws UnsupportedEncodingException {
        String str = "abcdefg";
        byte[] bytes = str.getBytes("utf-8");
        for (byte b : bytes) {
            System.out.println(b);
        }
        System.out.println();
    }

    @Test
    public void contentEqualsTest() {
        String str = "abcdefg";
        StringBuffer sb = new StringBuffer("abcdefg");
        System.out.println(str.contentEquals(sb));
    }

    @Test
    public void replaceTest() {
        String str = "abcdeafg";
        String str2 = " ";
        System.out.println(str2.length());
        String newStr = str.replace('a', 'x');
        System.out.println(newStr);
    }

    @Test
    public void charTest() {
        String str = " ";
        System.out.println(str.length());
    }

    @Test
    public void toLowerCaseTest() {
        String str = "abcDeaFg";
        System.out.println(str.toLowerCase());
    }

    @Test
    public void internTest() {
        String str = "abcDeaFg";
        System.out.println(str.intern());
    }

    @Test
    public void toStringTest() {
        StringBuilder sb = new StringBuilder("abcDeaFg");
        String s1 = sb.toString();
        String s2 = sb.toString();
        System.out.println(s1 == s2);

        StringBuffer sbuffer = new StringBuffer("abcDeaFg1");
        String str1 = sbuffer.toString();
        String str2 = sbuffer.toString();
        System.out.println(str1 == str2);
    }

    @Test
    public void insertTest() {
        StringBuilder sb = new StringBuilder("1234567890");
        sb.insert(1,"99999");
        System.out.println(sb.toString());
    }

    @Test
    public void addTwoNumbersTest() {
        ListNode node2 = new ListNode(9);


        ListNode node5 = new ListNode(9);
        ListNode node6 = new ListNode(9);
        node5.next = node6;
        ListNode node42 = new ListNode(9);
        node6.next = node42;
        addTwoNumbers(node2, node5);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int up = 0;
        ListNode result = null;
        ListNode nextL1 = l1;
        ListNode nextL2 = l2;
        ListNode next = null;
        ListNode currentNode = l1==null ? l2:l1;
        while (nextL1 != null || nextL2 != null || up > 0){
            int value = (nextL1==null?0:nextL1.val) + (nextL2==null?0:nextL2.val) + up;
            nextL1 = nextL1==null ? null:nextL1.next;
            nextL2 = nextL2==null ? null:nextL2.next;
            up = value / 10;
            currentNode.val = value%10;
            if (result == null) {
                result = currentNode;
            } else {
                next.next = currentNode;
            }
            next = currentNode;
            currentNode = nextL1==null ? nextL2:nextL1;
            if(currentNode == null){
                currentNode = new ListNode(0);
            }
        }

        return result;

    }

    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
