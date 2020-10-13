package 查找.变体;

public class binarySearchFirstGreatThan {
    /**
     * 二分查找变体
     * 常规：查找第一个等于定值的元素
     * 查找最后一个值等于给定值的元素
     * 查找第一个大于等于等值的元素
     * 查找最后一个小于等于定制的元素
     */

    /**
     * 查查找第一个大于等于等值的元素
     * 首先判断
     */
    public static int binarySearchFirstGreatThan(int[] a, int q) {
        int low = 0;
        int high = a.length - 1;
        while (low <= high) {
            //位运算的优先级是非常低的,低于加减
            int mid = low + ((high - low) >> 1);
            //如果mid的元素是大于q，那么答案就在low-mid中间，包含mid
            //如果mid是小于q，那么非常简单一定是再mid+1 high中间
            if (a[mid]<q){
                low = mid+1;
            }else {
                if (mid==0||a[mid-1]<q)return mid;
                high = mid-1;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        int[] a = {1, 2, 2, 3, 3, 6, 7};
        System.out.println(binarySearchFirstGreatThan(a, 3));
    }

}
