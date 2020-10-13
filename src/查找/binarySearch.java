package 查找;

public class binarySearch {
    /**
     * 二分查找
     * low high
     * mid = （low+high）/2
     * 如果等于下标为mid的元素，那么直接返回
     * 如果大于mid的元素，那么low=mid+1
     * 如果小于mid的元素，那么high=mid-1
     *
     * 相当于通过类似分治的思想，划分范围，不断比较mid与查询数字的值
     * 直到low>high停止。
     * 例如n个元素进行2分查找，第一次n/2,第二次 n/4
     * 最多的查找次数k，n/2^k = 1 ，k=log2（n）
     */

    public static int query(int [] a,int q){
        int low = 0;
        int high = a.length-1;
        int mid = (low+high)/2;
        while (low<=high){
            if (a[mid]==q) {
                return q;
            }
            if (a[mid]<q){
                low=mid+1;
            }
            if (a[mid]>q){
                high=mid-1;
            }
            mid = (low+high)/2;
        }
        return -1;
    }

    public static void main(String[] args) {
        int [] a = {1,2,3,5,6,7};
        System.out.println(query(a, 1));
    }
}
