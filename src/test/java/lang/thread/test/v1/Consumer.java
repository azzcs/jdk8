package lang.thread.test.v1;

/**
 * @Author: wzg
 * @Date: 2020/11/3 9:59 上午
 */
public class Consumer implements Runnable{

    private Source source;

    public Consumer(Source source) {
        this.source = source;
    }

    @Override
    public void run() {
        source.poll();
    }
}
