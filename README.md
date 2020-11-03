
`一、 java.lang`

[1、Object](https://blog.csdn.net/tyrroo/article/details/83625811)
```
Object类是所有类的父类，所以Object类的对象可以接收所有类的对象，可是除了类的对象之外，Object类连数组和接口对象也都可以接收。
```
###### 方法:

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


[2、String](https://blog.csdn.net/SnailMann/article/details/80882719)
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

[3、AbstractStringBuilder](https://my.oschina.net/qq785482254/blog/4278647)
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

[4、StringBuffer](https://my.oschina.net/qq785482254/blog/4278647)
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

###### 方法:
```
大多数方法调用的是父类方法，并加了synchronized修饰，所以是线程安全的
```
toString：
```
使用toStringCache，缓存上一次字符结果，保证字符串是同一个。（jdk8自测没有用到缓存）
toStringCache被transient修饰所以在io中不会被序列化
```

[5、StringBuilder](https://blog.csdn.net/qq_34942272/article/details/106344378)
```
构造函数都是调用父类构造方法
final标识，表示是不可继承的
```

###### 方法:
```
大多数方法调用的是父类方法，与StringBuffer相比较没有用synchronized修饰，所以是线程不安全的，同时效率优于StringBuffer
```
toString：
```
没有使用缓存，每次都会创建新都对象。
toStringCache被transient修饰所以在io中不会被序列化
```

[6、Boolean](https://juejin.im/post/6844903921262002190)
```
Boolean是对boolean基本数据类型的封装
实现Serializable接口，可以序列化。
实现Comparable接口，可以做比较。
final标识，表示是不可继承的
```
属性值：
```
TRUE、FALSE
TYPE（bool的类类型）Boolean.TYPE == boolean.class !=Boolean.class
```
构造函数
```
Boolean(String s)
Boolean(boolean value)
```
###### 方法：

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

[7、Byte](https://juejin.im/post/6844903924869103624)

```
Byte是对byte基本数据类型的封装
Byte类大量使用了Integer的方法
final标识，表示是不可继承的
继承Number（抽象对象），所以Byte是数字。
Number实现Serializable接口
Number包含intValue、longValue、floatValue、doubleValue、byteValue、shortValue方法
实现Serializable接口，可以序列化。
实现Comparable接口，可以做比较。
```

属性值
```
MIN_VALUE = -128;MAX_VALUE = 127; (计算机以补码形式存储)
Byte.TYPE == byte.class != Byte.class
SIZE = 8; （定义了byte值的二进制补码格式的bit位数，固定8位。）
BYTES = SIZE / Byte. （SIZE;定义了byte值的二进制补码格式的字节数，计算值固定为1。）
byte value;（Byte因为是byte的包装类，所以这里包含了对应的byte基本类型数据的变量）
```
静态内部类

ByteCache

``` 
ByteCache Byte cache[] 中缓存-128 -- 127 Byte对象
```

###### 方法：

parseByte(String s, int radix):
```
传入字符串和进制数
```

valueOf(byte b):
```
直接从ByteCache缓存中取

```
decode(String nm):
```
针对字符串解码，将字符串转换成Byte类型值。
主要逻辑是调用了Integer.decode方法获取解码后的数字,然后校验是否超出Byte的范围。

```
toUnsignedInt(byte x) :
```
转换为无符号的Int值

```
toUnsignedLong(byte x):
```
转换为无符号的Long值

```
equals(Object obj):
```
对比的是当前的值

```
toString():
```
Integer.toString((int)value)
调用的Integer的toString

```

[8、Double](https://juejin.im/post/6844903928715296782)

```
继承Number类
实现Comparable接口
final标识，表示是不可继承的
Double是double基础数据类型的包装类
double为64位双精度浮点数，使用科学计数法计数
double计数方式：
    符号位 指数  尾数  长度  
    1     8    23    32
符号位：0/1 正/负
数字 = 符号位*指数*尾数
```

属性：
```
double value;   当前double值
POSITIVE_INFINITY = 1.0 / 0.0;  POSITIVE_INFINITY 表示正无穷，值为0x7ff0000000000000L；标准定义指数域全为1，尾数域全为0
NEGATIVE_INFINITY = -1.0 / 0.0; NEGATIVE_INFINITY 表示负无穷，值为0xfff0000000000000L；标准定义指数域全为1，尾数域全为0
NaN = 0.0d / 0.0; NaN 英文缩写，Not-a-Number，标准定义为 指数域全为1，尾数域不全为0
MAX_VALUE = 0x1.fffffffffffffP+1023; 最大规约数
MIN_NORMAL = 0x1.0p-1022;            最小的规约数
MIN_VALUE = 0x0.0000000000001P-1022; 最小非规约数
MAX_EXPONENT =  1023;   最大的指数
MIN_EXPONENT = -1022;   最小的指数
SIZE = 64;  位数
BYTES = SIZE / Byte.SIZE;   字节数
TYPE = double.class != Double.class
```

构造方法：
```
Double(double value)
Double(String s) throws NumberFormatException
```

方法：
toString()
```
调用FloatingDecimal.toJavaFormatString()方法
10^-3 ~ 10^7之间，会返回正常的十进制数，而不在这个范围时，会采用科学计数法表示。
```
toHexString(double d)
```
返回对应的十六进制字符串。
```
valueOf(String s) throws NumberFormatException 
valueOf(double d)
```
当参数为double类型时，直接new Double(d) 然后返回；
对于字符串参数，调用parseDouble转换成double数据值，然后new一个新对象返回。
```
isNaN(double v)
isNaN()
```
return (v != v);
判断是不是一个数
```
isInfinite(double v)
isInfinite()
```
判断是不是无穷数，包含正无穷和负无穷
```
isFinite(double d)
```
通过输入参数绝对值是否小于double类型的最大值，判断是不是有限数
```
byteValue()
intValue()
longValue()
floatValue()
doubleValue()
```
返回对应的类型值，强制类型转换。
```
hashCode(double value)
```
高32位与低32位异或计算返回int整数值作为hashCode
```
equals(Object obj)
```
首先判断是不是Double对象实例，然后通过doubleToLongBits获取两个对应的长整型数，判断两者是否一致；值得注意的是一些特殊值的判断逻辑。
```
doubleToLongBits(double value)
doubleToRawLongBits(double value)
longBitsToDouble(long bits)
```
返回表示浮点数的位
```
compareTo(Double anotherDouble)
compare(double d1, double d2)
```
比较大小
```
sum(double a, double b)
```
求和
```
max(double a, double b)
```
返回其中一个较大的
```
min(double a, double b)
```
返回其中一个较小的
```


[9、Float](https://blog.renyijiu.com/post/java%E6%BA%90%E7%A0%81float/)

```
Float是float数据类型的包装类
继承Number类
实现Comparable接口
final标识，表示是不可继承的
Float和Double都是浮点数，区别在于Float为32位，Double为64位
```

[10、Integer](https://juejin.im/post/6844903741041147912)
```
Integer是int的包装类，int是java的一种基本数据类型
Integer变量必须实例化后才能使用，而int变量不需要
非new生成的Integer变量指向的是java常量池中的对象，而new Integer()生成的变量指向堆中新建的对象，两者在内存中的地址不同）
Integer的默认值是null，int的默认值是0
```
属性：
```
MIN_VALUE = 0x80000000; - 2的31次方
MAX_VALUE = 0x7fffffff;   2的31次方减1
TYPE    integer.class = Integer.Type != Integer.class
digits  存储二进制到36进制所需要的所有字符
sizeTable 存储了对应位数的最大值
DigitTens   是为了获取0到99之间某个数的十位。直接通过数组就可以获取到该数到十位到值，不需要计算
DigitOnes   是为了获取0到99之间某个数的个位。直接通过数组就可以获取到该数到个位到值，不需要计算
value   Integer对象中真正保存int值的
```
构造函数：
Integer(int value)
Integer(String s)
```
Integer i = new Integer(10);
        i = 5;
本质是：
Integer i = new Integer(10);
        i = Integer.valueOf(5);
```

内部类：
```
此类为静态内部类
用于加载Integer类是缓存 -128 到 127 之间到Integer对象
```

方法：
valueOf(int i)
valueOf(String s)
valueOf(String s, int radix)
```
可以设置进制
如果在-128 到 127 之间，直接从缓存中获取
如果不是则new
建议使用valueOf方法来代替构造函数。或者直接使用Integer i = 100;编译器会转成Integer s = Integer.valueOf(100);
```

从System.property 中获取Integer值
```
Integer getInteger(String nm)
第二个参数是默认值
Integer getInteger(String nm, int val)
Integer getInteger(String nm, Integer val)
Integer decode(String nm)
Integer valueOf(String s)
Integer valueOf(String s, int radix)
int parseUnsignedInt(String s)
int parseUnsignedInt(String s, int radix)
int parseInt(String s)
int parseInt(String s, int radix)
```
decode(String nm)
```
将 String 解码为 Integer。接受十进制、十六进制和八进制数字。
根据要解码的 String（mn)的形式转成不同进制的数字。
 mn由三部分组成：符号、基数说明符和字符序列。
 —0X123中-是符号位，0X是基数说明符（0表示八进制，0x,0X，#表示十六进制，什么都不写则表示十进制），123是数字字符序列。
```
hashCode(int value)
```
直接返回值
```
equals(Object obj)
```
直接比较值大小
```

[11、Long](https://juejin.im/post/6844903956334772237)
```
与Integer相似，区别在于Integer为32，位Long为64位。
```
[12、Short](https://juejin.im/post/6844903939599499277)
```
与Integer相似，区别在于Integer为32，位Short为16位。
```
[13、Thread](https://blog.csdn.net/qq_34942272/article/details/106373608)

``` 
实现了Runnable接口,默认run方法调用target.run();其中target为传入的Runnable对象
一个“线程”是在在程序中执行的线程。Java虚拟机允许应用多个线程并发运行。
每个线程都有优先级，优先级高的先执行。线程可能是守护线程或者不是。
线程的优先级等于创建线程的优先级
通常JVM启动，有一个非守护线程作为主线程。只有当Runtime.exit被调用或者所有非守护线程死亡时（run执行完毕并返回/抛出异常）JVM会停止运行这些线程
两种创建线程的方法：继承Thread类/实现Runnable接口
每个线程有自己的名称用来标识自己。但可能多个线程会重名，如果启动时没有创建名字，会自动生成一个。

```

关键属性：
``` 
name        是表示Thread的名字，可以通过Thread类的构造器中的参数来指定线程名字，
priority    表示线程的优先级（最大值为10，最小值为1，默认值为5），
daemon      表示线程是否是守护线程，如果在main线程中创建了一个守护线程，当main方法运行完毕之后，守护线程也会随着消亡。在JVM中，垃圾收集器线程就是守护线程。
target      表示要执行的任务。
group       线程群组
```

主要方法：
start()
``` 
start()用来启动一个线程，当调用start方法后，系统才会开启一个新的线程来执行用户定义的子任务，在这个过程中，会为相应的线程分配需要的资源。
```
run() 
``` 
run()方法是不需要用户来调用的，当通过start方法启动一个线程之后，当线程获得了CPU执行时间，便进入run方法体去执行具体的任务。
注意，继承Thread类必须重写run方法，在run方法中定义具体要执行的任务。默认run方法调用target.run();其中target为传入的Runnable对象

```
sleep(long millis) 
sleep(long millis, int nanos) 
``` 
sleep方法是静态方法，会使当前线程睡眠：（例如：Thread t1 = new Thread(); t1.sleep(5000); 表示的是当前线程睡5秒，并不是t1线程。）
sleep让线程睡眠，交出CPU，让CPU去执行其他的任务。
sleep方法不会释放锁，也就是说如果当前线程持有对某个对象的锁，则即使调用sleep方法，其他线程也无法访问这个对象。
sleep方法相当于让线程进入阻塞状态。

```
yield()
``` 
调用yield方法会让当前线程交出CPU权限，让CPU去执行其他的线程。
它跟sleep方法类似，同样不会释放锁。
但是yield不能控制具体的交出CPU的时间，另外，yield方法只能让拥有相同优先级的线程有获取CPU执行时间的机会。
它的实际运行流程是先检测当前是否有相同优先级的线程处于同可运行状态，如果有则把CPU的占有权交给此线程，否则继续运行原来的线程。
注意，调用yield方法并不会让线程进入阻塞状态，而是让线程重回就绪状态，它只需要等待重新获取CPU执行时间，这一点是和sleep方法不一样的。
```
join()
join(long millis)
join(long millis, int nanos)
``` 
join()方法的作用就是将调用join的线程优先执行。
主线程等待自线程执行完成后再执行。
```
interrupt()
``` 
中断线程
```
interrupted()
``` 
返回中断状态并且清除中断状态
```
isInterrupted()
``` 
返回中断状态，但不会清除中断状态
```
wait()
``` 
使调用wait()方法的线程释放共享资源锁，然后从运行状态退出，进入等待队列，直到被再次唤醒 或 定时等待 N 毫秒，如果没有通知就超时返回。
wait()方法属于Object的方法， 使用时首先需要获得锁，一般放在同步方法或同步代码块中，由synchronized关键字修饰，需要重新唤醒时由notify()方法和notifyAll()方法来唤醒。
```
notify()
notifyAll()
``` 
这两个方法不属于Thread类中的方法，而是Object类中的方法.
但是这两个方法只有在线程中才有使用场景，作用在于唤醒正在等待状态的线程。
notify()方法随机唤醒等待队列中等待同一共享资源的线程，此线程回退出等待队列，进入可运行状态。
notifyAll()方法则是唤醒所有正在等待队列中等待同一共享资源的全部线程，全部退出等待队列，进入可运行状态
```
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

[原码, 反码, 补码 详解](https://www.cnblogs.com/zhangziqiu/archive/2011/03/30/computercode.html)

[Java语言中：float、double在内存中存储方式](https://www.jianshu.com/p/be3e15352485)

[有趣的NaN类型](https://www.cnblogs.com/big-xuyue/p/4106130.html)