package design.pattern.prototype.framework;

import design.pattern.prototype.MessageBox;
import design.pattern.prototype.UnderlinePen;

/**
 * @program: paste
 * @description: 执行原型模式的类
 * @author: MagnetoWang
 * @create: 2018-07-19 21:13
 **/
public class Main {
    public static void main(String[] args) {
        // 准备
        Manager manager = new Manager();
        UnderlinePen upen = new UnderlinePen('~');
        MessageBox mbox = new MessageBox('*');
        MessageBox sbox = new MessageBox('/');
        manager.register("strong message", upen);
        manager.register("warning box", mbox);
        manager.register("slash box", sbox);

        // 生成
        Product p1 = manager.create("strong message");
        p1.use("Hello, world.");
        Product p2 = manager.create("warning box");
        p2.use("Hello, world.");
        Product p3 = manager.create("slash box");
        p3.use("Hello, world.");
    }
}
