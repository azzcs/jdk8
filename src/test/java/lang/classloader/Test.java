package lang.classloader;

/**
 * @Author: wzg
 * @Date: 2020/11/4 5:15 下午
 */
public class Test {
    public static void main(String[] args) throws ClassNotFoundException {
        BootstrapClassLoader bootstrapClassLoader = new BootstrapClassLoader(null);
        ExtensionClassLoader extensionClassLoader = new ExtensionClassLoader(bootstrapClassLoader);
        MyClassLoader loader = new MyClassLoader(extensionClassLoader);
        Class<?> aClass = loader.loadClass("lang.ClassTest", true);
        System.out.println(aClass);
    }
}
