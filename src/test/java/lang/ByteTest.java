package lang;

import org.junit.Test;

/**
 * @Author: wzg
 * @Date: 2020/10/29 3:31 下午
 */
public class ByteTest {
    @Test
    public void typeTest() {
        System.out.println(byte.class == Byte.TYPE);
    }
    @Test
    public void ByteCacheTest() {
        Byte b = Byte.valueOf("-100");
        System.out.println(b);
    }

    @Test
    public void decodeTest() {

        System.out.println(Byte.decode("0X12"));
        System.out.println(Byte.decode("-0X12"));
    }



}
