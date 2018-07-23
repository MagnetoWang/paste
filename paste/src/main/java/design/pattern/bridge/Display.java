package design.pattern.bridge;

/**
 * @program: paste
 * @description: 显示字符串
 * @author: MagnetoWang
 * @create: 2018-07-23 15:06
 **/
public class Display {
        private DisplayImpl impl;
    public Display(DisplayImpl impl) {
        this.impl = impl;
    }
    public void open() {
        impl.rawOpen();
    }
    public void print() {
        impl.rawPrint();
    }
    public void close() {
        impl.rawClose();
    }
    public final void display() {
        open();
        print();
        close();
    }
}
