package lang.thread.test.v1;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.TimeUnit;

/**
 * @Author: wzg
 * @Date: 2020/11/3 10:22 上午
 */
public class Source {
    private Queue<Integer> queue;
    private Integer MAX_NO = 10000;
    private Integer currentNo = 0;

    public Source() {
        this.queue = new LinkedList<>();
    }

    public void offer(){
        while (true){
//            try {
//                TimeUnit.SECONDS.sleep(1);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            synchronized (queue) {

                while (queue.size() >= 3) {
                    try {
                        queue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                queue.notifyAll();
                if(currentNo < MAX_NO){
                    currentNo++;
                    System.out.println(Thread.currentThread().getName()+currentNo);
                    queue.offer(currentNo);
                }else {
                    if(!queue.contains(-1)){
                        queue.offer(-1);
                    }
                    return;
                }
            }
        }
    }

    public void poll(){
        while (true) {
//            try {
//                TimeUnit.SECONDS.sleep(1);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            synchronized (queue) {
                while (queue.size() < 1){
                    try {
                        queue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                Integer peek = queue.peek();
                if(peek != null  && peek == -1){
                    return;
                }
                if(peek != null){
                    System.out.println(Thread.currentThread().getName()+queue.poll());
                }
                queue.notifyAll();
            }
        }
    }

}
