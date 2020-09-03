package 排序;

import java.util.Arrays;

public class OLog2nSort {

    /**
     * 归并排序
     */
    private static void mergeSort(int[] a) {
        int[] merge = new int[a.length];
        mergeSort(a, 0, a.length - 1, merge);
    }

    private static void mergeSort(int[] a, int start, int end, int[] merge) {
        if (a == null || start >= end) {
            return;
        }
        int middle = (start + end) / 2;
        mergeSort(a, start, middle, merge);
        mergeSort(a, middle + 1, end, merge);
        merge(a, start, middle, end, merge);
    }

    private static void merge(int[] a, int start, int middle, int end, int[] merge) {
        int i = 0;
        int low = start, m = middle + 1;
        while (low <= middle && m <= end) {
            if (a[low] < a[m]) {
                merge[i++] = a[low++];
            } else {
                merge[i++] = a[m++];
            }
        }

        while (low <= middle) {
            merge[i++] = a[low++];
        }

        while (m <= end) {
            merge[i++] = a[m++];
        }

        for (int l = 0; l < i; l++) {
            a[start + l] = merge[l];
        }
    }


    /**
     * 快速排序
     */
    private static void quickSort(int[] a) {
        partitionSort(a, 0, a.length - 1);
    }

    private static void partitionSort(int[] a, int start, int end) {
        if (a == null || start >= end) {
            return;
        }
        int pivot = partition(a, start, end);
        //每次partition实际上pivot的位置已经是定格了
        partitionSort(a, start, pivot - 1);
        partitionSort(a, pivot + 1, end);
    }

    private static int partition(int[] a, int s, int e) {
        //挖洞填坑发，先把s上的元素赋值给pivot那么就多出了一个的s坑位
        int pivot = a[s]; //第一个元素作为pivot，其实是任意的
        while (s < e) {
            while (s < e && a[e] >= pivot) {
                e--;
            }
            a[s] = a[e];
            while (s < e && a[s] <= pivot) {
                s++;
            }
            a[e] = a[s];
        }
        a[s] = pivot;
        return s;
    }


    //quick sort test : partition and conquer
    private void quickSort(int [] a,int low,int high){
        if (a==null&&low>=high){
            return;
        }
        int pivot = partitionTest(a,low,high);
        quickSort(a,low,pivot);
        quickSort(a,pivot+1,high);
    }

    private int partitionTest(int[] a, int low, int high) {
        int pivot = a[low];
        //先将第一个数作为基数，然后从左到右找一个比pivot小的a[i]并赋值给 a[0],这样就多出一个坑，a[i]
        //然后从右到左找一个a[j]，比pivot小
        int i = low,j=high;
        while (low<=high){

        }
    }


    public static void main(String[] args) {
        int[] a = {3, 1, 4};
//        quickSort(a);
//        System.out.println(Arrays.toString(a));
        mergeSort(a);
        System.out.println(Arrays.toString(a));
    }


}
