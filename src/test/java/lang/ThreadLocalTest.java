package lang;

import org.junit.Test;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: wzg
 * @Date: 2020/10/29 3:31 下午
 */
public class ThreadLocalTest {
    @Test
    public void test() {
        ThreadLocal<Integer> localI = new ThreadLocal<>();
        localI.set(1);
        System.out.println(localI.get());
        localI.set(2);
        System.out.println(localI.get());
        new Thread(()->{
            System.out.println(localI.get());
            localI.set(2);
            System.out.println(localI.get());
        }).start();
    }

    @Test
    public void threadIdTest() {
        System.out.println(ThreadId.get());
        new Thread(()->{
            System.out.println(ThreadId.get());
        }).start();
        new Thread(()->{
            System.out.println(ThreadId.get());
        }).start();
        new Thread(()->{
            System.out.println(ThreadId.get());
        }).start();
        new Thread(()->{
            System.out.println(ThreadId.get());
        }).start();

    }

    static class ThreadId {
        // Atomic integer containing the next thread ID to be assigned
        private static final AtomicInteger nextId = new AtomicInteger(0);

        // Thread local variable containing each thread's ID
        private static final ThreadLocal<Integer> threadId =
                new ThreadLocal<Integer>() {
                    @Override protected Integer initialValue() {
                        return nextId.getAndIncrement();
                    }
                };

        // Returns the current thread's unique ID, assigning it if necessary
        public static int get() {
            return threadId.get();
        }
    }

}
