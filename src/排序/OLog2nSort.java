package 排序;

import java.util.Arrays;

public class OLog2nSort {

    /**
     * 归并排序
     */
    private static void mergeSort(int l,int h,int [] a,int [] b){
        if (a!=null&&l>=h){
            return;
        }
        //卧槽没想到 我的错点 竟然是这里,a 与 b的中位可以表达成，(a+b)/2
        //如果a与b是非常大的数，那么为了防止溢出，可以表达成 a+(b-a)/2 同样是a/2+b/2
        int m = l+((h-l)>>1);
        mergeSort(l,m,a,b);
        mergeSort(m+1,h,a,b);
        merge(l,m,h,a,b);
    }

    private static void merge(int l,int m, int h, int[] a,int [] b) {
        int start = l;
        int i=l,j=m+1;
        while (i<=m&&j<=h){
            b[l++] = a[j]<a[i]?a[j++]:a[i++];
        }
        while (i<=m){
            b[l++] = a[i++];
        }
        while (j<=h){
            b[l++] = a[j++];
        }

        while(start<l){
            a[start] = b[start++];
        }
    }

    private static void mergeSortTest(){
        int [] a = {3,2,4,2,1};
        int [] b = new int [5];
        System.out.println("排序前："+Arrays.toString(a));
        mergeSort(0,4,a,b);
        System.out.println("排序后："+Arrays.toString(a));
    }

    /**
     * 快速排序
     */
    private static void quickSortTest(){
        int [] a = {3,2,4,2,1};
        System.out.println("排序前："+Arrays.toString(a));
        quickSort(0,4,a);
        System.out.println("排序后："+Arrays.toString(a));
    }

    private static void quickSort(int l, int h, int[] a) {
        if (a==null||l>=h){
            return;
        }
        int m = partition(l,h,a);
        quickSort(l,m,a);
        quickSort(m+1,h,a);
    }

    private static int partition(int l, int h, int[] a) {
        int i = l,j=h;
        int pivot = a[i];
        while (i<j){
            while (i<j&&a[j]>=pivot){
                j--;
            }
            a[i] = a[j];

            while (i<j&&a[i]<=pivot){
                i++;
            }
            a[j] = a[i];
        }
        a[i] = pivot;
        return i;
    }

    public static void main(String[] args) {
//        mergeSortTest();
        quickSortTest();
    }
}
