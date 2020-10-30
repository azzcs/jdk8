package lang;

import org.junit.Test;

import java.io.UnsupportedEncodingException;

/**
 * @Author: wzg
 * @Date: 2020/10/29 3:31 下午
 */
public class AbstractStringBuilderTest {
    @Test
    public void getCharsTest(){
        String str = "abcdefg";
        char dst[] = {'1','2','3',' ',' ',' ',' ',' ',' '};
        str.getChars(3,7,dst,2);
        System.out.println(dst);
    }

}
