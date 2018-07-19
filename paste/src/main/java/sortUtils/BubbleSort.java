package sortUtils;


import javax.validation.constraints.NotNull;

import static sortUtils.SortTest.printIntArray;

/**
 * 参考链接：https://github.com/hustcc/JS-Sorting-Algorithm/blob/master/1.bubbleSort.md
 */
public class BubbleSort implements SortTemplate {
    @Override
    public int[] sort(@NotNull int[] array) {
        if(array==null||array.length<=1){
            return array;
        }

        int begin=1;
        int end=array.length-1;
        for(int i=end;i>=1;i--){
            // 设定一个标记，若为true，则表示此次循环没有进行交换，也就是待排序列已经有序，排序已经完成。
            boolean flag = true;
            for(int j=begin;j<=i;j++){
                if(array[j]<array[j-1]){
                    int t=array[j-1];
                    array[j-1]=array[j];
                    array[j]=t;
                    flag=false;
                }
            }
            printIntArray(array);
            if(flag==true){
                break;
            }
        }
        return array;
    }
}
