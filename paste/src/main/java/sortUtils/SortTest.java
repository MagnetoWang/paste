package sortUtils;

import javax.validation.constraints.NotNull;

public class SortTest {
    public static void main(String[] args) throws Exception {
        int[] array={1,9,6,2,8,5,2,6,4};
        BubbleSort BubbleSort =new BubbleSort();
        InsertSort insertSort=new InsertSort();
        SelectSort selectSort=new SelectSort();
        int[] sortArray= selectSort.sort(array);



    }
    public static void printIntArray(@NotNull int[] array){
        for(int i=0;i<array.length;i++){
            System.out.print(" "+array[i]);
        }
        System.out.println();
    }

}
