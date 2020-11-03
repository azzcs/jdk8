package lang;

import org.junit.Test;

/**
 * @Author: wzg
 * @Date: 2020/10/29 3:31 下午
 */
public class IntegerTest {
    @Test
    public void typeTest() {
        System.out.println(Integer.class == Integer.TYPE);
        System.out.println(int.class == Integer.TYPE);
    }

    @Test
    public void newTest() {
        Integer i = new Integer(10);
        i = 5;
    }

    @Test
    public void reverseTest() {
        Integer i = new Integer(10);
        System.out.println(Integer.reverse(i));
    }

}
