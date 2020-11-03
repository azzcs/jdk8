package lang;

import org.junit.Test;

/**
 * @Author: wzg
 * @Date: 2020/10/29 3:31 下午
 */
public class LongTest {
    @Test
    public void typeTest() {
        System.out.println(Long.class == Long.TYPE);
        System.out.println(long.class == Long.TYPE);
    }

    @Test
    public void newTest() {
        Integer i = new Integer(10);
        i = 5;
    }
    @Test
    public void signumTest() {
        Integer i = new Integer(-10);
        System.out.println(Integer.signum(i));
    }

}
