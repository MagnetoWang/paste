package sortUtils;

import java.util.Arrays;

/**
 * @program: paste
 * @description: 希尔排序算法
 * @create: 2018-07-19 12:14
 * 源码链接：https://github.com/hustcc/JS-Sorting-Algorithm/blob/master/src/java/main/ShellSort.java
 **/
public class ShellSort implements SortTemplate{
    @Override
    public int[] sort(int[] sourceArray) throws Exception {
        // 对 arr 进行拷贝，不改变参数内容
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);

        int gap = 1;
        while (gap < arr.length) {
            gap = gap * 3 + 1;
        }

        while (gap > 0) {
            for (int i = gap; i < arr.length; i++) {
                int tmp = arr[i];
                int j = i - gap;
                while (j >= 0 && arr[j] > tmp) {
                    arr[j + gap] = arr[j];
                    j -= gap;
                }
                arr[j + gap] = tmp;
            }
            gap = (int) Math.floor(gap / 3);
        }

        return arr;
    }
}
