package lang.classloader;

/**
 * @Author: wzg
 * @Date: 2020/11/4 5:51 下午
 */
public class MyClassLoader extends ExtensionClassLoader{

    public MyClassLoader(BootstrapClassLoader parent) {
        super(parent);
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        Class<?> clazz = super.findClass(name);
        if(clazz == null){
            clazz = localFindClass(name);
        }
        return clazz;
    }

    private Class<?> localFindClass(String name) throws ClassNotFoundException {
        System.out.println("MyClassLoader - findClass - Class: " + name);
        return Class.forName(name);
    }
}
