package lang;

import org.junit.Test;

import java.io.UnsupportedEncodingException;

/**
 * @Author: wzg
 * @Date: 2020/10/29 3:31 下午
 */
public class BooleanTest {
    @Test
    public void typeTest() {
        Class<Boolean> type = Boolean.TYPE;
        System.out.println(type);
        System.out.println(Boolean.TYPE == boolean.class);
    }

    @Test
    public void parseBooleanTest() {
        boolean b = Boolean.parseBoolean("123");
        System.out.println(b);
    }
    @Test
    public void booleanValueTest() {
        Boolean b = Boolean.parseBoolean("123");
        System.out.println(b);
        System.out.println(b.booleanValue());
    }

    @Test
    public void getBooleanTest() {
        System.setProperty("boolean","true");
        System.out.println(Boolean.getBoolean("boolean"));
    }

    @Test
    public void logicalAndTest() {
        System.out.println(Boolean.logicalAnd(true,false));
    }

    @Test
    public void logicalXorTest() {
        System.out.println(Boolean.logicalXor(true,false));
    }

}
