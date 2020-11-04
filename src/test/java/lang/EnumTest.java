package lang;

import org.junit.Test;

/**
 * @Author: wzg
 * @Date: 2020/10/29 3:31 下午
 */
public class EnumTest {
    @Test
    public void test() {
        Color red = Color.RED;
        System.out.println(red);
    }
    @Test
    public void valueOfTest() {
        Color blue = Enum.valueOf(Color.class, "BLUE");
        System.out.println(blue);
        Color green = Color.valueOf("GREEN");
        System.out.println(green);
    }

    enum Color {RED, BLUE, GREEN}
}
