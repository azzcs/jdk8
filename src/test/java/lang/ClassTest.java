package lang;

import org.junit.Test;

import java.lang.reflect.Constructor;

/**
 * @Author: wzg
 * @Date: 2020/10/29 3:31 下午
 */
public class ClassTest {
    @Test
    public void test() {
        Class<String> clazz = String.class;
        Constructor<?>[] constructors = clazz.getConstructors();
    }

    @Test
    public void loadTest() throws ClassNotFoundException {
        Class<?> aNull = this.getClass().getClassLoader().loadClass(null);
        System.out.println(aNull);
    }

    @Test
    public void classLoderTest() throws ClassNotFoundException {
        ClassLoader classLoader = this.getClass().getClassLoader();
        System.out.println(classLoader);
        ClassLoader parent = classLoader.getParent();
        System.out.println(parent);
        ClassLoader root = parent.getParent();
        System.out.println(root);
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
    }

}
