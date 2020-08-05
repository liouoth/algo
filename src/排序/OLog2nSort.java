package 排序;

public class OLog2nSort {

    //
    private static void mergeSort(int [] a){

    }

    //分治思想，将数组进行切分
    private static void quickSort(int [] a,int s,int e){
        if (s==e)return;;
        int m = (s+e)/2;
        partitionSort(a,s,m);
        partitionSort(a,m+1,e);
    }
    private static void partitionSort(int [] a,int s,int e){

    }
}
