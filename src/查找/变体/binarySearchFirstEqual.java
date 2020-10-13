package 查找.变体;

public class binarySearchFirstEqual {
    /**
     * 二分查找变体
     * 常规：查找第一个等于定值的元素
     * 查找最后一个值等于给定值的元素
     * 查找第一个大于等于等值的元素
     * 查找最后一个小于等于定制的元素
     */
    //查找第一个等于定制的元素，先查找出元素，然后再通过元素的下标往前遍历
    public static int queryFirstEqual(int[] a, int q) {
        int low = 0;
        int index = -1;
        int high = a.length - 1;
        int mid = (low + high) / 2;
        while (low <= high) {
            if (a[mid] == q) {
                index = mid;
                break;
            }
            if (a[mid] < q) {
                low = mid + 1;
            }
            if (a[mid] > q) {
                high = mid - 1;
            }
            mid = (low + high) / 2;
        }

        //效率 不太高的写法
        if (index != -1 && index > 0) {
            for (int j = index; j >= 0; j--) {
                if (a[j] == q) {
                    index = j;
                }
            }
        }
        return index;
    }

    //难理解的一种写法
    public static int bsearch(int[] a, int n, int value) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (a[mid] >= value) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        if (low < n && a[low] == value) return low;
        else return -1;
    }

    //更通俗易懂
    public static int bsearchFirstEqual(int[] a, int n, int value) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (a[mid] > value) {
                high = mid - 1;
            } else if (a[mid] < value)
            {
                low = mid + 1;
            }else {
                //这是mid就等于我们查询的value，这个判断mid是否等于0，可以规避mid-1带来的数组越界
                if (mid==0||a[mid-1]!=value)return mid;
                //那么mid-1和low之间肯定有一个数还等于value
                high = mid-1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 2, 3, 5, 6, 7};
        System.out.println(bsearch(a, a.length,3));
    }

}
