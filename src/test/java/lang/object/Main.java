package lang.object;

import org.junit.Test;

import java.util.Objects;

/**
 * @Author: wzg
 * @Date: 2020/10/29 10:29 上午
 */

public class Main {


    @Test
    public void getClassTest(){
        Object object = new Son();
        System.out.println(object.getClass());
        System.out.println(Object.class);
        System.out.println(object.getClass()==Object.class);
    }

    @Test
    public void hashCodeTest(){
        Object object1 = new Object();
        Object object2 = new Object();
        System.out.println(object1.hashCode());
        System.out.println(object2.hashCode());
        String str = "123121";
        System.out.println(str.hashCode());
    }
    @Test
    public void toStringTest(){
        Object object = new Object();
        System.out.println(object.toString());
        System.out.println(object);
    }


    static class Son{

    }
}
