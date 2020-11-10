package lang;

import org.junit.Test;

import java.util.*;

/**
 * @Author: wzg
 * @Date: 2020/11/9 3:57 下午
 */
public class TreeMapTest {

    @Test
    public void test(){
        Map<Integer,Integer> map = new TreeMap();
        map.put(3,3);
        map.put(2,4);
        map.put(4,2);
        map.put(1,5);
        map.put(5,1);
        System.out.println(map);
    }


}
