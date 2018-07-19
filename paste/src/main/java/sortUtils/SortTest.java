package sortUtils;

import javax.validation.constraints.NotNull;

/**
 * 参考链接:https://github.com/hustcc/JS-Sorting-Algorithm
 */
public class SortTest {
    public static void main(String[] args) throws Exception {
        int[] array={1,9,6,2,8,5,2,6,4};
        BubbleSort BubbleSort =new BubbleSort();
        InsertSort insertSort=new InsertSort();
        SelectSort selectSort=new SelectSort();
        QuickSort quickSort=new QuickSort();
        HeapSort heapSort=new HeapSort();
        MergeSort mergeSort=new MergeSort();
        int[] sortArray= mergeSort.sort(array);
        System.out.println("最终答案：");
        printIntArray((sortArray));



    }
    public static void printIntArray(@NotNull int[] array){
        for(int i=0;i<array.length;i++){
            System.out.print(" "+array[i]);
        }
        System.out.println();
    }

    public static void swap(@NotNull int[] array,int first,int second){
        int temp=array[first];
        array[first]=array[second];
        array[second]=temp;
    }

}
