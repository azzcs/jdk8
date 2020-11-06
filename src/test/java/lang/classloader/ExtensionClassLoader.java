package lang.classloader;

/**
 * @Author: wzg
 * @Date: 2020/11/4 4:46 下午
 */
public class ExtensionClassLoader extends BootstrapClassLoader{

    public ExtensionClassLoader(BootstrapClassLoader parent) {
        super(parent);
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        return localFindClass(name);
    }

    private Class<?> localFindClass(String name) {
        System.out.println("ExtensionClassLoader - findClass - Class: " + name);
        return null;
    }


}
