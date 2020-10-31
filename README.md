
`1、java.lang`

[1)Object](https://blog.csdn.net/tyrroo/article/details/83625811)
```
Object类是所有类的父类，所以Object类的对象可以接收所有类的对象，可是除了类的对象之外，Object类连数组和接口对象也都可以接收。
```
**方法:**

getClass:
```
1、native方法
2、getClass是返回一个运行时的对象
3、getClass方法被final修饰，不能被重写
4、getClass与Object.class的区别，getClass是具体运行时的类的对象，class是编译时的对象
即：class 是一个类的属性，能获取该类编译时的类对象，而 getClass() 是一个类的方法，它是获取该类运行时的类对象。
例如：Parent p = new Son();
    System.out.println(p.getClass()); Son
    System.out.println(Parent.class); Parent
5、getClass方法的返回值类型其实是Class<? extends T>而非getClass方法声明中的Class<?>。
```

equals:
```
1、主要用于比较两个对象是否相等
2、需要做对象比较时，一般需要重写equals方法，因为object的equals默认时==。
3、==表示两个对象的地址是否相等
4、== 运算符用于比较基本类型的值是否相同
5、一般重写equals，也需要重写hashCode方法
6、equals 重写原则：
    自反性: x.equals(x)==true
    对称性: x.equals(y)==y.equals(x)
    传递性: x.equals(y)==true,y.equals(z)==true,x.equals(z)==true
    一致性: 多次调用 x.equals(y) 的值唯一
    x.equals(null) == false
```
hashCode:
```
1、native方法
2、返回值为int类型的哈希值。
3、Object默认是返回对象地址的hashCode值。
4、作用：主要是保证基于散列的集合，插入时不可重复，提高查找效率。
5、重写Equals时一般会重写hashCode。当hash类型集合使用对象作为key时，equals的值如果相同hashCode的值应该也相同才能找到。
7、hashCode 重写原则：
    两个对象相等（equals），其 hashCode 一定相同;
    两个对象不相等（equals），其 hashCode 有可能相同;
    hashCode 相同的两个对象，不一定相等（equals）;
    hashCode 不相同的两个对象，一定不相等（equals）;
```
toString:
```
1、默认实现为：类名+16进制无符号整型hashCode的值
2、根据需要可以重写
3、打印某个对象时，默认是调用 toString 方法，比如 System.out.println(person),等价于 System.out.println(person.toString())
```
finalize:
```
1、protected类型
2、finalize用户垃圾回收是由JVM调用。
```
registerNatives:
```
1、native修饰
2、在静态代码快中调用
3、是对本地方法注册，装载本地库。
```
```
notify()/notifyAll()/wait()等写到多线程的时候在做分析
```


[2)String](https://blog.csdn.net/SnailMann/article/details/80882719)
```
String是一个final类，既不能被继承的类
String类实现了java.io.Serializable接口，可以实现序列化
String类实现了Comparable<String>，可以用于比较大小（按顺序比较单个字符的ASCII码）
String类实现了 CharSequence 接口，表示是一个有序字符的序列，因为String的本质是一个char类型数组
```
构造方法
```
可以构造空字符串对象,既""
可以根据String,StringBuilder,StringBuffer构造字符串对象
可以根据char数组，其子数组构造字符串对象
可以根据int数组，其子数组构造字符串对象
可以根据某个字符集编码对byte数组，其子数组解码并构造字符串对象
```

[AbstractStringBuilder](https://my.oschina.net/qq785482254/blog/4278647)
```
实现Appendable，可以添加字符
抽象类，包含toString抽象方法
动态字符数组，数组内容可变
StringBuffer、StringBuilder的父类
扩容：
    MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;（有些虚拟机需要保存头信息）
    newCapacity = (value.length << 1) + 2，如果需要的长度比默认的长，则按照需要的扩容。
    需要校验是否最大长度超过nteger.MAX_VALUE和MAX_ARRAY_SIZE
    如果MAX_ARRAY_SIZE < newCapacity < nteger.MAX_VALUE;取 newCapacity
```

[StringBuffer](https://my.oschina.net/qq785482254/blog/4278647)
```
final关键字修饰的类为最终类，无法被继承 
继承了AbstractStringBuilder类
实现了Serializable接口，可序列化
实现了CharSequence接口，是一个字符序列，可以进行字符序列的相关操作。
```
构造函数
```
构造函数都是调用父类构造方法
```

**方法:**
```
大多数方法调用的是父类方法，并加了synchronized修饰，所以是线程安全的
```
toString：
```
使用toStringCache，缓存上一次字符结果，保证字符串是同一个。（jdk8自测没有用到缓存）
toStringCache被transient修饰所以在io中不会被序列化
```

[StringBuilder](https://blog.csdn.net/qq_34942272/article/details/106344378)
```
构造函数都是调用父类构造方法
```

**方法:**
```
大多数方法调用的是父类方法，与StringBuffer相比较没有用synchronized修饰，所以是线程不安全的，同时效率优于StringBuffer
```
toString：
```
没有使用缓存，每次都会创建新都对象。
toStringCache被transient修饰所以在io中不会被序列化
```

[Boolean](https://juejin.im/post/6844903921262002190)
```
Java的Boolean对象是对boolean基本数据类型的封装
有着一个字段存放对应的boolean数据值，提供了许多方法方便对boolean进行操作。
实现Serializable接口，可以序列化。
实现Comparable接口，可以做比较。
```
属性值：
```
TRUE、FALSE
TYPE（bool的类类型）Boolean.TYPE == boolean.class
```
构造函数
```
Boolean(String s)
Boolean(boolean value)
```
方法：
parseBoolean(String s):
```
((s != null) && s.equalsIgnoreCase("true"));
只要不是true都为false
```
hashCode():
```
value ? 1231 : 1237;
固定都hash值
```
getBoolean(String name):
```
获取System.getProperty()中都属性
```
compare(boolean x, boolean y):
```
(x == y) ? 0 : (x ? 1 : -1);
true > false
```
logicalAnd(boolean a, boolean b) :
```
a && b
```
logicalOr(boolean a, boolean b) :
```
a || b
```
logicalXor(boolean a, boolean b) :
```
a ^ b
```

7) Byte 2
8) Double 2
9) Float 2
10) Integer 2
11) Long 2
12) Short 2
13) Thread 2
14) ThreadLocal 2
15) Enum 3
16) Throwable 3
17) Error 3
18) Exception 3
19) Class 4
20) ClassLoader 4
21) Compiler 4
22) System 4
23) Package 4
24) Void 4

