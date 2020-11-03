package lang;

import org.junit.Test;
import org.omg.PortableInterceptor.INACTIVE;

import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * @Author: wzg
 * @Date: 2020/11/02 11:31 上午
 */
public class ThreadTest {
    @Test
    public void test() {
        Thread t = new Thread(() -> System.out.println(111), "thread");
        t.start();
        Thread t2 = new SubThread("thread");
        t2.start();
        System.out.println(t.getName());
        System.out.println(t2.getName());
    }

    @Test
    public void sleepTest() throws InterruptedException {
        Thread t = new Thread(() -> {
            System.out.println("for 循环执行开始");
            for (int i = 0; i < 10000; i++) {
                System.out.println("for 循环执行..." + i);
            }
            System.out.println("for 循环执行完毕");
        }, "thread");
        t.start();
        new Thread(() -> {
            System.out.println("第二个线程开始执行");
        }).start();
        t.sleep(1000);
    }

    @Test
    public void sleep2Test() throws InterruptedException {
        Object lock = new Object();
        Thread t = new Thread(() -> {
            synchronized (lock) {
                System.out.println("for 循环执行开始");
                for (int i = 0; i < 10000; i++) {
                    System.out.println("for 循环执行..." + i);
                }
                System.out.println("for 循环执行完毕");
            }
        }, "thread");
        t.start();
        new Thread(() -> {
            System.out.println("第二个线程开始执行");
            synchronized (lock) {
                System.out.println("第二个线程获取到锁");
            }
        }).start();
        t.sleep(1000);
    }

    @Test
    public void yieldTest() throws InterruptedException {
        Thread t = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                System.out.println("t " + i);
                if (i % 10 == 0) {
                    Thread.yield();
                }
            }

        }, "thread");
        t.setPriority(10);
        t.start();

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                System.out.println("t2 " + i);
            }
        });
        t2.setPriority(10);
        t2.start();

    }

    @Test
    public void interruptTest() throws InterruptedException {

        Thread t = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                System.out.println(Thread.currentThread() + "  hello");
            }
        });
        t.start();
        System.out.println("main thread interrupt thread");

        t.interrupt();
        t.join();

        System.out.println("main is over");
    }

    @Test
    public void interrupt2Test() throws InterruptedException {
        Thread t1 = new Thread(() -> {
            System.out.println("t1 执行");
            try {
                System.out.println("t1 sleep");
                Thread.sleep(3000);
                System.out.println("t1 结束sleep");
            } catch (InterruptedException e) {
                System.out.println("被中断");
            }

        });

        t1.start();

        Thread.sleep(1000);
        System.out.println("主动调用中断方法");
        t1.interrupt();
        t1.join();

    }

    @Test
    public void interruptedTest() throws InterruptedException {
        Thread t1 = new Thread(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                System.out.println("被中断");
            }
        });

        t1.start();

        t1.interrupt();

        boolean interrupted1 = t1.interrupted();

        boolean interrupted2 = t1.isInterrupted();

        System.out.println(interrupted1);
        System.out.println(interrupted2);

        t1.join();

    }

    @Test
    public void waitTest() throws InterruptedException {
        Queue<Integer> queue = new LinkedList<>();

        Thread product = new Thread(() -> {
            try {
                int i = 11;
                while (i > 1) {
                    synchronized (queue) {
                        if (queue.size() >= 3) {
                            queue.wait();
                        } else {
                            i--;
                            queue.offer(i);
                            System.out.println("product:" + i);
                            queue.notify();
                        }
                    }
                }
                queue.offer(-1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread consumer = new Thread(() -> {
            try {
                Integer integer = 0;
                while (integer != -1) {
                    synchronized (queue) {
                        if (queue.size() < 1) {
                            queue.wait();
                        } else {
                            integer = queue.poll();
                            if (integer != -1) {
                                System.out.println("consumer:" + integer);
                                queue.notify();
                            }
                        }
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });


        product.start();
        consumer.start();

        product.join();
        consumer.join();

    }

    @Test
    public void joinTest() throws InterruptedException {
        Thread sub = new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("sub ...");

        });
        sub.start();
        sub.join();
        System.out.println("main ...");

    }

    static class SubThread extends Thread {

        public SubThread(String threadName) {
            super(threadName);
        }

        @Override
        public void run() {
            System.out.println(111);
        }
    }

}
