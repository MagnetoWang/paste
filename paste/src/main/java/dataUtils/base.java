package dataUtils;

/**
 * @Author wangzixian
 * @Description TODO
 * @Date 2019/10/18 20:44
 **/
public class base {
    public static void main(String[] args) {
        Integer i = 10;
        Object e = i;
        System.out.println(e);

        // 这样不能转换，语法报错
//        Data<Integer> in = new Data<>();
//        Data<Object> on = in;

    }
}

class Data<T> {
    public T value;
}