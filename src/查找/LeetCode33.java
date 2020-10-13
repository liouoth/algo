package 查找;

public class LeetCode33 {
    //You are given an integer array nums sorted in ascending order, and an integer target.
    //
    //Suppose that nums is rotated at some pivot unknown to you beforehand (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
    //
    //If target is found in the array return its index, otherwise, return -1.

    /**
     * 在一个循环有序的数组里，首先我们需要查找到两个循环数组的pivot，
     */
    public static int search(int[] nums, int target) {
        int low = 0;
        int mid = low;
        int high = nums.length - 1;
        //通过前后判断pivod，mid就是前一个有序数组的最后一个节点
        while (mid + 1 <= high) {
            if (nums[mid] < nums[mid + 1]) {
                mid++;
            } else {
                break;
            }
        }
        //两个数组，0-mid，mid+1-high ，当只有一个元素，low=0，high=0，mid=0
        if (target <= nums[mid] && target >= nums[low]) {
            return bSearch(nums, low, mid, target);
        } else if (mid+1<=high&& target >= nums[mid+1] && target <= nums[high]) {
            return bSearch(nums, mid+1, high, target);
        }
        return -1;
    }

    public static int bSearch(int[] nums,int l,int h, int target) {
        while (l<=h){
            int mid = l+((h-l)>>1);
            if (nums[mid]==target){
                return mid;
            }else if (nums[mid]>target){
                h = mid-1;
            }else {
                l = mid+1;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        int [] a = {1,3};
        System.out.println(search(a, 1));
    }

}
