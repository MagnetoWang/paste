package sortUtils;

import javax.validation.constraints.NotNull;

import static sortUtils.SortTest.printIntArray;

public class InsertSort implements SortTemplate {

    @Override
    public int[] sort(@NotNull int[] array) throws Exception {
        if (array == null || array.length <= 1) {
            return array;
        }
        for (int i = 1; i < array.length; i++) {
            for (int j = i; j > 0; j--) {
                if (array[j] < array[j - 1]) {
                    int t = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = t;
                }
            }
            printIntArray(array);



        }
        return array;
    }
}
