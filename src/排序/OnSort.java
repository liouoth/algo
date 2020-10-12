package 排序;

import java.util.Arrays;
import java.util.Collections;

public class OnSort {
    //桶排序

    //计数排序

    //基数排序

    //练习 ： 将a G g A c a F 进行排序，小写在前大写在后
    public static void exam1_0(char [] a){
        System.out.println("排序前:"+ Arrays.toString(a));
        char [] b = new char [a.length];
        int s = 0;
        int e = a.length-1;
        for (char i : a){
            //ascii 65-89 97-122
            if (i>=97){
                b[e]=i;
                e--;
            }else {
                b[s]=i;
                s++;
            }
        }
        System.out.println("排序后:"+ Arrays.toString(b));
    }

    public static void exam1_1(char [] a){
        System.out.println("排序前:"+ Arrays.toString(a));
        //使用原地排序
        //当s=e的时候就应该停止了，所以这里有条件判断失误的地方
        int s = 0;
        int e = a.length-1;
        while (s<e){
            while(s<e&&a[s]>=97){
                s++;
            }
            while(s<e&&a[e]<97){
                e--;
            }
            swap(a,s,e);
        }
        System.out.println("排序后:"+ Arrays.toString(a));
    }

    private static void swap(char[] a, int s, int e) {
        char temp = a[s];
        a[s] = a[e];
        a[e] = temp;
    }

    //练习：a 2 G 1 2 3 g A c a F  小写在前大写在后,数字在中间
    //这里可以进行两次原地排序，如果是数字和小写，放前面，大写放后面
    //然后再区分小写和数字
    public static void main(String[] args) {
        char [] a = {'a','G','g','A','c','a','F'};
        exam1_1(a);
        Arrays.sort(a);
//        Collections.sort();
    }
}
