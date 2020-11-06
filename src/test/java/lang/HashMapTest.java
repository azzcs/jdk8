package lang;

import org.junit.Test;

import java.io.Console;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: wzg
 * @Date: 2020/10/29 3:31 下午
 */
public class HashMapTest {

    @Test
    public void test() {
        System.out.println(-1>>>2);
        Map map = new HashMap();
        Collections.synchronizedMap(map);
        Map concurrentHashMap = new ConcurrentHashMap();
        List<Integer> v =new Vector();
    }

    @Test
    public void t(){
        String param = "zhaoxuepan";
        if(param =="zhaoxuepan") {
            return;
        }

        if(param == "zxp") {
            System.out.println(param+" 是 王八");
        }
    }
    @Test
    public void executor(){

        ExecutorService executor = Executors.newFixedThreadPool(10);
        executor = Executors.newCachedThreadPool();
        executor = Executors.newSingleThreadExecutor();
        executor = Executors.newScheduledThreadPool(10);
        executor = Executors.newWorkStealingPool(10);
        executor = Executors.newScheduledThreadPool(10);
    }

}
