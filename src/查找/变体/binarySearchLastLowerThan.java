package 查找.变体;

public class binarySearchLastLowerThan {
    /**
     * 二分查找变体
     * 常规：查找第一个等于定值的元素
     * 查找最后一个值等于给定值的元素
     * 查找第一个大于等于等值的元素
     * 查找最后一个小于等于定制的元素
     */

    /**
     * 查找最后一个小于等于定制的元素
     * 首先判断
     */
    public static int binarySearchLastLowerThan(int[] a, int q) {
        int low = 0;
        int high = a.length - 1;
        while (low <= high) {
            int mid = low+((high-low)>>1);
            //如果mid大于指定值，那么一定在0到mid-1
            if (a[mid]>q){
                high = mid-1;
            }else {
                if (mid==high||a[mid+1]>q)return mid;
                low = mid+1;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        int[] a = {1, 2, 2, 3, 3, 6, 7};
        System.out.println(binarySearchLastLowerThan(a, 3));
    }

}
