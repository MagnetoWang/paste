package design.pattern.adapter;

/**
 * @program: paste
 * @description: 执行适配器模式类
 * @author: MagnetoWang
 * @create: 2018-07-23 13:39
 **/
public class Main{
    public static void main(String[] args) {
        Print p = new PrintBanner("Hello");
        p.printWeak();
        p.printStrong();
    }
}
