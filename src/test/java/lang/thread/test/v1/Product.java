package lang.thread.test.v1;

/**
 * @Author: wzg
 * @Date: 2020/11/3 9:58 上午
 */
public class Product implements Runnable{

    private Source source;

    public Product(Source source) {
        this.source = source;
    }


    @Override
    public void run() {
        source.offer();
    }
}
