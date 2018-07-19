package sortUtils;

import static sortUtils.SortTest.printIntArray;

/**
 * 动画演示：https://github.com/hustcc/JS-Sorting-Algorithm/blob/master/6.quickSort.md
 * */
public class QuickSort implements SortTemplate {
    @Override
    public int[] sort(int[] array) throws Exception {
        if (array == null || array.length <= 1) {
            return array;
        }
        return quickSort(array,0,array.length-1) ;
    }
    private int[] quickSort(int[] array,int left,int right){
        if(left<right){
            int partitionIndex=partition(array,left,right);
            quickSort(array,left,partitionIndex-1);
            quickSort(array,partitionIndex+1,right);
            printIntArray(array);
        }
        return array;

    }
    private int partition(int[] array,int left,int right){

        int pivot=left;
        int index=pivot+1;
        for(int i=index;i<=right;i++){
            if(array[i]<array[pivot]){
                swap(array,i,index);
                index++;
            }

        }
        swap(array,pivot,index-1);
        return index-1;
    }
    private void swap(int[] array,int first,int second){
        int temp=array[first];
        array[first]=array[second];
        array[second]=temp;
    }
}
