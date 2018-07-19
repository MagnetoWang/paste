package sortUtils;

import static sortUtils.SortTest.swap;

/**
 * @program: paste
 * @description: 堆排序算法
 * @author: MagnetoWang
 * @create: 2018-07-19 12:04
 **/
public class HeapSort implements SortTemplate {
    @Override
    public int[] sort(int[] array) throws Exception {
        if (array == null || array.length <= 1) {
            return array;
        }
        int len = array.length;

        buildMaxHeap(array, len);

        for (int i = len - 1; i > 0; i--) {
            swap(array, 0, i);
            len--;
            heapify(array, 0, len);
        }
        return array;
    }


    private void heapify(int[] array,int index,int len){
        int left=2*index;
        int right=2*index+1;
        int max=index;
        if(left<len&&array[max]<array[left]){

            max=left;
        }
        if(right<len&&array[max]<array[right]){

            max=right;
        }
        if(max!=index){
            swap(array,max,index);
            heapify(array,max,len);
        }


    }



    private void buildMaxHeap(int[] array,int len){
        for(int i=(int)Math.floor(len/2);i>=0;i--){
            heapify(array,i,len);
        }

    }
}
