import java.util.Arrays;

/**
 * @Author: wzg
 * @Date: 2020/11/8 9:48 上午
 */
public class Sort {

    public static void main(String[] args) {
        Integer[] array = {8,6,1,7,2,6,3,5,9};
        sort2(array,0,array.length-1);
        System.out.println(Arrays.asList(array));
    }

    public static void sort2(Integer array[], int low, int height) {
        if(low >= height){
            return;
        }
        int baseValue=array[low],left=low,right=height;

        while (left < right){
            while (array[right] >= baseValue && left < right)
                right--;
            if(left < right)
                array[left++] = array[right];

            while (array[left] < baseValue && left < right)
                left++;
            if(left < right)
                array[right--] = array[left];
        }
        array[left] = baseValue;
        sort2(array,low,left-1);
        sort2(array,1+right,height);
    }











    public static void sort(Integer a[], int low, int hight) {
        int i, j, index;
        if (low > hight) {
            return;
        }//每一趟结束的条件
        i = low;
        j = hight;
        index = a[i]; // 第一个记录做基准元素
        while (i < j) {
            //先从右边进行扫描，找到大于基准值的元素
            while (i < j && a[j] >= index)
                j--;
            //找到之后交换
            if (i < j)
                a[i++] = a[j];
            //然后从左边扫描，找到小于基准值的元素
            while (i < j && a[i] < index)
                i++;
            //找到之后交换
            if (i < j)
                a[j--] = a[i];
        }
        a[i] = index;
        sort(a, low, i - 1); // 对低子表进行递归排序
        sort(a, i + 1, hight); // 对高子表进行递归排序
    }
}
