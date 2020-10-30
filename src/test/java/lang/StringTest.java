package lang;

import org.junit.Test;

import java.io.UnsupportedEncodingException;

/**
 * @Author: wzg
 * @Date: 2020/10/29 3:31 下午
 */
public class StringTest {
    @Test
    public void getCharsTest(){
        String str = "abcdefg";
        char dst[] = {'1','2','3',' ',' ',' ',' ',' ',' '};
        str.getChars(3,7,dst,2);
        System.out.println(dst);
    }

    @Test
    public void getBytesTest() throws UnsupportedEncodingException {
        String str = "abcdefg";
        byte[] bytes = str.getBytes("utf-8");
        for(byte b:bytes){
            System.out.println(b);
        }
        System.out.println();
    }

    @Test
    public void contentEqualsTest()  {
        String str = "abcdefg";
        StringBuffer sb  = new StringBuffer("abcdefg");
        System.out.println(str.contentEquals(sb));
    }

    @Test
    public void replaceTest()  {
        String str = "abcdeafg";
        String str2 = " ";
        System.out.println(str2.length());
        String newStr  = str.replace('a','x');
        System.out.println(newStr);
    }

    @Test
    public void charTest()  {
        String str = " ";
        System.out.println(str.length());
    }

    @Test
    public void toLowerCaseTest()  {
        String str = "abcDeaFg";
        System.out.println(str.toLowerCase());
    }

    @Test
    public void internTest()  {
        String str = "abcDeaFg";
        System.out.println(str.intern());
    }
}
