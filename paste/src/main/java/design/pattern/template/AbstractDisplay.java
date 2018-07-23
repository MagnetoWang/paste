package design.pattern.template;

/**
 * @program: paste
 * @description: 模板模式
 * @author: MagnetoWang
 * @create: 2018-07-23 11:52
 **/
public abstract class AbstractDisplay {
    public abstract void open();        // 交给子类去实现的抽象方法(1) open
    public abstract void print();       // 交给子类去实现的抽象方法(2) print
    public abstract void close();       // 交给子类去实现的抽象方法(3) close
    public final void display() {       // 本抽象类中实现的display方法
        open();                         // 首先打开…
        for (int i = 0; i < 5; i++) {   // 循环调用5次print
            print();
        }
        close();                        // …最后关闭。这就是display方法所实现的功能
    }
}
