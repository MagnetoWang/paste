package design.pattern.factory;

/**
 * @program: paste
 * @description: iphone手机类型。也就是我们最终的产品
 * @author: MagnetoWang
 * @create: 2018-07-19 18:40
 **/
public class IPhone implements AbstractPhone{
    @Override
    public void run() {
        System.out.println("正在生产IPhone手机");
        System.out.println("恭喜！成功生产IPhone手机");
    }
}
