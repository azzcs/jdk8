package lang.thread.test.v1;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: wzg
 * @Date: 2020/11/3 9:57 上午
 */
public class Test {
    public static void main(String[] args) throws InterruptedException {
        Source source = new Source();
        Product p1 = new Product(source);
        Product p2 = new Product(source);
        Product p3 = new Product(source);

        Consumer c1 = new Consumer(source);
        Consumer c2 = new Consumer(source);

        new Thread(p1,"p1:").start();
        new Thread(p2,"p2:").start();
        new Thread(p3,"p3:").start();

        Thread tc1 = new Thread(c1,"----c1:");
        Thread tc2 = new Thread(c2,"----c2:");
        tc1.start();
        tc2.start();

        tc1.join();
        tc2.join();
    }
}