2、java.util

1) AbstractList 1
2) AbstractMap 1
3) AbstractSet 1
4) ArrayList 1
5) LinkedList 1
6) HashMap 1
7) Hashtable 1
8) HashSet 1
9) LinkedHashMap 1
10) LinkedHashSet 1
11) TreeMap 1
12) TreeSet 1
13) Vector 2
14) Queue 2
15) Stack 2
16) SortedMap 2
17) SortedSet 2
18) Collections 3
19) Arrays 3
20) Comparator 3
21) Iterator 3
22) Base64 4
23) Date 4
24) EventListener 4
25) Random 4
26) SubList 4
27) Timer 4
28) UUID 4
29) WeakHashMap 4

3、java.util.concurrent

1) ConcurrentHashMap 1
2) Executor 2
3) AbstractExecutorService 2
4) ExecutorService 2
5) ThreadPoolExecutor 2
6) BlockingQueue 2
7）AbstractQueuedSynchronizer 2
8）CountDownLatch 2
9) FutureTask 2
10）Semaphore 2
11）CyclicBarrier 2
13）CopyOnWriteArrayList 3
14）SynchronousQueue 3
15）BlockingDeque 3
16) Callable 4

4、java.util.concurrent.atomic

1) AtomicBoolean 2
2) AtomicInteger 2
3) AtomicLong 2
4) AtomicReference 3


5、java.lang.reflect

1) Field 2
2) Method 2

6、java.lang.annotation

1) Annotation 3
2) Target 3
3) Inherited 3
4) Retention 3
5) Documented 4
6) ElementType 4
7) Native 4
8) Repeatable 4

7、java.util.concurrent.locks

1) Lock 2
2) Condition 2
3) ReentrantLock 2
4) ReentrantReadWriteLock 2

8、java.io

1) File 3
2) InputStream   3
3) OutputStream  3
4) Reader  4
5) Writer  4

9、java.nio

1) Buffer 3
2) ByteBuffer 4
3) CharBuffer 4
4) DoubleBuffer 4
5) FloatBuffer 4
6) IntBuffer 4
7) LongBuffer 4
8) ShortBuffer 4

10、java.sql

1) Connection 3
2) Driver 3
3) DriverManager 3
4) JDBCType 3
5) ResultSet 4
6) Statement 4


11、java.net

1) Socket 3
2) ServerSocket 3
3) URI 4
4) URL 4
5) URLEncoder 4

其他参考：

[Java transient关键字使用小记](https://www.cnblogs.com/lanxuezaipiao/p/3369962.html)
[JDK1.8源码 由浅入深！抽丝剥茧！重要类的归纳总结！](https://my.oschina.net/qq785482254/blog/4271683)