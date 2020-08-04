package 排序;

import java.util.Arrays;

/**
 * 时间复杂度为O(n^2)的排序算法
 */
public class n2Sort {
    private static void bubbleSort(int[] a) {
        int length = a.length;
        /**
         * 万年易错点：关于边界确定，i<length 可以作为遍历的条件，索引最大值为length-1
         * bubbleSort每一次循环，保证最后一个元素是最大。
         * 所以第一层循环用于控制循环，第一次确定最后一个，第二次确认倒数第二个，这样最少就是length-1次，因为倒数第二次的时候，只有两个数
         * 第二层循环用于前后比较，控制条件是后面那位的索引小于确认好的索引
         * 结论：编写排序算法要确定循环意义、还有循环的边界值
         */
        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - 1 - i; j++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }
    }

    //插入排序，丑陋版本，使用了额外的存储空间
    private static int[] insertionSortUgly(int[] a) {
        int length = a.length;
        int size = 0;
        int[] b = new int[length];
        for (int i = 0; i < length; i++) {
            int index = 0;
            for (int j = 0; j<size; j++, index++) {
                if (a[i] < b[j]) {
                    index = j;
                    break;
                }
            }
            for (int c = length - 1; c > index; c--) {
                b[c] = b[c - 1];
            }
            b[index] = a[i];
            size++;
        }
        return b;
    }

    private static int[] selectionSort(int[] a) {
        int length = a.length;
        /**
         * 每一层循环确认 头元素是最小的
         * 所以一层循环用于确定循环次数，length-2次循环
         * 第二层用于头尾交换，终止条件为大于头元素得索引
         */
        for (int i = 0; i < length - 1; i++) {
            for (int j = length - 1; j > i; j--) {
                if (a[i] > a[j]) {
                    int temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] a = {2, 23, 4, 5, 6, 1};
        System.out.println("排序前：" + Arrays.toString(a));
//        bubbleSort(a);
//        System.out.println("冒泡排序后："+Arrays.toString(a));
//        SelectionSort(a);
//        System.out.println("选择排序后："+Arrays.toString(a));
        System.out.println("选择排序后：" + Arrays.toString(insertionSortUgly(a)));
    }

}
