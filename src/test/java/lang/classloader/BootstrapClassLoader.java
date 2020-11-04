package lang.classloader;

/**
 * @Author: wzg
 * @Date: 2020/11/4 4:46 下午
 */
public class BootstrapClassLoader {

    private BootstrapClassLoader parent;

    public BootstrapClassLoader(BootstrapClassLoader parent) {
        this.parent = parent;
    }

    protected Class<?> loadClass(String name, boolean resolve)
            throws ClassNotFoundException {
        Class<?> c = null;
        if(parent != null){
            c = parent.loadClass(name,false);
        }else {
            c = defaultLoadClass(name,false);
        }
        if(c == null){
            c = findClass(name);
        }
        return c;
    }

    private Class<?> defaultLoadClass(String name, boolean b) throws ClassNotFoundException {
        System.out.println("BootstrapClassLoader - defaultLoadClass - Class: "+name);
        return null;
    }

    protected Class<?> findClass(String name) throws ClassNotFoundException {
        System.out.println("BootstrapClassLoader - findClass - Class: "+name);
        return null;
    }
}
