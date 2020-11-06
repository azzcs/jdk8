package lang;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: wzg
 * @Date: 2020/10/29 3:31 下午
 */
public class ArrayListTest {

    @Test
    public void test() {
        boolean b = true | false;
        System.out.println(b);
    }

    @Test
    public void cloneTest() {
        List<Integer> ints = Arrays.asList(1,2,3);
    }

    @Test
    public void arrayListTest() {
        ArrayList<Integer> arrayList = new ArrayList(10);
        System.out.println(arrayList.size());
        arrayList.set(5,1);
    }

}
