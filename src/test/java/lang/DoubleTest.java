package lang;

import org.junit.Test;

/**
 * @Author: wzg
 * @Date: 2020/10/29 3:31 下午
 */
public class DoubleTest {
    @Test
    public void toHexStringTest() {
        Double d = 14D;
        System.out.println(Double.toHexString(d));
    }

    @Test
    public void isNaNTest() {
        System.out.println(Float.isNaN(0.0f / 0.0f));
        System.out.println(Double.isNaN(Math.sqrt(-1)));
    }
    @Test
    public void byteValueTest() {
        Double d = 12.5D;
        System.out.println(d.byteValue());
    }

    @Test
    public void minTest() {
        Double d1 = 0.0D;
        Double d2 = -0.0D;
        System.out.println(Double.min(d2,d1));
    }

}
