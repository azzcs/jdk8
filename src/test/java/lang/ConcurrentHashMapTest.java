package lang;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @Author: wzg
 * @Date: 2020/11/9 3:57 下午
 */
public class ConcurrentHashMapTest {

    @Test
    public void test() throws InterruptedException {
        Map<String,Integer> k = new ConcurrentHashMap();
//        Map<String,Integer> k = new HashMap<>();
        k.put("key",0);
        ExecutorService executorService = Executors.newFixedThreadPool(20);
        for(int j = 0;j<10;j++) {
            executorService.execute(() -> {
                k.computeIfPresent("key", (k1, v) -> v + 1);
            });
        }
        TimeUnit.SECONDS.sleep(10);
        System.out.println(k.get("key"));
    }


}
