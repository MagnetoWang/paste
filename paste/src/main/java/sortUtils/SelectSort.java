package sortUtils;

import static sortUtils.SortTest.printIntArray;

/**
 * 动画演示：https://github.com/hustcc/JS-Sorting-Algorithm/blob/master/2.selectionSort.md
 */
public class SelectSort implements  SortTemplate {

    @Override
    public int[] sort(int[] array) throws Exception {
        if (array == null || array.length <= 1) {
            return array;
        }
        for(int i=0;i<array.length-1;i++){
            int min=i;
            for(int j=i+1;j<array.length;j++){
                if(array[min]>array[j]){
                    min=j;
                }
            }
            int t = array[min];
            array[min] = array[i];
            array[i] = t;
            printIntArray(array);
        }
        return array;
    }
}
