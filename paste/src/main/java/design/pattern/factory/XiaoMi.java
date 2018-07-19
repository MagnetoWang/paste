package design.pattern.factory;

/**
 * @program: paste
 * @description: 小米手机。最终的产品
 * @author: MagnetoWang
 * @create: 2018-07-19 18:41
 **/
public class XiaoMi implements AbstractPhone {
    @Override
    public void run() {
        System.out.println("正在生产小米手机");
        System.out.println("恭喜！成功生产小米手机");
    }
}
