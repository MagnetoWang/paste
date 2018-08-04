package math;

/**
 * @program: paste
 * @description: 数学相关的包
 * @author: MagnetoWang
 * @create: 2018-08-04 20:01
 **/
public class math {
    public static boolean isSqure(int n)
    {
        double fsqrt = Math.sqrt(n);//先将数开平方
        int m = (int) fsqrt;//转换成整数
        return m*m == n;//把开平方后的整数再平方，看看他和开平方之前的数是不是相等
    }
}
